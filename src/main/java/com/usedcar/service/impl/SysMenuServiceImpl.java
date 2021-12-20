package com.usedcar.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.usedcar.common.dto.SysMenuDto;
import com.usedcar.entity.SysMenu;
import com.usedcar.entity.SysUser;
import com.usedcar.mapper.SysMenuMapper;
import com.usedcar.mapper.SysUserMapper;
import com.usedcar.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.usedcar.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kunlong Wang
 * @since 2021-11-21
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public List<SysMenuDto> getCurrentUserNav() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = (String)principal;

        SysUser sysUser = sysUserService.getByUsername(username);
        List<Long> navMenuIds = sysUserMapper.getNavMenuIds(sysUser.getId());
        List<SysMenu> menus = this.listByIds(navMenuIds);

        // Turn to tree structure
        List<SysMenu> menuTree = buildTreeMenu(menus);

        // convert DTO
        return convert(menuTree);
    }

    @Override
    public List<SysMenu> tree() {
        // Get all menu information
        List<SysMenu> sysMenus = this.list(new QueryWrapper<SysMenu>().orderByAsc("orderNum"));
        // Turn to tree structure
        return buildTreeMenu(sysMenus);
    }

    private List<SysMenuDto> convert(List<SysMenu> menuTree) {
        ArrayList<SysMenuDto> menuDtos = new ArrayList<>();
        menuTree.forEach(m ->{
            SysMenuDto dto = new SysMenuDto();
            dto.setId(m.getId());
            dto.setName(m.getPerms());
            dto.setTitle(m.getName());
            dto.setPath(m.getPath());
            dto.setComponent(m.getComponent());
            if(m.getChildren().size() > 0){
                dto.setChildren(convert(m.getChildren()));
            }

            menuDtos.add(dto);
        });
        return menuDtos;
    }

    private List<SysMenu> buildTreeMenu(List<SysMenu> menus) {
        List<SysMenu> finalMenus = new ArrayList<>();
        // Find the respective child nodes
        for(SysMenu menu:menus){
            for(SysMenu e:menus){
                if(menu.getId() == e.getParentId()){
                    menu.getChildren().add(e);
                }
            }
            // Parent nodes
            if(menu.getParentId() == 0L){
                finalMenus.add(menu);
            }
        }
        return finalMenus;

    }
}
