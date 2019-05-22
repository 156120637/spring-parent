package com.dangdang.service.biz.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Create by tianjiaqin 2019/5/22-20-09
 */
@Data
public class BaseDto {

    @Builder.Default
    private String id = "1";

}
