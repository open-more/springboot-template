package org.openmore.coursemore.controller.api;

import org.openmore.coursemore.controller.common.BaseController;
import org.openmore.coursemore.entity.SystemConfig;
import org.openmore.coursemore.service.SystemConfigService;
import org.openmore.common.exception.*;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */
@Api(value = "/SystemConfig", tags = "SystemConfigApi", description = "配置控制器")
@RequestMapping(value = "/api/systemConfig", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
public class UserSystemConfigController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SystemConfigService systemConfigService;

    @ApiOperation(value = "查看指定配置信息，返回结果列表", response = String.class)
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getEntityByName(@RequestParam(required = false) @ApiParam("系统配置对象") String key) {
        logger.debug(">> getEntityByName");
        SystemConfig entity;
        try {
            entity = systemConfigService.getEntityByName(key);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        return new ResponseEntity(entity.getValue(), HttpStatus.OK);
    }
}




