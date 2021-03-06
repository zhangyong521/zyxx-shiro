package com.zyxx.backup.service.impl;

import com.zyxx.common.entity.LayuiTable;
import com.zyxx.backup.consts.MysqlDumpConst;
import com.zyxx.backup.entity.MysqlRecover;
import com.zyxx.backup.mapper.MysqlRecoverMapper;
import com.zyxx.backup.service.MysqlRecoverService;
import com.zyxx.backup.util.MysqlUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Tellsea
 * @date 2020-4-25
 */
@Slf4j
@Service
public class MysqlRecoverServiceImpl extends ServiceImpl<MysqlRecoverMapper, MysqlRecover> implements MysqlRecoverService {

    @Override
    public boolean recover(MysqlRecover mysqlRecover) {
        StringBuilder arg = new StringBuilder();
        arg.append(MysqlUtils.getCommandPrefix());
        arg.append(" mysql");
        arg.append(" -h").append(mysqlRecover.getIp());
        arg.append(" -P").append(mysqlRecover.getPort());
        arg.append(" -u").append(mysqlRecover.getUserName());
        arg.append(" -p").append(mysqlRecover.getPassword());
        arg.append(" ").append(mysqlRecover.getDatabaseName());
        arg.append(" < ").append((MysqlDumpConst.SAVE_POSITION + mysqlRecover.getFilePath()));

        Process process = null;
        try {
            log.info("-------------------------------");
            log.info("执行恢复命令：{}", arg.toString());
            process = Runtime.getRuntime().exec(arg.toString());
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream(), "GBK"));
            String errorLine;
            while ((errorLine = br.readLine()) != null) {
                log.error(errorLine);
            }
            br.close();
            if (process.waitFor() == 0) {
                mysqlRecover.setCommand(arg.toString().replace("\\", "/"));
                this.getBaseMapper().insert(mysqlRecover);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            process.destroy();
        }
        return false;
    }

    @Override
    public LayuiTable listMysqlRecover(MysqlRecover mysqlRecover) {
        int count = this.getBaseMapper().countMysqlRecover(mysqlRecover);
        List<MysqlRecover> list = null;
        if (count > 0) {
            list = this.getBaseMapper().listMysqlRecover(mysqlRecover);
        }
        return LayuiTable.build(count, list);
    }

    @Override
    public int deleteMysqlRecover(MysqlRecover mysqlRecover) {
        return this.getBaseMapper().updateById(mysqlRecover);
    }
}
