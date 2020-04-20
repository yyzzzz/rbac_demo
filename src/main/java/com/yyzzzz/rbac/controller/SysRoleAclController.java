package com.yyzzzz.rbac.controller;

import com.yyzzzz.rbac.entity.SysRoleAclEntity;
import com.yyzzzz.rbac.service.SysRoleAclService;
import com.yyzzzz.rbac.utils.PageUtils;
import com.yyzzzz.rbac.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 角色权限关联表 
 *
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
@RestController
@RequestMapping("rbac/sysroleacl")
public class SysRoleAclController {
    @Autowired
    private SysRoleAclService sysRoleAclService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("rbac:sysroleacl:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysRoleAclService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("rbac:sysroleacl:info")
    public R info(@PathVariable("id") Integer id){
		SysRoleAclEntity sysRoleAcl = sysRoleAclService.getById(id);

        return R.ok().put("sysRoleAcl", sysRoleAcl);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("rbac:sysroleacl:save")
    public R save(@RequestBody SysRoleAclEntity sysRoleAcl){
		sysRoleAclService.save(sysRoleAcl);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("rbac:sysroleacl:update")
    public R update(@RequestBody SysRoleAclEntity sysRoleAcl){
		sysRoleAclService.updateById(sysRoleAcl);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("rbac:sysroleacl:delete")
    public R delete(@RequestBody Integer[] ids){
		sysRoleAclService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
