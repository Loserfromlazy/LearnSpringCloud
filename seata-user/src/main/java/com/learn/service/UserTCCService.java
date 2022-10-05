package com.learn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.entity.Result;
import com.learn.entity.User;
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
public interface UserTCCService extends IService<User> {
    @TwoPhaseBusinessAction(name = "addPoints",commitMethod = "commitPoints",rollbackMethod = "rollbackPoints")
    Result<Boolean> addPoints(@BusinessActionContextParameter(paramName = "id")Integer id, Integer points);

    //这里返回值必须为boolean
    boolean commitPoints(BusinessActionContext context);
    //这里返回值必须为boolean
    boolean rollbackPoints(BusinessActionContext context);
}
