package com.learn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * Order
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/26
 */
@Data
@TableName("tb_order")
public class Order {
    @TableId(type = IdType.AUTO)
    private Integer id;
    //订单名称
    private String name;
    //商品id
    private Integer goodsId;
    //用户id
    private Integer userId;
    //商品数量
    private Integer nums;
    //商品金额
    private Integer money;
    //地址
    private String address;
    //下单时间
    private Date createTime;
}
