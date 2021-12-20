package com.usedcar.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Kunlong Wang
 * @create 2021-11-28 18:30
 */
@Data
public class LoginInfoDto implements Serializable {

    private String code;
    private String token;

}
