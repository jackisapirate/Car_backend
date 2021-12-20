package com.usedcar.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usedcar.common.dto.CarModelDto;
import com.usedcar.entity.CarModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Kunlong Wang
 * @since 2021-12-10
 */
public interface CarModelMapper extends BaseMapper<CarModel> {
    // Mybatis is good at single table operation, but multi-table query needs SQL mode.
    @Select("SELECT car_model.*,car_make.`name` as car_make_name FROM car_model,car_make ${ew.customSqlSegment} and car_model.car_make_id = car_make.id")
    Page<CarModelDto> getCarModelDtoPage(Page page, @Param(Constants.WRAPPER) QueryWrapper wrapper);
}
