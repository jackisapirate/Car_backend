package com.usedcar.controller;


import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.usedcar.common.dto.SysMenuDto;
import com.usedcar.common.lang.Result;
import com.usedcar.entity.SysMenu;
import com.usedcar.entity.SysRoleMenu;
import com.usedcar.entity.SysUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Kunlong Wang
 * @since 2021-11-21
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController {
    @GetMapping("/nav")
    public Result nav(Principal principal){
        SysUser sysUser = sysUserService.getByUsername(principal.getName());
        String authorityInfo = sysUserService.getUserAuthorityInfo(sysUser.getId());
        String[] authorityInfoArray = StringUtils.tokenizeToStringArray(authorityInfo, ",");

        // Get navigation bar information
        List<SysMenuDto> navs = sysMenuService.getCurrentUserNav();

        return Result.succ(MapUtil.builder()
                .put("authorities", authorityInfoArray)
                .put("nav", navs)
                .map()
        );
    }

    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('sys:menu:list')")
    public Result info(@PathVariable(name="id") Long id){
        return Result.succ(sysMenuService.getById(id));
    }


    @GetMapping("/list")
    @PreAuthorize("hasAuthority('sys:user:list')")
    public Result list(){
        List<SysMenu> menu = sysMenuService.tree();
        return Result.succ(menu);
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('sys:menu:save')")
    public Result save(@Validated @RequestBody SysMenu sysMenu){
        sysMenu.setCreated(LocalDateTime.now());
        sysMenuService.save(sysMenu);
        return Result.succ(sysMenu);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys:menu:update')")
    public Result update(@Validated @RequestBody SysMenu sysMenu){
        sysMenu.setCreated(LocalDateTime.now());
        sysMenuService.updateById(sysMenu);
        // modified the menu, so need to clear all redis caches associated with the menu
        sysUserService.clearUserAuthorityInfoByMenuId(sysMenu.getId());
        return Result.succ(sysMenu);
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('sys:menu:delete')")
    public Result delete(@PathVariable("id")Long id){
    // Delete the subset before deleting this menu
    int count = sysMenuService.count(new QueryWrapper<SysMenu>().eq("parent_id",id));
    if(count>0){
        return Result.fail("Please delete the submenu");
    }
    // wipe cache
    sysUserService.clearUserAuthorityInfoByMenuId(id);
    sysMenuService.removeById(id);

    // delete relevant Role table
    sysRoleMenuService.remove(new QueryWrapper<SysRoleMenu>().eq("menu_id",id));
    return Result.succ("Success");
    }

}
