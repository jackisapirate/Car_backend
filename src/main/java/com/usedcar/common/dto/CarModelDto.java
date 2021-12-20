package com.usedcar.common.dto;

/**
 * @author Kunlong Wang
 * @create 2021-12-12 22:51
 */
public class CarModelDto {
    private Long id;

    private String name;

    private Long carMakeId;

    private Long carMakeIdOld;

    private String carMakeName;

    private String description;

    private Integer carCount;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCarCount() {
        return carCount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCarCount(Integer carCount) {
        this.carCount = carCount;
    }

    public void setCarMakeId(Long carMakeId) {
        this.carMakeId = carMakeId;
    }

    public Long getCarMakeId() {
        return carMakeId;
    }

    public String getCarMakeName() {
        return carMakeName;
    }

    public void setCarMakeName(String carMakeName) {
        this.carMakeName = carMakeName;
    }

    public void setCarMakeIdOld(Long carMakeIdOld) {
        this.carMakeIdOld = carMakeIdOld;
    }

    public Long getCarMakeIdOld() {
        return carMakeIdOld;
    }
}
