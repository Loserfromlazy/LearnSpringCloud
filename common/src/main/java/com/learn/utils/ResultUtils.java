package com.learn.utils;

import com.learn.entity.Result;

/**
 * <p>
 * ResultUtils
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/2
 */
public class ResultUtils<T> {

    public static <T> Result<T> successBuild(T t){
        Result<T> result = new Result<>();
        result.setCode(1);
        result.setMsg("成功");
        result.setResult(t);
        return result;
    }

    public static <T> Result<T> resultInit(Integer code,String msg,T t){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setResult(t);
        return result;
    }
}
