package com.yyzzzz.rbac.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyzzzz.rbac.utils.PageUtils;
import com.yyzzzz.rbac.common.Query;

import com.yyzzzz.rbac.dao.SysAclModuleDao;
import com.yyzzzz.rbac.entity.SysAclModuleEntity;
import com.yyzzzz.rbac.service.SysAclModuleService;


@Service("sysAclModuleService")
public class SysAclModuleServiceImpl extends ServiceImpl<SysAclModuleDao, SysAclModuleEntity> implements SysAclModuleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysAclModuleEntity> page = this.page(
                new Query<SysAclModuleEntity>().getPage(params),
                new QueryWrapper<SysAclModuleEntity>()
        );

        return new PageUtils(page);
    }

}