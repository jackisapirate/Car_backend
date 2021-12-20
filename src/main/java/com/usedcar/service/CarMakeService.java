package com.usedcar.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usedcar.common.dto.CarMakeDto;
import com.usedcar.common.lang.Result;
import com.usedcar.entity.CarMake;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 * @author Kunlong Wang
 * @since 2021-12-10
 */
public interface CarMakeService extends IService<CarMake> {
    public Result getList(Page page, String name);

    public Result save(CarMakeDto carMakeDto);

    public Result getById(Long id);

    public Result updateById(CarMakeDto carMakeDto);

    public Result removeById(Long id);

    public List<CarMakeDto> getAllMake();

    public void updateModelCount(Long id, Boolean flag);
}
