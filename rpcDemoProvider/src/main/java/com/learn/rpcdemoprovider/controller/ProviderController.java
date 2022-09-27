package com.learn.rpcdemoprovider.controller;

import com.learn.entity.Result;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * ProviderCpntroller
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/1
 */
@RestController
@RequestMapping("/demo")
public class ProviderController {

    @GetMapping("/test")
    public Result<Boolean> test(){
        Result<Boolean> result = new Result<>();
        result.setResult(true);
        result.setMsg("请求成功");
        result.setCode(100);
        return result;
    }

    @GetMapping("/print")
    public Result<String> print(@RequestParam("input") String input){
        Result<String> result = new Result<>();
        result.setResult(input);
        result.setMsg("请求成功");
        result.setCode(100);
        return result;
    }

}
