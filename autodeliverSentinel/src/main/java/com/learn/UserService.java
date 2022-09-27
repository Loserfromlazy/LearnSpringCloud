package com.learn;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * <p>
 * UserService
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/8/15
 */
@Service
public class UserService {
    @SentinelResource("valid")
    public String validateID(){
        System.out.println("验证身份成功");
        return "验证身份成功";
    }
}
