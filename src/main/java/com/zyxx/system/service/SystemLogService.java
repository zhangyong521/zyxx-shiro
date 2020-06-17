package com.zyxx.system.service;

import com.zyxx.common.entity.LayuiTable;
import com.zyxx.common.exception.CrudException;
import com.zyxx.system.entity.SystemLog;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.scheduling.annotation.Async;

/**
 * 系统日志表 Service接口
 *
 * @author Tellsea
 * @date 2020-03-04
 */
public interface SystemLogService extends IService<SystemLog> {

    LayuiTable listSystemLogByTable(SystemLog systemLog);

    int deleteSystemLogByIds(String ids);

    @Async
    void saveSystemLog(SystemLog systemLog) throws CrudException;
}
