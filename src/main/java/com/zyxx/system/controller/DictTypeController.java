package com.zyxx.system.controller;

import com.zyxx.common.annotation.Log;
import com.zyxx.common.entity.ResponseResult;
import com.zyxx.common.enums.CrudEnums;
import com.zyxx.common.exception.CrudException;
import com.zyxx.system.entity.DictType;
import com.zyxx.system.service.DictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 字典类型表 控制器
 *
 * @author Tellsea
 * @date 2020-06-23
 */
@Api(tags = "字典类型表接口")
@RestController
@RequestMapping("/system/dictType")
public class DictTypeController {

    @Autowired
    private DictTypeService dictTypeService;

    @ApiOperation("数据表格")
    @PostMapping("listByTable")
    public ResponseResult listByTable(DictType dictType) {
        return ResponseResult.table(dictTypeService.listDictTypeByTable(dictType));
    }

    @Log("新增字典类型")
    @ApiOperation("新增字典类型")
    @PostMapping("save")
    public ResponseResult save(DictType dictType) throws CrudException {
        return ResponseResult.verifyBoolean(CrudEnums.SAVE, dictTypeService.save(dictType));
    }

    @Log("更新字典类型")
    @ApiOperation("更新字典类型")
    @PostMapping("updateById")
    public ResponseResult updateById(DictType dictType) throws CrudException {
        return ResponseResult.verifyBoolean(CrudEnums.UPDATE, dictTypeService.updateById(dictType));
    }

    @Log("更新字典类型状态")
    @ApiOperation("更新字典类型状态")
    @PostMapping("updateStatus")
    public ResponseResult updateStatus(DictType dictType) throws CrudException {
        return ResponseResult.verifyBoolean(CrudEnums.DELETE, dictTypeService.updateById(dictType));
    }
}
