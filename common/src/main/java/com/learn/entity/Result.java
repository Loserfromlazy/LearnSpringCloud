package com.learn.entity;

import lombok.Data;

/**
 * <p>
 * Result
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/1
 */
@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T result;
}
