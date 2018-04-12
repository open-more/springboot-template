package org.openmore.coursemore.dao;
import org.openmore.coursemore.entity.Administrator;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AdministratorMapper extends Mapper<Administrator> {
    Administrator login(@Param("email") String email, @Param("password") String password);

    List<Administrator> selectByEmail(@Param("email") String email);
}