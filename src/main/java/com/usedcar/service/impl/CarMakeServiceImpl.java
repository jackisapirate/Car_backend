package com.usedcar.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usedcar.common.dto.CarMakeDto;
import com.usedcar.common.lang.Result;
import com.usedcar.entity.CarMake;
import com.usedcar.mapper.CarMakeMapper;
import com.usedcar.service.CarMakeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kunlong Wang
 * @since 2021-12-10
 */
@Service
public class CarMakeServiceImpl extends ServiceImpl<CarMakeMapper, CarMake> implements CarMakeService {
    public Result getList(Page page, String name){
        Page<CarMakeDto> pageData = this.page(page, new QueryWrapper<CarMake>()
                .like(StrUtil.isNotBlank(name), "name", name));
        System.out.println(pageData);
        return Result.succ(pageData);
    }

    public Result save(CarMakeDto carMakeDto){
        CarMake carMake = new CarMake();
        // Same name in database, we can not save again.
        List<Map<String, Object>> listMaps = this.getByIdName(null, carMakeDto.getName(), null,null);
        if(listMaps.size()>0){
            // same name of car make
            return new Result().fail("This Make of car has already existed, please change another one!");
        }
        carMake.setName(carMakeDto.getName());
        carMake.setCountry(carMakeDto.getCountry());
        carMake.setDescription(carMakeDto.getDescription());
        carMake.setModelCount(0);
        carMake.setCreated(LocalDateTime.now());
        super.save(carMake);
        return Result.succ("success");
    }

    public Result getById(Long id){
        return Result.succ(super.getById(id));
    }

    public Result updateById(CarMakeDto carMakeDto){
        List<Map<String, Object>> listMaps = this.getByIdName(null, carMakeDto.getName(), carMakeDto.getId().toString(),null);
        if(listMaps.size()>0){
            // same name of car make
            return new Result().fail("This Make of car has already existed, please change another one!");
        }

        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id", carMakeDto.getId());
        updateWrapper.set("name", carMakeDto.getName());
        updateWrapper.set("country", carMakeDto.getCountry());
        updateWrapper.set("description", carMakeDto.getDescription());
        updateWrapper.set("updated", LocalDateTime.now());

        return Result.succ(super.update(updateWrapper));
    }

    @Override
    public Result removeById(Long id) {
        CarMake carMake = super.getById(id);
        Result result = null;
        if(carMake != null && carMake.getModelCount() == 0){
            result = Result.succ(super.removeById(id));

        } else {
            // same name of car make
            result = Result.fail("There is also Model under this Car Make. Please delete the Model under this Car Make first.");
        }
        return result;
    }

    @Override
    public List<CarMakeDto> getAllMake() {
        List<CarMake> makes = super.list();
        List<CarMakeDto> makesDto = new ArrayList<CarMakeDto>();
        for(int i=0; i< makes.size(); i++){
            CarMakeDto carMakeDto = new CarMakeDto();
            carMakeDto.setId(makes.get(i).getId());
            carMakeDto.setName(makes.get(i).getName());
            makesDto.add(carMakeDto);
        }
        return makesDto;
    }

    private List<Map<String, Object>> getByIdName(String id, String name, String nonId, String nonName){
        QueryWrapper<CarMake> queryWrapper = new QueryWrapper<CarMake>();
        if(id != null){
            queryWrapper.eq("id", id);
        }
        if(nonId != null){
            queryWrapper.ne("id", nonId);
        }
        if(name != null){
            queryWrapper.eq("name", name);
        }
        if(nonName != null){
            queryWrapper.ne("name", nonName);
        }
        queryWrapper.select();
        List<Map<String, Object>> listMaps = listMaps(queryWrapper);
        return listMaps;
    }

    public void updateModelCount(Long id, Boolean flag){
        CarMake carMake = super.getById(id);
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id", id);
        if(carMake != null){
            if(flag == true){
                updateWrapper.set("model_count", carMake.getModelCount() + 1);
            } else {
                updateWrapper.set("model_count", carMake.getModelCount() - 1);
            }
        }
        super.update(updateWrapper);
    }
}
