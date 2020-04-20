package com.yyzzzz.rbac.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyzzzz.rbac.utils.PageUtils;
import com.yyzzzz.rbac.utils.Query;

import com.yyzzzz.rbac.dao.SysAclDao;
import com.yyzzzz.rbac.entity.SysAclEntity;
import com.yyzzzz.rbac.service.SysAclService;


@Service("sysAclService")
public class SysAclServiceImpl extends ServiceImpl<SysAclDao, SysAclEntity> implements SysAclService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysAclEntity> page = this.page(
                new Query<SysAclEntity>().getPage(params),
                new QueryWrapper<SysAclEntity>()
        );

        return new PageUtils(page);
    }

}