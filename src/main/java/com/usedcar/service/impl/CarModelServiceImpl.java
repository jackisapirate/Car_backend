package com.usedcar.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.usedcar.common.dto.CarModelDto;
import com.usedcar.common.lang.Result;
import com.usedcar.entity.CarModel;
import com.usedcar.mapper.CarModelMapper;
import com.usedcar.service.CarMakeService;
import com.usedcar.service.CarModelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CarModelServiceImpl extends ServiceImpl<CarModelMapper, CarModel> implements CarModelService {

    @Autowired
    CarMakeService carMakeService;

    @Autowired
    CarModelMapper carModelMapper;

    @Override
    public Page<CarModelDto> getList(Page page, String name){
        List<CarModel> list = this.list();
        if(name == null){
            name = "";
        }
        System.out.println(list);
        Page<CarModelDto> pageData = this.page(page, new QueryWrapper<CarModel>()
                .like("name", name));

        Page<CarModelDto> carModelDtoPage = carModelMapper.getCarModelDtoPage(page, new QueryWrapper<CarModel>()
                .like("car_model.name", name));

//        return Result.succ(200, null, pageData);
        return pageData;
    }

    public Result save(CarModelDto carModelDto){
        CarModel carModel = new CarModel();
        // Same name in database, we can not save again.
        List<Map<String, Object>> listMaps = this.getByIdName(null, carModelDto.getName(), null,null);
        if(listMaps.size()>0){
            // same name of car make
            return new Result().fail("This Make of car has already existed, please change another one!");
        }
        carModel.setName(carModelDto.getName());
        carModel.setCarMakeId(carModelDto.getCarMakeId());
        carModel.setDescription(carModelDto.getDescription());
        carModel.setCarCount(0);
        carModel.setCreated(LocalDateTime.now());
        super.save(carModel);
        carMakeService.updateModelCount(carModelDto.getCarMakeId(), true);
        return Result.succ("success");
    }

    public Result getById(Long id){
        return Result.succ(super.getById(id));
    }

    public Result updateById(CarModelDto carModelDto){
        List<Map<String, Object>> listMaps = this.getByIdName(null, carModelDto.getName(), carModelDto.getId().toString(),null);
        if(listMaps.size()>0){
            // same name of car make
            return new Result().fail("This Make of car has already existed, please change another one!");
        }

        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id", carModelDto.getId());
        updateWrapper.set("name", carModelDto.getName());
        updateWrapper.set("car_make_id", carModelDto.getCarMakeId());
        updateWrapper.set("description", carModelDto.getDescription());
        updateWrapper.set("updated", LocalDateTime.now());

        // IF carMakeId changed
        if(!carModelDto.getCarMakeId().equals(carModelDto.getCarMakeIdOld())){
            carMakeService.updateModelCount(carModelDto.getCarMakeId(), true);
            carMakeService.updateModelCount(carModelDto.getCarMakeIdOld(), false);
        }

        return Result.succ(super.update(updateWrapper));
    }

    @Override
    public Result removeById(Long id) {
        CarModel carModel = super.getById(id);
        Result result = null;
        if(carModel != null && carModel.getCarCount() == 0){
            result = Result.succ(super.removeById(id));
            Long carMakeId = carModel.getCarMakeId();
            carMakeService.updateModelCount(carMakeId, false);

        } else {
            // same name of car make
            result = Result.fail("There is also Model under this Car Make. Please delete the Model under this Car Make first.");
        }
        return result;
    }

    private List<Map<String, Object>> getByIdName(String id, String name, String nonId, String nonName){
        QueryWrapper<CarModel> queryWrapper = new QueryWrapper<CarModel>();
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

    public void updateCarCount(Long id, Boolean flag){
        CarModel carModel = super.getById(id);
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id", id);
        if(carModel != null){
            if(flag == true){
                updateWrapper.set("car_count", carModel.getCarCount() + 1);
            } else {
                updateWrapper.set("car_count", carModel.getCarCount() - 1);
            }
        }
        super.update(updateWrapper);
    }

    @Override
    public List<CarModelDto> getAllModel() {
        List<CarModel> models = super.list();
        List<CarModelDto> modelsDto = new ArrayList<CarModelDto>();
        for(int i=0; i< models.size(); i++){
            CarModelDto carModelDto = new CarModelDto();
            carModelDto.setId(models.get(i).getId());
            carModelDto.setName(models.get(i).getName());
            modelsDto.add(carModelDto);
        }
        return modelsDto;
    }
}
