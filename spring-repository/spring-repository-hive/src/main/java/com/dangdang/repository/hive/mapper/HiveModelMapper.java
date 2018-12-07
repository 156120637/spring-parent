package com.dangdang.repository.hive.mapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Create by tianjiaqin 2018-12-07
 */
@Slf4j
@Component
public class HiveModelMapper {

    private JdbcTemplate hiveJdbcTemplate;

    public Boolean insertHiveTable(String sql) {

        try {
            hiveJdbcTemplate.execute(sql);
            return true;
        } catch (DataAccessException e) {
            return false;
        }

    }


}
