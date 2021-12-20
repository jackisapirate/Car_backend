package com.usedcar.service;

import com.usedcar.common.dto.SysMenuDto;
import com.usedcar.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 * @author Kunlong Wang
 * @since 2021-11-21
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenuDto> getCurrentUserNav();

    List<SysMenu> tree();
}
