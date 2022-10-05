package com.learn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.entity.Goods;
import com.learn.entity.Result;
import com.learn.mapper.GoodsMapper;
import com.learn.service.GoodsService;
import com.learn.service.GoodsTCCService;
import com.learn.utils.ResultUtils;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

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
public class GoodsTCCServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsTCCService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public Result<Boolean> reduceGoods(Integer id, Integer nums) {
        Goods goodsSelect = goodsMapper.selectById(id);
        Goods goods = new Goods();
        goods.setId(id);
        int nowNums = goodsSelect.getNums() - nums;
        if (nowNums < 0) {
            log.error("库存不够，无法购买");
            throw new RuntimeException("库存不足");
//            return ResultUtils.resultInit(0,"库存不够，无法购买",false);
        }
        goods.setSeataNums(nums);
        int updateById = goodsMapper.updateById(goods);
        if (updateById < 0) {
            throw new RuntimeException("更新库存失败");
//            return ResultUtils.resultInit(0,"更新库存失败",false);
        }
        log.info("扣减库存成功");
        return ResultUtils.successBuild(true);
    }

    @Override
    public boolean commitGoods(BusinessActionContext context) {
        Goods goods = goodsMapper.selectById((Serializable) context.getActionContext("id"));
        if (goods!=null){
            goods.setNums(goods.getNums()-goods.getSeataNums());
            goods.setSeataNums(0);
            goodsMapper.updateById(goods);
        }
        log.info("提交成功，xid={}",context.getXid());
        return true;
    }

    @Override
    public boolean rollbackGoods(BusinessActionContext context) {
        Goods goods = goodsMapper.selectById((Serializable) context.getActionContext("id"));
        if (goods!=null){
            goods.setSeataNums(0);
            goodsMapper.updateById(goods);
        }
        log.info("回滚成功，xid={}",context.getXid());
        return true;
    }
}
