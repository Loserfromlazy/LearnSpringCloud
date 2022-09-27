package com.learn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.entity.Goods;
import com.learn.entity.Result;

/**
 * <p>
 * UserService
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/27
 */
public interface GoodsService extends IService<Goods> {

    Result<Boolean> reduceGoods(Integer id, Integer nums);
}
