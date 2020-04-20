package com.yyzzzz.rbac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyzzzz.rbac.dao.SysRoleAclDao;
import com.yyzzzz.rbac.entity.SysRoleAclEntity;
import com.yyzzzz.rbac.service.SysRoleAclService;
import com.yyzzzz.rbac.utils.PageUtils;
import org.springframework.stereotype.Service;
import com.yyzzzz.rbac.utils.Query;
import java.util.Map;


@Service("sysRoleAclService")
public class SysRoleAclServiceImpl extends ServiceImpl<SysRoleAclDao, SysRoleAclEntity> implements SysRoleAclService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysRoleAclEntity> page = this.page(
                new Query<SysRoleAclEntity>().getPage(params),
                new QueryWrapper<SysRoleAclEntity>()
        );

        return new PageUtils(page);
    }

}