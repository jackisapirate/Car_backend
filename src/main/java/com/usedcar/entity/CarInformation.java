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
public class CarInformation extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private String year;

    private Integer price;

    private String mileage;

    private String bodyStyle;

    private String color;

    private String transmission;

    private String engineType;

    private String description;

    private Long carModelId;
}
