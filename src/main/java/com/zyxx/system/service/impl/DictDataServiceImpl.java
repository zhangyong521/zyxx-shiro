package com.zyxx.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyxx.common.consts.SqlPool;
import com.zyxx.system.entity.DictData;
import com.zyxx.system.mapper.DictDataMapper;
import com.zyxx.system.service.DictDataService;
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
    public DictData getDictDataByTypeAndValue(DictData dictData) {
        return this.getBaseMapper().selectOne(new LambdaQueryWrapper<DictData>()
                .eq(DictData::getType, dictData.getType())
                .eq(DictData::getValue, dictData.getValue())
                .eq(DictData::getStatus, SqlPool.STATUS_NORMAL)
        );
    }
}
