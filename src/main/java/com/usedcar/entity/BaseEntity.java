package com.usedcar.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Kunlong Wang
 * @create 2021-11-21 16:20
 */
@Data
public class BaseEntity implements Serializable {

    private LocalDateTime created;
    private LocalDateTime updated;
}
