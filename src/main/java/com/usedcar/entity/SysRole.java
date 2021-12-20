package com.usedcar.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kunlong Wang
 * @since 2021-11-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @NotBlank(message = "Name of the role can not be blank")
    private String name;

    @NotBlank(message = "Code of the role can not be blank")
    private String code;

    private String remark;

    private Integer status;

    @TableField(exist = false)
    private List<Long> menuIds = new ArrayList<>();
}
