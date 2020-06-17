package com.zyxx.common.handler;

import com.zyxx.common.authorization.ShiroUtils;
import com.zyxx.common.consts.SqlPool;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.zyxx.common.entity.UserInfoSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * mybatis plus 自动填充
 *
 * @author Tellsea
 * @date 2020/3/3
 */
@Slf4j
@Component
public class FillMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        UserInfoSession ui = ShiroUtils.getCurrentUser();
        log.info("FillMetaObjectHandler 自动设置创建人id：{}", ui.getUserInfo().getId());
        this.strictInsertFill(metaObject, "createUser", Integer.class, ui.getUserInfo().getId());
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date(System.currentTimeMillis()));
        this.strictInsertFill(metaObject, "status", Integer.class, SqlPool.STATUS_NORMAL);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object val = getFieldValByName("updateTime", metaObject);
        if (val == null) {
            log.info("FillMetaObjectHandler 开始自动插入更新 ...");
            this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date(System.currentTimeMillis()));
        }
    }
}
