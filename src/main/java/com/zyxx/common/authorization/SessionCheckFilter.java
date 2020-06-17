package com.zyxx.common.authorization;

import com.zyxx.common.entity.UserInfoSession;
import com.zyxx.system.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 访问控制器
 *
 * @author: Tellsea
 * @date: 2019/09/11
 */
@Slf4j
public class SessionCheckFilter extends AccessControlFilter {

    @Lazy
    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = ShiroUtils.getSubject();
        /*if (subject.isRemembered()) {
            log.info("记住我进入");
            UserInfoSession currentUser = ShiroUtils.getCurrentUser();
            String userName = ShiroUtils.getCurrentUser().getUserInfo().getUserName();
            userInfoService.saveSession(userName);
        }*/
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
