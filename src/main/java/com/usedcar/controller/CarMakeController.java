package com.usedcar.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.usedcar.common.dto.CarMakeDto;
import com.usedcar.common.lang.Result;
import com.usedcar.entity.CarMake;
import com.usedcar.mapper.CarMakeMapper;
import com.usedcar.service.CarMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Kunlong Wang
 * @since 2021-12-10
 */
@RestController
@RequestMapping("/car/make")
public class CarMakeController extends BaseController {
    @Autowired
    CarMakeMapper carMakeMapper;

    @Autowired
    CarMakeService carMakeService;

    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('car:make:list')")
    public Result info(@PathVariable(name="id") Long id){
        Result result = carMakeService.getById(id);
        return result;
    }


    @GetMapping("/list")
    @PreAuthorize("hasAuthority('car:make:list')")
    public Result list(String name){

        QueryWrapper<CarMake> queryWrapper=new QueryWrapper<CarMake>();
        queryWrapper.like("name",name);
//        Integer count = carMakeMapper.selectCount(queryWrapper);
//        System.out.println(count + "----> 统计数字");

        Result result = carMakeService.getList(getPage(), name);
        return result;
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('car:make:save')")
    public Result save(@Validated @RequestBody CarMakeDto carMakeDto){
        // @RequestBody
        carMakeService.save(carMakeDto);
        return Result.succ(carMakeDto);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('car:make:update')")
    public Result update(@Validated @RequestBody CarMakeDto carMakeDto){
        Result result = carMakeService.updateById(carMakeDto);
        return result;
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('car:make:delete')")
    public Result delete(@PathVariable("id")Long id){
        Result result = carMakeService.removeById(id);
        return result;
    }
}
