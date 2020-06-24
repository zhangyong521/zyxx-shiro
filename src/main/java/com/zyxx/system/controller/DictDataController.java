package com.zyxx.system.controller;

import com.zyxx.common.annotation.Log;
import com.zyxx.common.entity.ResponseResult;
import com.zyxx.common.enums.CrudEnums;
import com.zyxx.common.exception.CrudException;
import com.zyxx.system.entity.DictData;
import com.zyxx.system.service.DictDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 字典数据表 控制器
 *
 * @author Tellsea
 * @date 2020-06-23
 */
@Api(tags = "字典数据表接口")
@RestController
@RequestMapping("/system/dictData")
public class DictDataController {

    @Autowired
    private DictDataService dictDataService;

    @ApiOperation("数据表格")
    @PostMapping("listByTable")
    public ResponseResult listByTable(DictData dictData) {
        return ResponseResult.table(dictDataService.listDictDataByTable(dictData));
    }

    @Log("新增字典数据")
    @ApiOperation("新增字典数据")
    @PostMapping("save")
    public ResponseResult save(DictData dictData) throws CrudException {
        return ResponseResult.verifyBoolean(CrudEnums.SAVE, dictDataService.save(dictData));
    }

    @Log("更新字典数据")
    @ApiOperation("更新字典数据")
    @PostMapping("updateById")
    public ResponseResult updateById(DictData dictData) throws CrudException {
        return ResponseResult.verifyBoolean(CrudEnums.UPDATE, dictDataService.updateById(dictData));
    }

    @Log("更新字典数据状态")
    @ApiOperation("更新字典数据状态")
    @PostMapping("updateStatus")
    public ResponseResult updateStatus(DictData dictData) throws CrudException {
        return ResponseResult.verifyBoolean(CrudEnums.DELETE, dictDataService.updateById(dictData));
    }
}
