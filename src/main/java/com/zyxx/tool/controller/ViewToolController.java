package com.zyxx.tool.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ui 测试案例
 *
 * @author Tellsea
 * @date 2020-6-16
 */
@Controller
@RequestMapping("/tool")
public class ViewToolController {

    @ApiOperation("前端插件")
    @GetMapping("/viewer/intPage")
    public String viewerInitPage(int type) {
        if (type == 1) {
            return "tool/viewer";
        }
        return "error/404";
    }

    @ApiOperation("权限测试页")
    @GetMapping("/authorization/initPage")
    public String authorizationInitPage() {
        return "tool/authorization";
    }

    @ApiOperation("代码生成器页")
    @GetMapping("/generator/initPage")
    public String generatorInitPage() {
        return "tool/generator";
    }
}
