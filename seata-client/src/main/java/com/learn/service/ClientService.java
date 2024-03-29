package com.learn.service;

import com.learn.entity.Result;

/**
 * <p>
 * ClientService
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/26
 */
public interface ClientService {

    /**
     * 买某物
     *
     * @param num     购买数量
     * @param userId  用户id
     * @param goodsId 货物id
     * @author Yuhaoran
     * @date 2022/9/26 15:51
     */
    Result<Boolean> buy(Integer num, Integer userId, Integer goodsId);
}
