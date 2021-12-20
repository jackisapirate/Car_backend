package com.usedcar.common.dto;

/**
 * @author Kunlong Wang
 * @create 2021-12-10 23:14
 */
public class CarMakeDto {

    private Long id;

    private String name;

    private String country;

    private String description;

    private Integer modelCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }

    public Integer getModelCount() {
        return modelCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setModelCount(Integer modelCount) {
        this.modelCount = modelCount;
    }
}
