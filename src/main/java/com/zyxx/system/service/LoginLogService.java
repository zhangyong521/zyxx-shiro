package com.zyxx.system.service;

import com.zyxx.common.entity.LayuiTable;
import com.zyxx.common.exception.CrudException;
import com.zyxx.system.entity.LoginLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *  Service接口
 *
 * @author Tellsea
 * @date 2020-03-29
 */
public interface LoginLogService extends IService<LoginLog> {

    LayuiTable listLoginLogByTable(LoginLog loginLog);

    int deleteLoginLogByIds(String ids) throws CrudException;
}
