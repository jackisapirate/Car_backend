package com.usedcar.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usedcar.common.dto.CarInformationDto;
import com.usedcar.entity.CarInformation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Kunlong Wang
 * @since 2021-12-10
 */
public interface CarInformationMapper extends BaseMapper<CarInformation> {

    // Mybatis is good at single table operation, but multi-table query needs SQL mode.
    @Select("SELECT car_information.*,car_model.`name` as car_model_name FROM car_information,car_model ${ew.customSqlSegment} and car_information.car_model_id = car_model.id")
    Page<CarInformationDto> getCarInformationPage(Page page, @Param(Constants.WRAPPER) QueryWrapper wrapper);
}
