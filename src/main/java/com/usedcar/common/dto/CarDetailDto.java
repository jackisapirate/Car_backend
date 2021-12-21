package com.usedcar.common.dto;

import com.usedcar.entity.CarInformation;
import com.usedcar.entity.CarMake;
import com.usedcar.entity.CarModel;

/**
 * @author banichailemai
 * @create 2021-12-20 16:34
 */
public class CarDetailDto {

    public CarInformation carInformation;
    public CarModel carModel;
    public CarMake carMake;

    public CarInformation getCarInformation() {
        return carInformation;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public CarMake getCarMake() {
        return carMake;
    }

    public void setCarInformation(CarInformation carInformation) {
        this.carInformation = carInformation;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public void setCarMake(CarMake carMake) {
        this.carMake = carMake;
    }
}
