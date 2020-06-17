package com.zyxx.system.controller;

import com.zyxx.common.annotation.Log;
import com.zyxx.common.entity.ResponseResult;
import com.zyxx.common.enums.CrudEnums;
import com.zyxx.common.exception.CrudException;
import com.zyxx.system.entity.LoginLog;
import com.zyxx.system.service.LoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器
 *
 * @author Tellsea
 * @date 2020-03-29
 */
@Api(tags = "登录日志表接口")
@RestController
@RequestMapping("/system/loginLog")
public class LoginLogController {

    @Autowired
    private LoginLogService loginLogService;

    @ApiOperation("表格数据")
    @PostMapping("listByTable")
    public ResponseResult listByTable(LoginLog loginLog) {
        return ResponseResult.table(loginLogService.listLoginLogByTable(loginLog));
    }

    @Log("根据ids删除")
    @ApiOperation("根据ids删除")
    @PostMapping("deleteByIds")
    public ResponseResult deleteByIds(String ids) throws CrudException {
        return ResponseResult.verify(CrudEnums.DELETE, loginLogService.deleteLoginLogByIds(ids));
    }
}
