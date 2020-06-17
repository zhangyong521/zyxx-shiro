package com.zyxx.fileserver.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文件服务器
 *
 * @author Tellsea
 * @date 2020-6-11
 */
@Api(tags = "文件服务页面")
@Controller
@RequestMapping("/fileserver")
public class ViewFileServerController {

    @GetMapping("/initPage")
    public String initPage() {
        return "fileserver/index";
    }
}
