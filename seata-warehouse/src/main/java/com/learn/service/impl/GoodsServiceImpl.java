package com.learn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.entity.Goods;
import com.learn.entity.Result;
import com.learn.mapper.GoodsMapper;
import com.learn.service.GoodsService;
import com.learn.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * GoodsServiceImpl
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/27
 */
@Service
@Slf4j
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public Result<Boolean> reduceGoods(Integer id, Integer nums) {
        Goods goodsSelect = goodsMapper.selectById(id);
        Goods goods = new Goods();
        goods.setId(id);
        int nowNums = goodsSelect.getNums() - nums;
        if (nowNums<0){
            log.error("库存不够，无法购买");
            return ResultUtils.resultInit(0,"库存不够，无法购买",false);
        }
        goods.setNums(nowNums);
        int updateById = goodsMapper.updateById(goods);
        if (updateById<0){
            ResultUtils.resultInit(0,"更新库存失败",false);
        }
        return ResultUtils.successBuild(true);
    }
}
