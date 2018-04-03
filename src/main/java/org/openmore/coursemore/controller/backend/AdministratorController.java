package org.openmore.coursemore.controller.backend;

import io.swagger.annotations.*;
import org.openmore.coursemore.controller.common.BaseController;
import org.openmore.coursemore.dto.common.ErrorResponseEntity;
import org.openmore.coursemore.entity.Administrator;
import org.openmore.coursemore.service.AdministratorService;
import org.openmore.common.exception.*;

import java.util.List;

import org.openmore.coursemore.dto.AdministratorDto;
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
@Api(value = "/Administrator", tags = "AdministratorApi", description = "管理员控制器")
@RequestMapping(value = "/backend/administrator", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
public class AdministratorController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdministratorService administratorService;

    @ApiOperation(value = "根据id获取后台管理员信息", response = AdministratorDto.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：找不到id={id}的Administrator", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getAdministratorById(@PathVariable @ApiParam(required = true, value = "后台管理员id") Integer id) {
        logger.debug(">> getAdministratorById");
        AdministratorDto administrator;
        try {
            administrator = administratorService.getAdministratorDtoById(id);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        if (administrator == null) {
            throw new InvalidParamsException("请求失败：找不到id=" + id + "的后台管理员");
        }
        return new ResponseEntity(administrator, HttpStatus.OK);
    }

    @ApiOperation(value = "检索后台管理员信息，返回结果列表", response = Administrator.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity searchAdministrator(@RequestParam(required = false) @ApiParam("后台管理员对象") String email
    ) {
        logger.debug(">> searchAdministrator");
        List<Administrator> searchResult;
        try {
            searchResult = administratorService.searchAdministrator(email);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        return new ResponseEntity(searchResult, HttpStatus.OK);
    }

    @ApiOperation("更新后台管理员")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：更新的数据不存在", response = ErrorResponseEntity.class),
            @ApiResponse(code = 400, message = "请求失败：数据更新失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public void updateAdministrator(@PathVariable @ApiParam(value = "后台管理员id", required = true) Integer id,
                                    @RequestBody @ApiParam(value = "新后台管理员信息", required = true) Administrator administrator) {
        logger.debug(">> updateAdministrator");
        Administrator entity = administratorService.getEntityById(id);
        if (entity == null) {
            throw new InvalidParamsException("请求失败：更新的数据不存在");
        }

        // 如果entity里没有带id，自动添加上
        if (administrator.getId() == null) {
            administrator.setId(id);
        }

        try {
            administratorService.update(administrator);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }

    @ApiOperation("创建后台管理员")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：数据创建失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.POST, consumes = {APPLICATION_JSON_UTF8_VALUE})
    public void createAdministrator(@RequestBody @ApiParam(value = "创建后台管理员", required = true) Administrator administrator) {
        logger.debug(">> createAdministrator");
        try {
            administratorService.create(administrator);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }

    @ApiOperation(value = "删除指定后台管理员")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：数据删除失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteAdministrator(@PathVariable @ApiParam(value = "后台管理员id", required = true) Integer id) {
        logger.debug(">> deleteAdministrator");
        try {
            administratorService.deleteById(id);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }


    @ApiOperation(value = "后台邮箱及密码登录")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：登录失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.POST, value = "session")
    public ResponseEntity login(@RequestBody @ApiParam(value = "管理员dto，只需要account和password", required = true) Administrator admin) {
        logger.debug(">> login");
        AdministratorDto result = null;
        try {
            result = administratorService.login(admin);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }
}




