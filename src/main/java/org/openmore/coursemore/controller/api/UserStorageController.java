package org.openmore.coursemore.controller.api;

import org.openmore.coursemore.controller.common.BaseController;
import org.openmore.coursemore.dto.common.ErrorResponseEntity;
import org.openmore.coursemore.service.StorageService;
import org.openmore.common.exception.*;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-30
 */
@Api(value = "/Storage", tags = "Storage", description = "存储控制器-文件处理相关")
@RequestMapping(value = "/api/storage", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
public class UserStorageController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StorageService storageService;

    @ApiOperation(value = "获得作品图片7牛上传token", response = Object.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.GET, value = "/creationImage/token")
    public ResponseEntity getCreationImageUploadToken() {
        logger.debug(">> getCreationImageUploadToken");
        String token;
        try {
            token = storageService.getCreationImageUploadToken();
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        Map<String, String> result = new HashMap<>();
        result.put("token", token);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @ApiOperation(value = "获得作品模型文件7牛上传token", response = Object.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.GET, value = "/creationModel/token")
    public ResponseEntity getCreationModelUploadToken() {
        logger.debug(">> getCreationModelUploadToken");
        String token;
        try {
            token = storageService.getCreationModelUploadToken();
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        Map<String, String> result = new HashMap<>();
        result.put("token", token);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}




