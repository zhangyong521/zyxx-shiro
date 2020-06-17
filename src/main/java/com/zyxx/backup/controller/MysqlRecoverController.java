package com.zyxx.backup.controller;

import com.zyxx.backup.entity.MysqlRecover;
import com.zyxx.backup.service.MysqlRecoverService;
import com.zyxx.common.entity.LayuiTable;
import com.zyxx.common.entity.ResponseResult;
import com.zyxx.common.enums.CrudEnums;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据恢复
 *
 * @author Tellsea
 * @date 2020-4-25
 */
@Api(tags = "数据恢复")
@RestController
@RequestMapping("/backup/mysqlRecover")
public class MysqlRecoverController {

    @Autowired
    private MysqlRecoverService mysqlRecoverService;

    @ApiOperation("恢复列表")
    @PostMapping("/list")
    public LayuiTable list(MysqlRecover mysqlRecover) {
        return mysqlRecoverService.listMysqlRecover(mysqlRecover);
    }

    @ApiOperation("数据恢复")
    @PostMapping("/recover")
    public ResponseResult recover(MysqlRecover mysqlRecover) {
        return ResponseResult.verifyBoolean(mysqlRecoverService.recover(mysqlRecover));
    }

    @ApiOperation("删除恢复")
    @PostMapping("/delete")
    public ResponseResult delete(MysqlRecover mysqlRecover) {
        return ResponseResult.verify(CrudEnums.DELETE, mysqlRecoverService.deleteMysqlRecover(mysqlRecover));
    }
}
