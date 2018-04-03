package org.openmore.coursemore.dao;

import org.openmore.coursemore.entity.SystemConfig;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface SystemConfigMapper extends Mapper<SystemConfig> {
    SystemConfig getConfigByName(@Param("configName") String configName);
}
