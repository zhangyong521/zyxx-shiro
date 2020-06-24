package com.zyxx.system.service;

import com.zyxx.common.entity.LayuiTable;
import com.zyxx.system.entity.DictType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 字典类型表 Service接口
 *
 * @author Tellsea
 * @date 2020-06-23
 */
public interface DictTypeService extends IService<DictType> {

    LayuiTable listDictTypeByTable(DictType dictType);
}
