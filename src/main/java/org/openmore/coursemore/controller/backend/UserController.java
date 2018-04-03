package org.openmore.coursemore.controller.backend;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.openmore.coursemore.controller.common.BaseController;
import org.openmore.coursemore.dto.common.ErrorResponseEntity;
import org.openmore.coursemore.entity.User;
import org.openmore.coursemore.service.UserService;
import org.openmore.common.exception.*;
import org.openmore.common.annotation.SignatureCheck;

import java.util.List;

import org.openmore.coursemore.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */
@Api(value = "/User", tags = "User", description = "用户控制器")
@RequestMapping(value = "/backend/user", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
public class UserController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @SignatureCheck
    @ApiOperation(value = "根据id获取用户信息", response = UserDto.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：找不到id={id}的User", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getUserById(@PathVariable @ApiParam(required = true, value = "用户id") Integer id) {
        logger.debug(">> getUserById");
        UserDto user;
        try {
            user = userService.getUserDtoById(id);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        if (user == null) {
            throw new InvalidParamsException("请求失败：找不到id=" + id + "的用户");
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @ApiOperation(value = "检索用户信息，返回结果列表", response = User.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity searchUser(@RequestParam(required = false) @ApiParam("呢称") String nickname,
                                     @RequestParam(required = false) @ApiParam("手机号") String mobile,
                                     @RequestParam(required = false, defaultValue = "0") @ApiParam(value = "分页第几页") Integer pageNum,
                                     @RequestParam(required = false, defaultValue = "0") @ApiParam(value = "每页多少记录") Integer pageSize
    ) {
        logger.debug(">> searchUser");
        List<User> searchResult;
        try {
            searchResult = userService.searchUserByPage(nickname, mobile, pageNum, pageSize);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        PageInfo pageInfo = new PageInfo(searchResult);
        LinkedMultiValueMap header = new LinkedMultiValueMap();
        // 当前页
        header.add("pageNum", "" + pageNum);
        // 每页显示数量
        header.add("pageSize", pageSize + "");
        // 总记录数
        header.add("total", pageInfo.getTotal() + "");
        // 总页数
        header.add("pages", pageInfo.getPages() + "");
        return new ResponseEntity(searchResult, header, HttpStatus.OK);
    }

    @ApiOperation("更新用户")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：更新的数据不存在", response = ErrorResponseEntity.class),
            @ApiResponse(code = 400, message = "请求失败：数据更新失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public void updateUser(@PathVariable @ApiParam(value = "用户id", required = true) Integer id,
                           @RequestBody @ApiParam(value = "新用户信息", required = true) User user) {
        logger.debug(">> updateUser");
        User entity = userService.getEntityById(user.getId());
        if (entity == null) {
            throw new InvalidParamsException("请求失败：更新的数据不存在");
        }

        // 如果entity里没有带id，自动添加上
        if (user.getId() == null) {
            user.setId(id);
        }

        try {
            userService.update(user);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }

    @ApiOperation("创建用户")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：数据创建失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.POST, consumes = {APPLICATION_JSON_UTF8_VALUE})
    public void createUser(@RequestBody @ApiParam(value = "创建用户", required = true) User user) {
        logger.debug(">> createUser");
        try {
            userService.create(user);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }

    @ApiOperation(value = "删除指定用户")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：数据删除失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteUser(@PathVariable @ApiParam(value = "用户id", required = true) Integer id) {
        logger.debug(">> deleteUser");
        try {
            userService.deleteById(id);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }
}




