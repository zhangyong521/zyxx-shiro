package com.zyxx.ui.controller;

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
@RequestMapping("/ui")
public class UiController {

    @GetMapping("/intPage")
    public String detailPage(int type) {
        if (type == 1) {
            return "ui/ui_viewer";
        }
        return "error/404";
    }
}
