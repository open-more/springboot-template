package org.openmore.coursemore.controller.backend;

import io.swagger.annotations.*;
import org.openmore.coursemore.controller.common.BaseController;
import org.openmore.coursemore.dto.common.ErrorResponseEntity;
import org.openmore.coursemore.entity.SystemConfig;
import org.openmore.coursemore.service.SystemConfigService;
import org.openmore.common.exception.*;
import org.openmore.coursemore.dto.SystemConfigDto;
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
@RequestMapping(value = "/backend/systemConfig", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
public class SystemConfigController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SystemConfigService systemConfigService;

    @ApiOperation(value = "根据id获取系统配置信息", response = SystemConfigDto.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：找不到id={id}的SystemConfig", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getSystemConfigById(@PathVariable @ApiParam(required = true, value = "系统配置id") Integer id) {
        logger.debug(">> getSystemConfigById");
        SystemConfigDto systemConfig;
        try {
            systemConfig = systemConfigService.getSystemConfigDtoById(id);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        if (systemConfig == null) {
            throw new InvalidParamsException("请求失败：找不到id=" + id + "的系统配置");
        }
        return new ResponseEntity(systemConfig, HttpStatus.OK);
    }

    @ApiOperation(value = "查看指定配置信息，返回结果列表", response = SystemConfig.class)
    @RequestMapping(method = RequestMethod.GET, value = "byKey")
    public ResponseEntity searchSystemConfig(@RequestParam(required = false) @ApiParam("系统配置对象") String key) {
        logger.debug(">> searchSystemConfig");
        SystemConfig entity;
        try {
            entity = systemConfigService.getEntityByName(key);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        return new ResponseEntity(entity, HttpStatus.OK);
    }

    @ApiOperation("更新系统配置")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：更新的数据不存在", response = ErrorResponseEntity.class),
            @ApiResponse(code = 400, message = "请求失败：数据更新失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public void updateSystemConfig(@PathVariable @ApiParam(value = "系统配置id", required = true) Integer id,
                                   @RequestBody @ApiParam(value = "新系统配置信息", required = true) SystemConfig systemConfig) {
        logger.debug(">> updateSystemConfig");
        SystemConfig entity = systemConfigService.getEntityById(systemConfig.getId());
        if (entity == null) {
            throw new InvalidParamsException("请求失败：更新的数据不存在");
        }

        // 如果entity里没有带id，自动添加上
        if (systemConfig.getId() == null) {
            systemConfig.setId(id);
        }

        try {
            systemConfigService.update(systemConfig);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }

    @ApiOperation("创建系统配置")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：数据创建失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.POST, consumes = {APPLICATION_JSON_UTF8_VALUE})
    public void createSystemConfig(@RequestBody @ApiParam(value = "创建系统配置", required = true) SystemConfig systemConfig) {
        logger.debug(">> createSystemConfig");
        try {
            systemConfigService.create(systemConfig);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }

    @ApiOperation(value = "删除指定系统配置")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：数据删除失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteSystemConfig(@PathVariable @ApiParam(value = "系统配置id", required = true) Integer id) {
        logger.debug(">> deleteSystemConfig");
        try {
            systemConfigService.deleteById(id);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }
}




