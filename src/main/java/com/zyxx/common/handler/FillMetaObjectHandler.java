package com.zyxx.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.zyxx.common.authorization.ShiroUtils;
import com.zyxx.common.consts.SqlPool;
import com.zyxx.system.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
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
        UserInfo userInfo = (UserInfo) ShiroUtils.getPrincipal();
         if (userInfo != null) {
            log.info("FillMetaObjectHandler 自动设置创建人id：{}", userInfo.getId());
            this.strictInsertFill(metaObject, "createUser", Integer.class, userInfo.getId());
         }
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
