package com.learn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.entity.Order;
import com.learn.entity.Result;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * <p>
 * OderService
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/27
 */
//声明此接口被seata管理，根据事务状态完成提交或回滚
@LocalTCC
public interface OrderTCCService extends IService<Order> {

    //声明try方法，其中name为全局唯一属性
    @TwoPhaseBusinessAction(name = "addOrder",commitMethod = "commitOrder",rollbackMethod = "rollbackOrder")
    Result<Boolean> addOrder(@BusinessActionContextParameter(paramName = "order") Order order);

    //这里返回值必须为boolean
    boolean commitOrder(BusinessActionContext context);
    //这里返回值必须为boolean
    boolean rollbackOrder(BusinessActionContext context);
}
