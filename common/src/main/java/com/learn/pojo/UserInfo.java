package com.learn.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * com.learn.pojo.UserInfo
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/8
 */
@Data
@TableName
public class UserInfo {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String sex;
    private Date birthday;
    private String phone;
    private String email;
    private String status;
    private String headPic;
    private Integer height;
    private Integer weight;
    @TableField("isOpen")
    private Integer open;
    @TableField("isDel")
    private Boolean del;
    private Integer refuseCount;
    private String oneWord;
    private String liveCity;
}
