package com.zyxx.backup.service;

import com.zyxx.common.entity.LayuiTable;
import com.zyxx.backup.entity.MysqlDump;

import java.util.List;

/**
 * 备份 接口层
 *
 * @author Tellsea
 * @date 2020-4-22
 */
public interface MysqlDumpService {

    boolean backup(MysqlDump mysqlDump);

    List<MysqlDump> listMysqlDumpAll();

    LayuiTable listMysqlDump(MysqlDump mysqlDump);

    int deleteMysqlDump(MysqlDump mysqlDump);
}
