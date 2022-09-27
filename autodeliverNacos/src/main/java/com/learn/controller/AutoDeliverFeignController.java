package com.learn.controller;

import com.learn.controller.feign.UserServiceFeignClient;
import com.learn.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
>>>>>>> 1092225e8298c03b514632e7c1f8db15bc139492

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * AutoDeliverFeignController
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/17
 */
@RestController
@RequestMapping("/autoDeliver")
public class AutoDeliverFeignController {

    @Autowired
    private UserServiceFeignClient userServiceFeignClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findOpenStatusByUid")
    public Integer findOpenStatusByUid(@RequestParam("uid") Integer uid){
        //表面上是调用本地方法，实际上feign帮我们拼接url访问远程方法
        UserInfo userInfo = userServiceFeignClient.findUserById(uid);

        //ribbon测试
        //String url = "http://user/user/findUserById?id="+uid;
        //System.out.println("############URL##########:"+url);
        //UserInfo forObject = restTemplate.getForObject(url, UserInfo.class);
        //UserInfo userInfo = restTemplate.getForObject(url, UserInfo.class);

        return userInfo.getOpen();
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/testServiceFind")
    public Integer testServiceFind(){
        /*1.从Nacos Server中获取关注的那个服务的实例信息即服务发现*/
        List<ServiceInstance> user = discoveryClient.getInstances("user");
        /*2.如果有多个实例选择一个来使用(负载均衡)*/
        ServiceInstance serviceInstance = user.get(0);
        /*3.从元数据信息获取host port*/
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = "http://"+host+":"+port+"/user/findUserById";
        System.out.println("############URL##########:"+url);
        return 111;
    }

    @GetMapping("/testNacosResponse")
    public void testNacosResponse(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Probe-Modify-Response","123");
        request.setAttribute("content", "###newResult###");
    }


}
