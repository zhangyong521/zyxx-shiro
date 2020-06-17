package com.zyxx.backup.service;

import com.zyxx.backup.entity.MysqlDump;

import java.util.List;

/**
 * @author Tellsea
 * @date 2020-4-27
 */
public interface DataBaseService {

    List<String> connection(MysqlDump mysqlDump);

    List<String> getTableList(MysqlDump mysqlDump);
}
