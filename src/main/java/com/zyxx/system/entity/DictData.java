package com.zyxx.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.zyxx.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 字典数据表 实体类
 *
 * @author Tellsea
 * @date 2020-06-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("dict_data")
public class DictData  extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 字典编码
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 字典标签
     */
    @TableField("text")
    private String text;

    /**
     * 字典键值
     */
    @TableField("value")
    private String value;

    /**
     * 字典类型
     */
    @TableField("type")
    private String type;

    /**
     * 样式属性（其他样式扩展）
     */
    @TableField("css_class")
    private String cssClass;

    /**
     * 表格回显样式
     */
    @TableField("list_class")
    private String listClass;

    /**
     * 是否默认（Y是 N否）
     */
    @TableField("is_default")
    private Integer isDefault;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 字典排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 创建人
     */
    @TableField(value = "create_user",fill = FieldFill.INSERT)
    private Integer createUser;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 状态（1正常 2停用）
     */
    @TableField(value = "status", fill = FieldFill.INSERT)
    private Integer status;
}
