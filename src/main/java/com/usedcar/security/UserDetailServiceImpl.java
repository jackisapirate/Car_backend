package com.usedcar.security;

import com.usedcar.entity.SysUser;
import com.usedcar.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kunlong Wang
 * @create 2021-11-24 11:44
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = sysUserService.getByUsername(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException("Username or password error");
        }
        return new AccountUser(sysUser.getId(), sysUser.getUsername(), sysUser.getPassword(), getUserAuthority(sysUser.getId()));
    }

    /**
     * Obtain user permission information
     * @param userId
     * @return
     */
    public List<GrantedAuthority> getUserAuthority(Long userId){

        // Role(ROLE_admin)、 sys:user:list
        String authority = sysUserService.getUserAuthorityInfo(userId);  // ROLE_admin,ROLE_normal,sys:user:list,....
        // Returns a comma-separated string, which is translated into a List using the following tools
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authority);
    }
}
