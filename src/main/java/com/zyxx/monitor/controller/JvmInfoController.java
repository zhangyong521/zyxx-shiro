package com.zyxx.monitor.controller;

import com.zyxx.monitor.service.JvmInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * jvm 信息
 *
 * @author Tellsea
 * @date 2020-6-15
 */
@Controller
@RequestMapping("/monitor/jvmInfo")
public class JvmInfoController {

    @Autowired
    private JvmInfoService jvmInfoService;

    @ApiOperation("获得jvm信息")
    @GetMapping("/detailPage")
    public String detailPage(Model model, int type) {
        model.addAttribute("jvmInfo", jvmInfoService.getJvmInfo());
        if (type == 1) {
            return "monitor/jvm_info_system";
        } else if (type == 2) {
            return "monitor/jvm_info_runtime";
        } else if (type == 3) {
            return "monitor/jvm_info_thread";
        } else if (type == 4) {
            return "monitor/jvm_info_memory";
        }
        return "error/404";
    }
}
