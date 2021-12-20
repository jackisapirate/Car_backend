package com.usedcar.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.usedcar.entity.SysRole;
import com.usedcar.mapper.SysRoleMapper;
import com.usedcar.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Kunlong Wang
 * @since 2021-11-21
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public List<SysRole> listRolesByUserId(Long userId) {
        List<SysRole> sysRoles = this.list(new QueryWrapper<SysRole>().inSql("id", "select role_id from sys_user_role where user_id = " + userId));
        return sysRoles;
    }
}
