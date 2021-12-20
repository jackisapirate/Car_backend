package com.usedcar.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Kunlong Wang
 * @since 2021-12-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CarModel extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;

    private String description;

    private Long carMakeId;

    private Integer carCount;

    @TableField(exist = false)
    private CarMake carMake;

}
