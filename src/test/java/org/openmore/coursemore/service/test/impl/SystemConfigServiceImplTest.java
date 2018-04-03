package org.openmore.coursemore.service.test.impl;

import org.openmore.coursemore.BaseTestCase;
import org.openmore.coursemore.entity.SystemConfig;
import org.openmore.coursemore.service.SystemConfigService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * SystemConfigServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十一月 16, 2017</pre>
 */
public class SystemConfigServiceImplTest extends BaseTestCase {

    @Autowired
    private SystemConfigService systemConfigService;

    /**
     * Method: getSystemConfigDtoById(Integer id)
     */
    @Test
    public void testGetSystemConfigDtoById() throws Exception {
//TODO: Test goes here...
        systemConfigService.getSystemConfigDtoById(1);
    }

    /**
     * Method: getEntityById(Integer id)
     */
    @Test
    public void testGetEntityById() throws Exception {
//TODO: Test goes here...
        systemConfigService.getEntityById(1);
    }

    /**
     * Method: getEntityByName(String configName)
     */
    @Test
    public void testGetEntityByName() throws Exception {
//TODO: Test goes here...
        systemConfigService.getEntityByName("");
    }

    /**
     * Method: searchSystemConfigDto(SystemConfig systemConfig)
     */
    @Test
    public void testSearchSystemConfigDto() throws Exception {
//TODO: Test goes here...
        systemConfigService.searchSystemConfigDto(null);
    }

    /**
     * Method: searchSystemConfig(SystemConfig systemConfig)
     */
    @Test
    public void testSearchSystemConfig() throws Exception {
//TODO: Test goes here...
        systemConfigService.searchSystemConfig(null);
    }

    /**
     * Method: create(SystemConfig systemConfig)
     */
    @Test
    public void testCreate() throws Exception {
//TODO: Test goes here...
        SystemConfig config = new SystemConfig();
        config.setName("aa");
        config.setValue("bb");
        systemConfigService.create(config);
    }

    /**
     * Method: deleteById(Integer id)
     */
    @Test
    public void testDeleteById() throws Exception {
//TODO: Test goes here...
        systemConfigService.deleteById(1);
    }

    /**
     * Method: update(SystemConfig systemConfig)
     */
    @Test
    public void testUpdate() throws Exception {
//TODO: Test goes here... 
    }


} 
