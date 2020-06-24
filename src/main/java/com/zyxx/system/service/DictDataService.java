package com.zyxx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyxx.common.entity.LayuiTable;
import com.zyxx.system.entity.DictData;

/**
 * 字典数据表 Service接口
 *
 * @author Tellsea
 * @date 2020-06-23
 */
public interface DictDataService extends IService<DictData> {

    LayuiTable listDictDataByTable(DictData dictData);

    DictData getDictDataByTypeAndValue(DictData dictData);
}
