package org.openmore.coursemore.dao;

import org.openmore.coursemore.entity.ThirdAuthorizations;
import org.openmore.coursemore.entity.User;
import tk.mybatis.mapper.common.Mapper;

public interface ThirdAuthorizationsMapper extends Mapper<ThirdAuthorizations> {
    User searchUserByThirdUid(String thirdUid);
}
