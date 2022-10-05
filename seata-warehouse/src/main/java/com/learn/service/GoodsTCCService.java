package com.learn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.entity.Goods;
import com.learn.entity.Result;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * <p>
 * UserService
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/27
 */
@LocalTCC
public interface GoodsTCCService extends IService<Goods> {

    @TwoPhaseBusinessAction(name = "reduceGoods",commitMethod = "commitGoods",rollbackMethod = "rollbackGoods")
    Result<Boolean> reduceGoods(@BusinessActionContextParameter(paramName = "id")Integer id, Integer nums);

    //这里返回值必须为boolean
    boolean commitGoods(BusinessActionContext context);
    //这里返回值必须为boolean
    boolean rollbackGoods(BusinessActionContext context);
}
