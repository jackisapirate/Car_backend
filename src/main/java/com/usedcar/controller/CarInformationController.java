package com.usedcar.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usedcar.common.dto.CarInformationDto;
import com.usedcar.common.dto.CarModelDto;
import com.usedcar.common.dto.CarModelInformationDto;
import com.usedcar.common.lang.Result;
import com.usedcar.service.CarInformationService;
import com.usedcar.service.CarMakeService;
import com.usedcar.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kunlong Wang
 * @since 2021-12-10
 */
@RestController
@RequestMapping("/car/information")
public class CarInformationController extends BaseController {

    @Autowired
    CarModelService carModelService;

    @Autowired
    CarMakeService carMakeService;

    @Autowired
    CarInformationService carInformationService;

    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('car:information:list')") // Requires permissions
    public Result info(@PathVariable(name="id") Long id){
        Result result = carInformationService.getById(id);
        return result;
    }


    @GetMapping("/list")
    @PreAuthorize("hasAuthority('car:information:list')")
    public Result list(String name){

        Page<CarInformationDto> carInformationDto = carInformationService.getList(getPage(), name);
        List<CarModelDto> allModel = carModelService.getAllModel();
//        Map<String, Object> map = new HashMap();
//        map.put("carInformationPage", carInformationDto);
//        map.put("carModelList", allModel);

        CarModelInformationDto dto = new CarModelInformationDto();
        dto.setAllModel(allModel);
        dto.setCarInformationDto(carInformationDto);
        return Result.succ(dto);
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('car:information:save')")
    public Result save(@Validated @RequestBody CarInformationDto carInformationDto){
        // @RequestBody
        carInformationService.save(carInformationDto);
        return Result.succ(carInformationDto);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('car:information:update')")
    public Result update(@Validated @RequestBody CarInformationDto carInformationDto){
        Result result = carInformationService.updateById(carInformationDto);
        return result;
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('car:information:delete')")
    public Result delete(@PathVariable("id")Long id){
        Result result = carInformationService.removeById(id);
        return result;
    }
}
