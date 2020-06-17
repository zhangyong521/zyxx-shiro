package com.zyxx.system.entity;

import com.zyxx.common.entity.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 用户表 实体类
 *
 * @author Tellsea
 * @date 2020-03-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_info")
public class UserInfo extends BaseEntity {

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 账户，登录名，不可更改
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 盐值
     */
    @TableField("salt")
    private String salt;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 手机
     */
    @TableField("phone")
    private String phone;

    /**
     * 性别 1男 2女
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

    /**
     * 登录次数
     */
    @TableField("login_times")
    private Integer loginTimes;

    /**
     * 最后登录时间
     */
    @TableField("last_login_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    /**
     * 创建人
     */
    @TableField(value = "create_user",fill = FieldFill.INSERT)
    private Integer createUser;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 状态(1正常，2删除)
     */
    @TableField(value = "status", fill = FieldFill.INSERT)
    private Integer status;

    @TableField(exist = false)
    private String roleIds;

    @TableField(exist = false)
    private String roleName;

    @TableField(exist = false)
    private String createUserName;

    @TableField(exist = false)
    private Set<String> roles;

    @TableField(exist = false)
    private Set<String> permissions;

    @TableField(exist = false)
    private List<ResourceInfo> menus;
}
