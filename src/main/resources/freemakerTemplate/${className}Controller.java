package ${basepackage!""}.${subpackage!""};

import org.openmore.common.annotation.SignatureCheck;
import io.swagger.annotations.*;
import ${basepackage!""}.${subpackage!""}.common.BaseController;
import ${basepackage!""}.entity.${className!"*"};
import org.openmore.common.utils.*;
import org.openmore.common.exception.*;
import ${basepackage!""}.service.${className!""}Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ${basepackage!""}.dto.${className!""}Dto;

import com.github.pagehelper.PageInfo;
import org.springframework.util.LinkedMultiValueMap;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 *   Created by ${author!"org.openmore"}
 *      on ${.now?string("yyyy-MM-dd")}
 */
@Api(value = "/${className!""}", tags = "${className!""}", description = "${controller_desc!""}")
@RequestMapping(value = "/api/${className?uncap_first}", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
public class ${className!""}Controller extends BaseController {
    @Autowired
    private ${className!""}Service ${className?uncap_first}Service;

    @SignatureCheck
    @ApiOperation(value = "根据id获取${className_zn!""}信息", response = ${className!""}Dto.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "请求失败：找不到id={id}的${className!""}", response = ResponseResult.class) })
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseResult get${className!""}ById(@PathVariable @ApiParam(required = true, value = "${className_zn!""}id") Integer id){
        logger.debug(">> get${className}ById");
        ${className}Dto ${className?uncap_first};
        try {
            ${className?uncap_first} = ${className?uncap_first}Service.get${className}DtoById(id);
        }catch (Exception e){
            return ResponseBuilder.error("请求失败：" + e.getMessage(), 4001);
        }
        if(${className?uncap_first} == null){
            return ResponseBuilder.error("请求失败：找不到id=" + id + "的${className_zn!""}", 4001);
        }
        return ResponseBuilder.success(${className?uncap_first});
    }

    @SignatureCheck
    @ApiOperation(value = "检索所有信息，支持分页，分页信息在返回的Header里，pagenum：当前页，pagesize：每页数量，total：总记录数，pages：总页数", response = ${className}.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET, value = "/by-page")
    public ResponseResult getAllByPage(@RequestParam(required = false, defaultValue = "0") @ApiParam(value = "分页第几页") Integer pageNum,
                                       @RequestParam(required = false, defaultValue = "0") @ApiParam(value = "每页多少记录") Integer pageSize)
    {
        logger.debug(">> getAllByPage ");
        List<${className}> searchResult;
        try {
            searchResult = ${className?uncap_first}Service.getAllByPage(pageNum, pageSize);
        }catch (Exception e){
            return ResponseBuilder.error("请求失败：" + e.getMessage(), 4001);
        }

        PageInfo pageInfo = new PageInfo(searchResult);
        Pagination pagination = new Pagination(pageNum, pageSize, pageInfo.getTotal(), pageInfo.getPages());
        return ResponseBuilder.success(searchResult, pagination);
    }

    @SignatureCheck
    @ApiOperation(value = "检索${className_zn!""}信息，返回结果列表", response = ${className}.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseResult search${className}(@RequestParam(required = false)  @ApiParam("${className_zn}对象") ${className} ${className?uncap_first}
                                            )
    {
        logger.debug(">> search${className}");
        List<${className}Dto> searchResult;
        try {
            searchResult = ${className?uncap_first}Service.search${className}Dto(${className?uncap_first});
        }catch (Exception e){
            return ResponseBuilder.error("请求失败：" + e.getMessage(), 4001);
        }
        return ResponseBuilder.success(searchResult);
    }



     @SignatureCheck
     @ApiOperation("更新${className_zn!""}")
     @ApiResponses(value = { @ApiResponse(code = 400, message = "请求失败：更新的数据不存在", response = ResponseResult.class),
                             @ApiResponse(code = 400, message = "请求失败：数据更新失败", response = ResponseResult.class) })
     @RequestMapping(method = RequestMethod.PUT, value = "{id}")
     public ResponseResult update${className}(@PathVariable @ApiParam(value = "${className_zn!""}id", required = true) Integer id,
                                    @RequestBody @ApiParam(value = "新${className_zn!""}信息", required = true) ${className} ${className?uncap_first})
     {
         logger.debug(">> update${className}");
         ${className} entity = ${className?uncap_first}Service.getEntityById(id);
         if(entity == null){
            return ResponseBuilder.error("更新失败：更新的数据不存在", 4001);
         }

         // 如果entity里没有带id，自动添加上
         if(${className?uncap_first}.getId() == null){
            ${className?uncap_first}.setId(id);
         }

         try {
             ${className?uncap_first}Service.update(${className?uncap_first});
         }catch (Exception e){
            return ResponseBuilder.error("更新失败：" + e.getMessage(), 4001);
         }
         return ResponseBuilder.success();
     }

     @SignatureCheck
     @ApiOperation("创建${className_zn!""}")
     @ApiResponses(value = { @ApiResponse(code = 400, message = "请求失败：数据创建失败", response = ResponseResult.class) })
     @RequestMapping(method = RequestMethod.POST, consumes = {APPLICATION_JSON_UTF8_VALUE})
     public ResponseResult create${className!""}(@RequestBody @ApiParam(value = "创建${className_zn!""}", required = true) ${className} ${className?uncap_first}){
        logger.debug(">> create${className!""}");

        try {
            ${className?uncap_first}Service.create(${className?uncap_first});
        }catch (Exception e){
            return ResponseBuilder.error("请求失败：" + e.getMessage(), 4001);
        }
        return ResponseBuilder.success();
     }

     @SignatureCheck
     @ApiOperation(value = "删除指定${className_zn!""}")
     @ApiResponses(value = { @ApiResponse(code = 400, message = "请求失败：数据删除失败", response = ResponseResult.class) })
     @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
     public ResponseResult delete${className}(@PathVariable @ApiParam(value = "${className_zn!""}id", required = true) Integer id)
     {
        logger.debug(">> delete${className!""}");
        try {
            ${className?uncap_first}Service.deleteById(id);
        }catch (Exception e){
            return ResponseBuilder.error("请求失败：" + e.getMessage(), 4001);
        }
        return ResponseBuilder.success();
     }
}




