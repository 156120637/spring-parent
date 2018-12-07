package com.dangdang.repository.shardingjdbc.mapper;

import com.dangdang.repository.shardingjdbc.constants.UserSQLConstats;
import org.apache.ibatis.annotations.Select;

/**
 * Create by tianjiaqin 2018-12-07
 */
public interface UserMapper {

    @Select(UserSQLConstats.INSER_INTO_USER)
    public void insertUser(String user);


}
