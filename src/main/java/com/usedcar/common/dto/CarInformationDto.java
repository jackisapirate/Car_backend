package com.usedcar.common.dto;

/**
 * @author Kunlong Wang
 * @create 2021-12-17 18:00
 */
public class CarInformationDto {

    private Long id;

    private String name;

    private String year;

    private Integer price;

    private String mileage;

    private String bodyStyle;

    private String color;

    private String transmission;

    private String engineType;

    private String description;

    private Long carModelId;

    private Long carModelIdOld;

    private String carModelName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCarModelIdOld() {
        return carModelIdOld;
    }

    public void setCarModelIdOld(Long carModelIdOld) {
        this.carModelIdOld = carModelIdOld;
    }

    public Long getId() {
        return id;
    }

    public String getYear() {
        return year;
    }

    public Integer getPrice() {
        return price;
    }

    public String getMileage() {
        return mileage;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getDescription() {
        return description;
    }

    public Long getCarModelId() {
        return carModelId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCarModelId(Long carModelId) {
        this.carModelId = carModelId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }
}
