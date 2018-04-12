package org.openmore.coursemore.dao;

import org.openmore.coursemore.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    List<User> selectUser(@Param("nickname") String nickname, @Param("mobile") String mobile);

    int updateCoin(@Param("uid") Integer uid, @Param("amount") Integer amount);
}