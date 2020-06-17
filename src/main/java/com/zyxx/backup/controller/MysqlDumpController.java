package com.zyxx.backup.controller;

import com.zyxx.common.annotation.Log;
import com.zyxx.common.entity.LayuiTable;
import com.zyxx.common.entity.ResponseResult;
import com.zyxx.common.enums.CrudEnums;
import com.zyxx.backup.entity.MysqlDump;
import com.zyxx.backup.service.MysqlDumpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Mysql 数据库备份 控制器
 *
 * @author Tellsea
 * @date 2020-4-22
 */
@Api(tags = "数据库备份")
@RestController
@RequestMapping("/backup/mysqlDump")
public class MysqlDumpController {

    @Autowired
    private MysqlDumpService mysqlDumpService;

    @ApiOperation("备份列表")
    @PostMapping("/list")
    public LayuiTable list(MysqlDump mysqlDump) {
        return mysqlDumpService.listMysqlDump(mysqlDump);
    }

    @Log("数据备份")
    @ApiOperation("数据备份")
    @PostMapping("/backup")
    public ResponseResult backup(MysqlDump mysqlDump) {
        return ResponseResult.verifyBoolean(mysqlDumpService.backup(mysqlDump));
    }

    @Log("数据备份")
    @ApiOperation("删除备份")
    @PostMapping("/delete")
    public ResponseResult delete(MysqlDump mysqlDump) {
        return ResponseResult.verify(CrudEnums.DELETE, mysqlDumpService.deleteMysqlDump(mysqlDump));
    }
}
