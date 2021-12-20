package com.usedcar.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usedcar.common.dto.CarMakeDto;
import com.usedcar.common.dto.CarModelDto;
import com.usedcar.common.dto.CarModelMakeDto;
import com.usedcar.common.lang.Result;
import com.usedcar.service.CarMakeService;
import com.usedcar.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 *
 * @author Kunlong Wang
 * @since 2021-12-10
 */
@RestController
@RequestMapping("/car/model")
public class CarModelController extends BaseController {

    @Autowired
    CarModelService carModelService;

    @Autowired
    CarMakeService carMakeService;

    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('car:model:list')")
    public Result info(@PathVariable(name="id") Long id){
        Result result = carModelService.getById(id);
        return result;
    }


    @GetMapping("/list")
    @PreAuthorize("hasAuthority('car:model:list')")
    public Result list(String name){

        Page<CarModelDto> pageCarModelDto = carModelService.getList(getPage(), name);
        List<CarMakeDto> allMake = carMakeService.getAllMake();
//        Map<String, Object> map = new HashMap();
//        map.put("carModelPage", pageCarModelDto);
//        map.put("carMakeList", allMake);

        CarModelMakeDto dto = new CarModelMakeDto();
        dto.setPageCarModelDto(pageCarModelDto);
        dto.setAllMake(allMake);
        return Result.succ(dto);
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('car:model:save')")
    public Result save(@Validated @RequestBody CarModelDto carModelDto){
        // @RequestBody
        carModelService.save(carModelDto);
        return Result.succ(carModelDto);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('car:model:update')")
    public Result update(@Validated @RequestBody CarModelDto carModelDto){
        Result result = carModelService.updateById(carModelDto);
        return result;
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('car:model:delete')")
    public Result delete(@PathVariable("id")Long id){
        Result result = carModelService.removeById(id);
        return result;
    }
}
