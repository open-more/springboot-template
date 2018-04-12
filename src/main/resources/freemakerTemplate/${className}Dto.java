package ${basepackage!""}.${subpackage!""};
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 *   Created by ${author!"org.openmore"}
 *      on ${.now?string("yyyy-MM-dd")}
 */

@ApiModel("${className_zn!""}显示模型")
public class ${className!""}Dto {
<#if attrs??>
    <#list attrs!"" as attr>
    @ApiModelProperty(value="${attr.desc!""}")
    public ${attr.value} ${attr.name};
    </#list>

    <#list attrs!"" as attr>
    public void set${attr.name?cap_first}(${attr.value} ${attr.name}){
        this.${attr.name} = ${attr.name};
    }

    public ${attr.value} get${attr.name?cap_first}(){
        return this.${attr.name};
    }
    </#list>
</#if>
}
