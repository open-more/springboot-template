package org.openmore.coursemore.controller.backend;

import org.openmore.coursemore.controller.common.BaseController;
import org.openmore.coursemore.dto.common.ErrorResponseEntity;
import org.openmore.coursemore.service.StorageService;
import org.openmore.common.exception.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-30
 */
@Api(value = "/Storage", tags = "Storage", description = "存储控制器-文件处理相关")
@RequestMapping(value = "/backend/storage", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
public class StorageController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StorageService storageService;

    @ApiOperation(value = "获得颜料/图案7牛上传token", response = Object.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.GET, value = "/resource/token")
    public ResponseEntity getResourceImageUploadToken() {
        logger.debug(">> getResourceImageUploadToken");
        String token;
        try {
            token = storageService.getResourceImageUploadToken();
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        Map<String, String> result = new HashMap<>();
        result.put("token", token);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}




