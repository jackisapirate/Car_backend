package com.usedcar.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usedcar.common.dto.CarDetailDto;
import com.usedcar.common.dto.CarInformationDto;
import com.usedcar.common.lang.Result;
import com.usedcar.entity.CarInformation;
import com.usedcar.entity.CarMake;
import com.usedcar.entity.CarModel;
import com.usedcar.mapper.CarInformationMapper;
import com.usedcar.service.CarInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.usedcar.service.CarMakeService;
import com.usedcar.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kunlong Wang
 * @since 2021-12-10
 */
@Service
public class CarInformationServiceImpl extends ServiceImpl<CarInformationMapper, CarInformation> implements CarInformationService {

    @Autowired
    CarMakeService carMakeService;
    @Autowired
    CarModelService carModelService;
    @Autowired
    CarInformationService carInformationService;

    @Autowired
    CarInformationMapper carInformationMapper;

    @Override
    public Page<CarInformationDto> getList(Page page, String name){
        List<CarInformation> list = this.list();
        if(name == null){
            name = "";
        }
        System.out.println(list);
        Page<CarInformationDto> pageData = this.page(page, new QueryWrapper<CarInformation>()
                .like("name", name));

        Page<CarInformationDto> carInformationDtoPage = carInformationMapper.getCarInformationPage(page, new QueryWrapper<CarInformation>()
                .like("car_information.name", name));

//        return Result.succ(200, null, pageData);
        return pageData;
    }

    public Result save(CarInformationDto carInformationDto){
        CarInformation carInformation = new CarInformation();
        // Same name in database, we can not save again.
        List<Map<String, Object>> listMaps = this.getByIdName(null, carInformationDto.getName(), null,null);
        if(listMaps.size()>0){
            // same name of car make
            return new Result().fail("This car has already existed, please change another one!");
        }
        carInformation.setName(carInformationDto.getName());
        carInformation.setYear(carInformationDto.getYear());
        carInformation.setPrice(carInformationDto.getPrice());
        carInformation.setMileage(carInformationDto.getMileage());
        carInformation.setBodyStyle(carInformationDto.getBodyStyle());
        carInformation.setColor(carInformationDto.getColor());
        carInformation.setTransmission(carInformationDto.getTransmission());
        carInformation.setEngineType(carInformationDto.getEngineType());
        carInformation.setCarModelId(carInformationDto.getCarModelId());
        carInformation.setDescription(carInformationDto.getDescription());
        carInformation.setCreated(LocalDateTime.now());
        super.save(carInformation);
        carModelService.updateCarCount(carInformationDto.getCarModelId(), true);
        return Result.succ("success");
    }

    public Result getById(Long id){
        return Result.succ(super.getById(id));
    }

    public Result updateById(CarInformationDto carInformationDto){
//        List<Map<String, Object>> listMaps = this.getByIdName(null, carInformationDto.getName(), carInformationDto.getId().toString(),null);
        List<Map<String, Object>> listMaps = this.getByIdName(null, carInformationDto.getName(), carInformationDto.getId().toString(),null);
        if(listMaps.size()>0){
            // same name of car make
            return new Result().fail("This car has already existed, please change another one!");
        }

        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id", carInformationDto.getId());
        updateWrapper.set("name", carInformationDto.getName());
        updateWrapper.set("year", carInformationDto.getYear());
        updateWrapper.set("price", carInformationDto.getPrice());
        updateWrapper.set("mileage", carInformationDto.getMileage());
        updateWrapper.set("body_style", carInformationDto.getBodyStyle());
        updateWrapper.set("color", carInformationDto.getColor());
        updateWrapper.set("transmission", carInformationDto.getTransmission());
        updateWrapper.set("engine_type", carInformationDto.getEngineType());
        updateWrapper.set("car_model_id", carInformationDto.getCarModelId());
        updateWrapper.set("description", carInformationDto.getDescription());
        updateWrapper.set("updated", LocalDateTime.now());

        // IF carMakeId changed
        if(!carInformationDto.getCarModelId().equals(carInformationDto.getCarModelIdOld())){
            carModelService.updateCarCount(carInformationDto.getCarModelId(), true);
            carModelService.updateCarCount(carInformationDto.getCarModelIdOld(), false);
        }

        return Result.succ(super.update(updateWrapper));
    }

    @Override
    public Result removeById(Long id) {
        CarInformation carInformation = super.getById(id);
        Long carModelId = carInformation.getCarModelId();

        Result result = Result.succ(super.removeById(id));
        carModelService.updateCarCount(carModelId, false);
        return result;
    }

    private List<Map<String, Object>> getByIdName(String id, String name, String nonId, String nonName){
        QueryWrapper<CarInformation> queryWrapper = new QueryWrapper<CarInformation>();
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


    public Result showDetail(Long id){
        CarInformation carInformation = super.getById(id);
        if(carInformation!=null){
            Long carModelId = carInformation.getCarModelId();
            Result resultModel = carModelService.getById(carModelId);
            if(resultModel.getData() != null){
                CarModel carModel = (CarModel) resultModel.getData();
                Result resultMake = carMakeService.getById(carModel.getCarMakeId());
                if(resultMake.getData()!=null){
                    CarMake carMake = (CarMake) resultMake.getData();
                    CarDetailDto carDetailDto = new CarDetailDto();
                    carDetailDto.setCarInformation(carInformation);
                    carDetailDto.setCarModel(carModel);
                    carDetailDto.setCarMake(carMake);
                    return Result.succ(carDetailDto);
                }
            }
        }
        return Result.fail("Sorry, we did not find the detail information of the car!");
    }
}
