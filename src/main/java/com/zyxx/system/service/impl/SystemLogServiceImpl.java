package com.zyxx.system.service.impl;

import com.zyxx.common.entity.LayuiTable;
import com.zyxx.common.exception.CrudException;
import com.zyxx.system.entity.SystemLog;
import com.zyxx.system.mapper.SystemLogMapper;
import com.zyxx.system.service.SystemLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 系统日志表 Service接口实现类
 *
 * @author Tellsea
 * @date 2020-03-04
 */
@Service
public class SystemLogServiceImpl extends ServiceImpl<SystemLogMapper, SystemLog> implements SystemLogService {

    @Override
    public LayuiTable listSystemLogByTable(SystemLog systemLog) {
        return LayuiTable.build(this.baseMapper.countSystemLogByTable(systemLog), this.baseMapper.listSystemLogByTable(systemLog));
    }

    @Override
    public int deleteSystemLogByIds(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        return this.baseMapper.deleteBatchIds(list);
    }

    @Override
    public void saveSystemLog(SystemLog systemLog) throws CrudException {
        int count = this.baseMapper.insert(systemLog);
        if (count == 0) {
            throw new CrudException("系统日志保存错误，未保存到数据库");
        }
    }
}
