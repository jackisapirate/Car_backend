package com.usedcar.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kunlong Wang
 * @since 2021-11-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * Parent ID
     */
    @NotNull(message = "ParentId can not be null")
    private Long parentId;

    @NotBlank(message="Name can not be blank")
    private String name;

    /**
     * Menu URL
     */
    private String path;

    private String component;

    /**
     * Permission(For example：user:list,user:create)
     */
    @NotBlank(message="Authorization cannot be empty")
    private String perms;

    /**
     * Type     0：Catalog   1：Menu   2：Button
     */
    @NotNull(message = "Menu type can not be null")
    private Integer type;

    /**
     * OrderNum
     */
    @TableField("orderNum")
    private Integer orderNum;

    @TableField(exist = false)
    private List<SysMenu> children = new ArrayList<>();
}
