package com.yyzzzz.rbac.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author yyzzzz
 * @Date 2020/4/22 22:53
 */
@Component
public class AuditMetaObjectHandler implements MetaObjectHandler {

    private static final Logger log = LoggerFactory.getLogger(AuditMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "createdBy", String.class, "admin");
        this.strictInsertFill(metaObject, "createdTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "updatedBy", String.class, "admin");
        this.strictInsertFill(metaObject, "updatedTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "operateIp", String.class, "127.0.0.1");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictInsertFill(metaObject, "updatedBy", String.class, "admin");
        this.strictInsertFill(metaObject, "updatedTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "operateIp", String.class, "127.0.0.1");
    }
}
