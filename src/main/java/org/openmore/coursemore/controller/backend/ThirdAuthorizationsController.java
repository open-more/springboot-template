package org.openmore.coursemore.controller.backend;

import io.swagger.annotations.*;
import org.openmore.coursemore.controller.common.BaseController;
import org.openmore.coursemore.dto.common.ErrorResponseEntity;
import org.openmore.coursemore.entity.ThirdAuthorizations;
import org.openmore.coursemore.service.ThirdAuthorizationsService;
import org.openmore.common.exception.*;

import java.util.List;

import org.openmore.coursemore.dto.ThirdAuthorizationsDto;
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
 * on 2017-07-29
 */
@Api(value = "/ThirdAuthorizations", tags = "ThirdAuthorizations", description = "三方登录控制器")
@RequestMapping(value = "/backend/thirdAuthorizations", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
public class ThirdAuthorizationsController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ThirdAuthorizationsService thirdAuthorizationsService;

    @ApiOperation(value = "根据id获取三方登录信息", response = ThirdAuthorizationsDto.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：找不到id={id}的ThirdAuthorizations", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getThirdAuthorizationsById(@PathVariable @ApiParam(required = true, value = "三方登录id") Integer id) {
        logger.debug(">> getThirdAuthorizationsById");
        ThirdAuthorizationsDto thirdAuthorizations;
        try {
            thirdAuthorizations = thirdAuthorizationsService.getThirdAuthorizationsDtoById(id);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        if (thirdAuthorizations == null) {
            throw new InvalidParamsException("请求失败：找不到id=" + id + "的三方登录");
        }
        return new ResponseEntity(thirdAuthorizations, HttpStatus.OK);
    }

    @ApiOperation(value = "检索三方登录信息，返回结果列表", response = ThirdAuthorizations.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity searchThirdAuthorizations(@RequestBody(required = false) @ApiParam("三方登录对象") ThirdAuthorizations thirdAuthorizations
    ) {
        logger.debug(">> searchThirdAuthorizations");
        List<ThirdAuthorizationsDto> searchResult;
        try {
            searchResult = thirdAuthorizationsService.searchThirdAuthorizationsDto(thirdAuthorizations);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        return new ResponseEntity(searchResult, HttpStatus.OK);
    }

    @ApiOperation("更新三方登录信息")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：更新的数据不存在", response = ErrorResponseEntity.class),
            @ApiResponse(code = 400, message = "请求失败：数据更新失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public void updateThirdAuthorizations(@PathVariable @ApiParam(value = "三方登录id", required = true) Integer id,
                                          @RequestBody @ApiParam(value = "新三方登录信息", required = true) ThirdAuthorizations thirdAuthorizations) {
        logger.debug(">> updateThirdAuthorizations");
        ThirdAuthorizations entity = thirdAuthorizationsService.getEntityById(thirdAuthorizations.getId());
        if (entity == null) {
            throw new InvalidParamsException("请求失败：更新的数据不存在");
        }

        // 如果entity里没有带id，自动添加上
        if (thirdAuthorizations.getId() == null) {
            thirdAuthorizations.setId(id);
        }

        try {
            thirdAuthorizationsService.update(thirdAuthorizations);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }

    @ApiOperation("创建三方登录")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：数据创建失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.POST, consumes = {APPLICATION_JSON_UTF8_VALUE})
    public void createThirdAuthorizations(@RequestBody @ApiParam(value = "创建三方登录", required = true) ThirdAuthorizations thirdAuthorizations) {
        logger.debug(">> createThirdAuthorizations");
        try {
            thirdAuthorizationsService.create(thirdAuthorizations);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }

    @ApiOperation(value = "删除指定三方登录")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：数据删除失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteThirdAuthorizations(@PathVariable @ApiParam(value = "三方登录id", required = true) Integer id) {
        logger.debug(">> deleteThirdAuthorizations");
        try {
            thirdAuthorizationsService.deleteById(id);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }
}




