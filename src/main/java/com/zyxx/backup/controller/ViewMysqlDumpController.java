package com.zyxx.backup.controller;

import com.zyxx.backup.service.MysqlDumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 数据备份模块视图
 *
 * @author Tellsea
 * @date 2020-6-12
 */
@Controller
@RequestMapping("/backup")
public class ViewMysqlDumpController {

    @Autowired
    private MysqlDumpService mysqlDumpService;

    @GetMapping("/mysqlBackup/addPage")
    public String mysqlBackupAddPage() {
        return "backup/mysql_backup_add";
    }

    @GetMapping("/mysqlBackup/initPage")
    public String mysqlBackupListPage() {
        return "backup/mysql_backup_list";
    }

    @GetMapping("/mysqlRecover/addPage")
    public String mysqlRecoverAddPage(Model model) {
        model.addAttribute("mysqlDumpList", mysqlDumpService.listMysqlDumpAll());
        return "backup/mysql_recover_add";
    }

    @GetMapping("/mysqlRecover/initPage")
    public String mysqlRecoverListPage() {
        return "backup/mysql_recover_list";
    }
}
