package com.learn.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * OrderController
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/31
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/testFunc")
    public String testFunc(String application,long id){
        initFlowRules();
        //ContextUtil.enter("user-center",application);

        Entry entry = null;
        try {
            entry = SphU.entry("testFunc", EntryType.IN);
            /*您的业务逻辑 - 开始*/
            System.out.println("hello world");
            return getOrderName(id);
            /*您的业务逻辑 - 结束*/
        } catch (BlockException e1) {
            /*流控逻辑处理 - 开始*/
            System.out.println("block!");
            throw new RuntimeException("系统繁忙");
            /*流控逻辑处理 - 结束*/
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }

    }

    public String getOrderName(long id){
        Entry entry = null;
        try {
            entry = SphU.entry("getOrderName");
            /*您的业务逻辑 - 开始*/
            return "BuySomething";
            /*您的业务逻辑 - 结束*/
        } catch (BlockException e1) {
            /*流控逻辑处理 - 开始*/
            return null;
            /*流控逻辑处理 - 结束*/
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("testFunc");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

}
