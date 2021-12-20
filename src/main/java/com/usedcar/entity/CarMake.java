package com.usedcar.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class CarMake extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String country;

    private String description;

    private Integer modelCount;

}
