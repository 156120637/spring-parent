package com.dangdang.repository.sqlserver.mapper;

import com.dangdang.repository.sqlserver.constants.UserSQLConstats;
import org.apache.ibatis.annotations.Select;

/**
 * Create by tianjiaqin 2018-12-07
 */
public interface UserMapper {

    @Select(UserSQLConstats.INSER_INTO_USER)
    public void insertUser(String user);


}
