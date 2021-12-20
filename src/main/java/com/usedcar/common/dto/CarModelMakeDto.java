package com.usedcar.common.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @author banichailemai
 * @create 2021-12-12 12:48
 */
public class CarModelMakeDto {
    public Page<CarModelDto> pageCarModelDto;
    public List<CarMakeDto> allMake;

    public Page<CarModelDto> getPageCarModelDto() {
        return pageCarModelDto;
    }

    public List<CarMakeDto> getAllMake() {
        return allMake;
    }

    public void setPageCarModelDto(Page<CarModelDto> pageCarModelDto) {
        this.pageCarModelDto = pageCarModelDto;
    }

    public void setAllMake(List<CarMakeDto> allMake) {
        this.allMake = allMake;
    }
}
