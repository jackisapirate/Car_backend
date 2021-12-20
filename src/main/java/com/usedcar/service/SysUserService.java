package com.usedcar.service;

import com.usedcar.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 * @author Kunlong Wang
 * @since 2021-11-21
 */

public interface SysUserService extends IService<SysUser> {

    SysUser getByUsername(String username);

    String getUserAuthorityInfo(Long userId);

    void clearUserAuthorityInfo(String username);

    void clearUserAuthorityInfoByRoleId(Long roleId);

    void clearUserAuthorityInfoByMenuId(Long menuId);


}
