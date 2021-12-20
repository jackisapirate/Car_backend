package com.usedcar.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usedcar.common.dto.CarInformationDto;
import com.usedcar.common.lang.Result;
import com.usedcar.entity.CarInformation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Kunlong Wang
 * @since 2021-12-10
 */
public interface CarInformationService extends IService<CarInformation> {
    public Page<CarInformationDto> getList(Page page, String name);

    public Result save(CarInformationDto carInformationDto);

    public Result getById(Long id);

    public Result updateById(CarInformationDto carInformationDto);

    public Result removeById(Long id);
}
