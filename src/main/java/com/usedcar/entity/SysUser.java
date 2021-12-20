package com.usedcar.entity;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Kunlong Wang
 * @since 2021-11-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @NotBlank(message = "Username can not be blank")
    private String username;

    private String password;

    private String phone;

    @NotBlank(message = "email can not be blank")
    @Email(message = "email format is not correct")
    private String email;

    @TableField(exist = false)
    private List<SysRole> sysRoles = new ArrayList<>();
}
