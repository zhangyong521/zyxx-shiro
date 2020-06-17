package com.zyxx.backup.controller;

import com.zyxx.backup.entity.MysqlDump;
import com.zyxx.backup.service.DataBaseService;
import com.zyxx.common.annotation.Log;
import com.zyxx.common.entity.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据库连接接口
 *
 * @author Tellsea
 * @date 2020-4-27
 */
@Api(tags = "数据库连接接口")
@RestController
@RequestMapping("/backup/dataBase")
public class DataBaseController {

    @Autowired
    private DataBaseService dataBaseService;

    @Log("获得所有数据库")
    @PostMapping("/connection")
    public ResponseResult connection(MysqlDump mysqlDump) {
        return ResponseResult.success(dataBaseService.connection(mysqlDump));
    }

    @Log("获得数据库的所有表")
    @PostMapping("/getTableList")
    public ResponseResult getTableList(MysqlDump mysqlDump) {
        return ResponseResult.success(dataBaseService.getTableList(mysqlDump));
    }
}
