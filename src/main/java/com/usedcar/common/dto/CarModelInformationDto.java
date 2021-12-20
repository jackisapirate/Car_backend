package com.usedcar.common.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @author banichailemai
 * @create 2021-12-20 12:53
 */
public class CarModelInformationDto {
    public Page<CarInformationDto> carInformationDto;
    public List<CarModelDto> allModel;

    public List<CarModelDto> getAllModel() {
        return allModel;
    }

    public void setAllModel(List<CarModelDto> allModel) {
        this.allModel = allModel;
    }

    public Page<CarInformationDto> getCarInformationDto() {
        return carInformationDto;
    }

    public void setCarInformationDto(Page<CarInformationDto> carInformationDto) {
        this.carInformationDto = carInformationDto;
    }
}
