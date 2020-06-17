package com.zyxx.common.entity;

import com.zyxx.common.enums.StatusEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表格对象
 *
 * @author Tellsea
 * @date 2020/4/4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LayuiTable {

    /**
     * 0 为成功
     */
    private int code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 总条数
     */
    private int count;

    /**
     * 数据
     */
    private Object data;

    public static LayuiTable build(int count, Object data) {
        LayuiTable table = new LayuiTable();
        table.code = StatusEnums.LAYUI_SUCCESS.getCode();
        table.msg = StatusEnums.LAYUI_SUCCESS.getInfo();
        table.count = count;
        table.data = data;
        return table;
    }
}
