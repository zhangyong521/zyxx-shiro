package com.zyxx.system.controller;

import com.alibaba.fastjson.JSON;
import com.zyxx.common.annotation.LoginLog;
import com.zyxx.common.authorization.ShiroUtils;
import com.zyxx.common.consts.SessionConst;
import com.zyxx.common.entity.ResponseResult;
import com.zyxx.common.entity.UserInfoSession;
import com.zyxx.common.enums.StatusEnums;
import com.zyxx.common.util.CaptchaUtils;
import com.zyxx.fileserver.consts.FileServerConst;
import com.zyxx.fileserver.entity.RequestFileServerPath;
import com.zyxx.system.entity.ResourceInfo;
import com.zyxx.system.entity.RoleInfo;
import com.zyxx.system.entity.UserInfo;
import com.zyxx.system.service.ResourceInfoService;
import com.zyxx.system.service.RoleInfoService;
import com.zyxx.system.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * 登录控制器
 *
 * @author Tellsea
 * @date 2019/7/13
 */
@Api(tags = "登录接口")
@Slf4j
@Controller
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private ResourceInfoService resourceInfoService;

    @GetMapping("/login")
    public String login() {
        return "system/login";
    }

    @GetMapping({"", "/", "/index"})
    public String index() {
        return "system/index";
    }

    @GetMapping("/home")
    public String home() {
        return "system/home";
    }

    @ApiOperation("登录")
    @PostMapping("login")
    @ResponseBody
    @LoginLog
    public ResponseResult login(@RequestParam("userName") String userName,
                                @RequestParam("password") String password,
                                @RequestParam(value = "rememberMe", required = false) boolean rememberMe,
                                @RequestParam("captcha") String captcha) {
        String sessionCaptcha = (String) ShiroUtils.getSessionAttribute(SessionConst.KEY_CAPTCHA);
        if (null == captcha || !captcha.equalsIgnoreCase(sessionCaptcha)) {
            return ResponseResult.error(StatusEnums.CAPTCHA_ERROR);
        }
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            log.info("登录成功：{}", userName);
            userInfoService.saveSession(userName);
            return ResponseResult.success(StatusEnums.OK);
        } catch (DisabledAccountException e) {
            return ResponseResult.error(StatusEnums.LOCKED_ACCOUNT_ERROR, userName);
        } catch (UnknownAccountException e) {
            return ResponseResult.error(StatusEnums.USER_NOT_FOUND, userName);
        } catch (IncorrectCredentialsException e) {
            return ResponseResult.error(StatusEnums.PASSWORD_ERROR, userName);
        }
    }

    @ApiOperation("生成验证码")
    @GetMapping("Captcha.jpg")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        // 设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        // 不缓存此内容
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        try {
            HttpSession session = request.getSession();
            CaptchaUtils tool = new CaptchaUtils();
            StringBuffer code = new StringBuffer();
            BufferedImage image = tool.genRandomCodeImage(code);
            session.removeAttribute(SessionConst.KEY_CAPTCHA);
            session.setAttribute(SessionConst.KEY_CAPTCHA, code.toString());
            log.info("图片验证码: {}", code);
            // 将内存中的图片通过流动形式输出到客户端
            ImageIO.write(image, "JPEG", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
