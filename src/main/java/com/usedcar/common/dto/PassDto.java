package com.usedcar.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Kunlong Wang
 * @create 2021-11-27 19:35
 */

@Data
public class PassDto implements Serializable {

    @NotBlank(message = "New Password can not be Blank")
    private String password;

    @NotBlank(message = "Old Password can not be Blank")
    private String currentPass;
}
