package com.zyxx.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyxx.common.consts.SqlPool;
import com.zyxx.common.entity.LayuiTable;
import com.zyxx.system.entity.DictType;
import com.zyxx.system.entity.ResourceInfo;
import com.zyxx.system.mapper.DictTypeMapper;
import com.zyxx.system.service.DictTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 字典类型表 Service接口实现类
 *
 * @author Tellsea
 * @date 2020-06-23
 */
@Service
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    @Override
    public LayuiTable listDictTypeByTable(DictType dictType) {
        LambdaQueryWrapper<DictType> wrapper = new LambdaQueryWrapper<DictType>()
                .eq(DictType::getStatus, SqlPool.STATUS_NORMAL)
                .orderByAsc(DictType::getSort)
                .orderByDesc(DictType::getCreateTime);
        if (StringUtils.isNotEmpty(dictType.getName())) {
            wrapper.like(DictType::getName, dictType.getName());
        }
        if (StringUtils.isNotEmpty(dictType.getType())) {
            wrapper.like(DictType::getType, dictType.getType());
        }
        Page<DictType> page = this.getBaseMapper().selectPage(new Page<>(dictType.getPage(), dictType.getLimit()), wrapper);
        return LayuiTable.build((int) page.getTotal(), page.getRecords());
    }
}
