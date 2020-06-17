package com.zyxx.backup.service;

import com.zyxx.common.entity.LayuiTable;
import com.zyxx.backup.entity.MysqlRecover;

/**
 * 恢复 接口层
 *
 * @author Tellsea
 * @date 2020-4-25
 */
public interface MysqlRecoverService {

    boolean recover(MysqlRecover mysqlRecover);

    LayuiTable listMysqlRecover(MysqlRecover mysqlRecover);

    int deleteMysqlRecover(MysqlRecover mysqlRecover);
}
