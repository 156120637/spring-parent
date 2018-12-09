package com.dangdang.repository.redis.constants;

import lombok.Getter;

/**
 * redis数据库
 */
@Getter
public enum RedisDbEnum {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    ;

    private Integer code;

    RedisDbEnum(Integer code) {

        this.code = code;
    }
}
