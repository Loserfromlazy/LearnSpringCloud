package com.learn.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * <p>
 * SentinelFallback
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/27
 */
public class SentinelFallback {

    public static Integer handleException(Integer uid, BlockException blockException) {
        return -100;
    }
    public static Integer handleError(Integer uid) {
        return -500;
    }
}
