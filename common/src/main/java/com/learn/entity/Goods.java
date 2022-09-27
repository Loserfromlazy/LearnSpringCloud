package com.learn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 * Goods
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/26
 */
@Data
@TableName("tb_goods")
public class Goods {

    @TableId(type = IdType.AUTO)
    private Integer id;
    //商品名称
    private String name;
    //单价
    private Integer money;
    //库存
    private Integer nums;
}
