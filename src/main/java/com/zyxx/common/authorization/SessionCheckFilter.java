package com.zyxx.common.authorization;

import com.zyxx.common.entity.UserInfoSession;
import com.zyxx.system.entity.UserInfo;
import com.zyxx.system.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * session 访问控制器
 *
 * @author: Tellsea
 * @date: 2019/09/11
 */
@Slf4j
@Component
public class SessionCheckFilter extends AccessControlFilter {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = ShiroUtils.getSubject();
        UserInfoSession currentUser = ShiroUtils.getCurrentUser();
        UserInfo userInfo = (UserInfo) ShiroUtils.getPrincipal();

        if (subject.isAuthenticated()) {
            // log.info("授权进入");
        } else if (subject.isRemembered()) {
            // log.info("记住我进入");
            if (currentUser == null) {
                // 关闭浏览器，重新进入，session丢失，通过shiro这里再次刷新session
                if (userInfo == null) {
                    // shiro 也为空，重新登录
                    WebUtils.issueRedirect(request, response, "/login");
                    return false;
                } else {
                    userInfoService.saveSession(userInfo.getUserName());
                    // log.info("记住我: 刷新session: {}", userInfo.getUserName());
                }
            }
        } else {
            // log.info("没有登录");
        }
        return true;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return true;
    }
}
