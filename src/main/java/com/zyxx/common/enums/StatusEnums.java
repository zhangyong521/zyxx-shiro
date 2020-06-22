package com.zyxx.common.enums;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * 异常枚举类
 *
 * @author Tellsea
 * @date 2019/7/13
 */
@AllArgsConstructor
public enum StatusEnums implements BaseEnums {

    LAYUI_SUCCESS(0, "OK"),
    OK(200, "OK"),
    SAVE_SUCCESS(200, "新增成功"),
    DELETE_SUCCESS(200, "删除成功"),
    UPDATE_SUCCESS(200, "更新成功"),
    SELECT_SUCCESS(200, "查询成功"),

    SAVE_ERROR(500, "新增失败!"),
    DELETE_ERROR(500, "删除失败!"),
    UPDATE_ERROR(500, "更新失败!"),
    SELECT_ERROR(500, "查询失败!"),
    SERVER_ERROR(500, "服务器错误，请稍后重试!"),

    CAPTCHA_ERROR(500, "验证码错误!"),
    UNAUTHORIZED(403, "未授权!"),
    LOGIN_FAILURE_ERROR(403, "登录认证失效，请重新登录!"),
    NOT_FOUND(404, "请求资源不存在!"),
    USER_NOT_FOUND(500, "用户不存在!"),
    PARAM_NOT_NULL(500, "参数不能为空!"),
    PASSWORD_ERROR(500, "密码错误!"),
    LOCKED_ACCOUNT_ERROR(500, "该账户已经被锁定，请联系管理员!"),
    ;

    @Setter
    private int code;

    @Setter
    private String info;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getInfo() {
        return info;
    }
}
