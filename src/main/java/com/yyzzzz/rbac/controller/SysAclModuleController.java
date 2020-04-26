package com.yyzzzz.rbac.controller;

import com.yyzzzz.rbac.entity.SysAclModuleEntity;
import com.yyzzzz.rbac.service.SysAclModuleService;
import com.yyzzzz.rbac.utils.PageUtils;
import com.yyzzzz.rbac.common.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 权限模块表 
 *
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
@RestController
@RequestMapping("rbac/sysaclmodule")
public class SysAclModuleController {
    @Autowired
    private SysAclModuleService sysAclModuleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("rbac:sysaclmodule:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysAclModuleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("rbac:sysaclmodule:info")
    public R info(@PathVariable("id") Integer id){
		SysAclModuleEntity sysAclModule = sysAclModuleService.getById(id);

        return R.ok().put("sysAclModule", sysAclModule);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("rbac:sysaclmodule:save")
    public R save(@RequestBody SysAclModuleEntity sysAclModule){
		sysAclModuleService.save(sysAclModule);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("rbac:sysaclmodule:update")
    public R update(@RequestBody SysAclModuleEntity sysAclModule){
		sysAclModuleService.updateById(sysAclModule);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("rbac:sysaclmodule:delete")
    public R delete(@RequestBody Integer[] ids){
		sysAclModuleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
