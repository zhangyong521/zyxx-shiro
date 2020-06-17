package com.zyxx.system.service.impl;

import com.zyxx.common.entity.LayuiTable;
import com.zyxx.system.entity.LoginLog;
import com.zyxx.system.mapper.LoginLogMapper;
import com.zyxx.system.service.LoginLogService;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Service接口实现类
 *
 * @author Tellsea
 * @date 2020-03-29
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {

    @Override
    public LayuiTable listLoginLogByTable(LoginLog loginLog) {
        return LayuiTable.build(this.baseMapper.countByTable(loginLog), this.baseMapper.listByTable(loginLog));
    }

    @Override
    public int deleteLoginLogByIds(String ids) {
        List<String> list = Arrays.asList(ids.split(StringPool.COMMA));
        return this.baseMapper.deleteBatchIds(list);
    }
}
