package com.usedcar.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usedcar.common.dto.CarModelDto;
import com.usedcar.common.lang.Result;
import com.usedcar.entity.CarModel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 * @author Kunlong Wang
 * @since 2021-12-10
 */
public interface CarModelService extends IService<CarModel> {
    public Page<CarModelDto> getList(Page page, String name);

    public Result save(CarModelDto carModelDto);

    public Result getById(Long id);

    public Result updateById(CarModelDto carModelDto);

    public Result removeById(Long id);

    public void updateCarCount(Long id, Boolean flag);

    public List<CarModelDto> getAllModel();
}
