package com.dangdang.common.utils.page;

import lombok.Data;


/**
 * Create by tianjiaqin 2018/11/12
 */
@Data
public class PageDto {

    private Integer page = 1;

    private Integer size = 10;

    private Long total;

}
