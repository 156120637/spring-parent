package com.dangdang.common.utils.page;

import lombok.Data;

/**
 * @Author: wyg
 * @Date: 2018/4/4 上午11:07
 * @Description:
 */
@Data
public class PageDto {

    private Integer page = 1;

    private Integer size = 10;

    private Long total;

}
