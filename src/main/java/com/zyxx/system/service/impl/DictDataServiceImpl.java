package com.zyxx.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyxx.common.consts.SqlPool;
import com.zyxx.common.entity.LayuiTable;
import com.zyxx.system.entity.DictData;
import com.zyxx.system.mapper.DictDataMapper;
import com.zyxx.system.service.DictDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 字典数据表 Service接口实现类
 *
 * @author Tellsea
 * @date 2020-06-23
 */
@Service
public class DictDataServiceImpl extends ServiceImpl<DictDataMapper, DictData> implements DictDataService {

    @Override
    public LayuiTable listDictDataByTable(DictData dictData) {
        LambdaQueryWrapper<DictData> wrapper = new LambdaQueryWrapper<DictData>()
                .eq(DictData::getStatus, SqlPool.STATUS_NORMAL)
                .orderByAsc(DictData::getSort)
                .orderByDesc(DictData::getCreateTime);
        if (StringUtils.isNotEmpty(dictData.getText())) {
            wrapper.like(DictData::getText, dictData.getText());
        }
        if (StringUtils.isNotEmpty(dictData.getValue())) {
            wrapper.like(DictData::getValue, dictData.getValue());
        }
        Page<DictData> page = this.getBaseMapper().selectPage(new Page<>(dictData.getPage(), dictData.getLimit()), wrapper);
        return LayuiTable.build((int) page.getTotal(), page.getRecords());
    }

    @Override
    public DictData getDictDataByTypeAndValue(DictData dictData) {
        return this.getBaseMapper().selectOne(new LambdaQueryWrapper<DictData>()
                .eq(DictData::getType, dictData.getType())
                .eq(DictData::getValue, dictData.getValue())
                .eq(DictData::getStatus, SqlPool.STATUS_NORMAL)
        );
    }
}
