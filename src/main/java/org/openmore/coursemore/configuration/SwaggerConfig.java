package org.openmore.coursemore.configuration;

import com.google.common.base.Predicate;
import org.openmore.coursemore.dto.common.BaseResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by michaeltang on 2018/3/23.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo appApiInfo() {
        Contact contact = new Contact("Openmore", "https://github.com/open-more/springboot-template", "michaeltang@openmore.org");
        return new ApiInfoBuilder()
                .title("Openmore SpringBootTemplate API接口-使用SpringBootTemplate模板库创建")
                .description("所有版本归openmore.org所属")
                .contact(contact)
                .version("1.0")
                .build();
    }


    private ApiInfo backApiInfo() {
        Contact contact = new Contact("Openmore", "https://github.com/open-more/springboot-template", "michaeltang@openmore.org");
        return new ApiInfoBuilder()
                .title("Openmore SpringBootTemplate 后端API接口-使用SpringBootTemplate模板库创建")
                .description("所有版本归openmore.org所属")
                .contact(contact)
                .version("1.0")
                .build();
    }
    //
    private Predicate<String> appApiPaths() {
        return or(
                regex("/api/*.*")
        );
    }

    private Predicate<String> backendApiPaths() {
        return or(
                regex("/backend/*.*")
        );
    }

    @Bean
    public Docket appApi() {
        com.fasterxml.classmate.TypeResolver typeResolver = new com.fasterxml.classmate.TypeResolver();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("appApi-v1.0")
                .apiInfo(appApiInfo())
                .select()
                .paths(appApiPaths())
                .build().useDefaultResponseMessages(false)
                .genericModelSubstitutes(BaseResponse.class)
                .forCodeGeneration(true);

        return docket;
    }

    @Bean
    public Docket backendApi() {
        com.fasterxml.classmate.TypeResolver typeResolver = new com.fasterxml.classmate.TypeResolver();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("backendApi-1.0")
                .apiInfo(backApiInfo())
                .select()
                .paths(backendApiPaths())
                .build().useDefaultResponseMessages(false)
                .genericModelSubstitutes(BaseResponse.class)
                .forCodeGeneration(true);

        return docket;
    }
}
