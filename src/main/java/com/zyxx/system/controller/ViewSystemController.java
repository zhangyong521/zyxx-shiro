package com.zyxx.system.controller;

import com.zyxx.common.authorization.ShiroUtils;
import com.zyxx.system.entity.ResourceInfo;
import com.zyxx.system.entity.UserInfo;
import com.zyxx.system.service.ResourceInfoService;
import com.zyxx.system.service.RoleInfoService;
import com.zyxx.system.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统模块页面
 *
 * @author Tellsea
 * @date 2020-5-27
 */
@Api(tags = "系统模块页面")
@Controller
@RequestMapping("/system")
public class ViewSystemController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private ResourceInfoService resourceInfoService;

    @ApiOperation("用户管理页")
    @GetMapping("/userInfo/initPage")
    public String userInfoListPage() {
        return "system/user_info_list";
    }

    @ApiOperation("新增用户页")
    @GetMapping("/userInfo/addPage")
    public String userInfoAddPage(Model model) {
        model.addAttribute("roleInfoList", roleInfoService.listRoleInfoByAll());
        return "system/user_info_add";
    }

    @ApiOperation("更新用户页")
    @GetMapping("/userInfo/updatePage")
    public String userInfoUpdatePage(UserInfo userInfo, Model model) {
        model.addAttribute("userInfo", userInfoService.getUserInfoById(userInfo.getId()));
        model.addAttribute("roleInfoList", roleInfoService.listRoleInfoByAll());
        return "system/user_info_update";
    }

    @ApiOperation("用户详情页")
    @GetMapping("/userInfo/detailPage")
    public String userInfoDetailPage(UserInfo userInfo, Model model) {
        model.addAttribute("userInfo", userInfoService.getUserInfoById(userInfo.getId()));
        return "system/user_info_detail";
    }

    @ApiOperation("用户中心页")
    @GetMapping("/userInfo/myselfPage")
    public String userInfoMyselfPage(Model model) {
        Integer userId = ShiroUtils.getCurrentUser().getUserInfo().getId();
        model.addAttribute("userInfo", userInfoService.getUserInfoById(userId));
        return "system/user_info_myself";
    }

    @ApiOperation("角色管理页")
    @GetMapping("/roleInfo/initPage")
    public String roleInfoListPage(Model model) {
        model.addAttribute("resourceInfoList", resourceInfoService.listResourceInfoByTree(new ResourceInfo()));
        return "system/role_info_list";
    }

    @ApiOperation("菜单管理页")
    @GetMapping("/resourceInfo/initPage")
    public String resourceInfoPage(Model model) {
        model.addAttribute("resourceInfoList", resourceInfoService.listResourceInfoByTree(new ResourceInfo()));
        return "system/resource_info_list";
    }

    @ApiOperation("系统日志页")
    @GetMapping("/systemLog/initPage")
    public String systemLogPage() {
        return "system/system_log_list";
    }

    @ApiOperation("登录日志页")
    @GetMapping("/loginLog/initPage")
    public String loginLogPage() {
        return "system/login_log_list";
    }

    @ApiOperation("权限测试页")
    @GetMapping("/authorization/testPage")
    public String authorizationTestPage() {
        return "system/authorization_test";
    }

}
