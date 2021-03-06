package com.zyxx.common.entity;

import com.zyxx.common.enums.BaseEnums;
import com.zyxx.common.enums.CrudEnums;
import com.zyxx.common.enums.StatusEnums;
import com.zyxx.common.exception.CrudException;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 公共返回结果集
 *
 * @author Tellsea
 * @date 2020/3/3
 */
@Slf4j
@Data
@Accessors(chain = true)
public class ResponseResult implements Serializable {

    private int code;

    private String message;

    private int count;

    private Object data;

    public static ResponseResult success() {
        return new ResponseResult().setCode(StatusEnums.OK.getCode())
                .setMessage(StatusEnums.OK.getInfo());
    }

    public static ResponseResult success(Object data) {
        return new ResponseResult().setCode(StatusEnums.OK.getCode())
                .setMessage(StatusEnums.OK.getInfo())
                .setData(data);
    }

    public static ResponseResult successMsg(String message) {
        return new ResponseResult().setCode(StatusEnums.OK.getCode())
                .setMessage(message);
    }

    public static ResponseResult success(BaseEnums baseEnums) {
        return new ResponseResult().setCode(baseEnums.getCode())
                .setMessage(baseEnums.getInfo());
    }

    public static ResponseResult success(BaseEnums baseEnums, Object data) {
        return new ResponseResult().setCode(baseEnums.getCode())
                .setMessage(baseEnums.getInfo())
                .setData(data);
    }

    // 失败

    public static ResponseResult error() {
        return new ResponseResult().setCode(StatusEnums.SERVER_ERROR.getCode())
                .setMessage(StatusEnums.SERVER_ERROR.getInfo());
    }

    public static ResponseResult error(Object data) {
        return new ResponseResult().setCode(StatusEnums.SERVER_ERROR.getCode())
                .setMessage(StatusEnums.SERVER_ERROR.getInfo())
                .setData(data);
    }

    public static ResponseResult errorMsg(String message) {
        return new ResponseResult().setCode(StatusEnums.SERVER_ERROR.getCode())
                .setMessage(message);
    }

    public static ResponseResult error(BaseEnums baseEnums) {
        return new ResponseResult().setCode(baseEnums.getCode())
                .setMessage(baseEnums.getInfo());
    }

    public static ResponseResult error(BaseEnums baseEnums, Object data) {
        return new ResponseResult().setCode(baseEnums.getCode())
                .setMessage(baseEnums.getInfo())
                .setData(data);
    }

    public static ResponseResult table(LayuiTable layuiTable) {
        return new ResponseResult().setCode(StatusEnums.LAYUI_SUCCESS.getCode())
                .setMessage(StatusEnums.LAYUI_SUCCESS.getInfo())
                .setCount(layuiTable.getCount())
                .setData(layuiTable.getData());
    }

    public static ResponseResult build(int code, String message) {
        return new ResponseResult().setCode(code).setMessage(message);
    }

    public static ResponseResult verify(CrudEnums crudEnums, int count) throws CrudException {
        return count > 0 ? judgeSuccess(crudEnums) : judgeError(crudEnums);
    }

    public static ResponseResult verifyBoolean(boolean flag) {
        if (flag) {
            return ResponseResult.success();
        } else {
            return ResponseResult.error();
        }
    }

    public static ResponseResult verifyBoolean(CrudEnums crudEnums, boolean flag) {
        return flag ? judgeSuccess(crudEnums) : judgeError(crudEnums);
    }





    private static ResponseResult judgeSuccess(CrudEnums crudEnums) {
        if (crudEnums.getCode() == CrudEnums.SAVE.getCode()) {
            return success(StatusEnums.SAVE_SUCCESS);
        } else if (crudEnums.getCode() == CrudEnums.UPDATE.getCode()) {
            return success(StatusEnums.UPDATE_SUCCESS);
        } else if (crudEnums.getCode() == CrudEnums.DELETE.getCode()) {
            return success(StatusEnums.DELETE_SUCCESS);
        } else {
            return ResponseResult.success();
        }
    }

    private static ResponseResult judgeError(CrudEnums crudEnums) {
        if (crudEnums.getCode() == CrudEnums.SAVE.getCode()) {
            throw new CrudException(StatusEnums.SAVE_ERROR.getInfo());
        } else if (crudEnums.getCode() == CrudEnums.UPDATE.getCode()) {
            throw new CrudException(StatusEnums.UPDATE_ERROR.getInfo());
        } else if (crudEnums.getCode() == CrudEnums.DELETE.getCode()) {
            throw new CrudException(StatusEnums.DELETE_ERROR.getInfo());
        } else {
            return ResponseResult.error();
        }
    }
}
