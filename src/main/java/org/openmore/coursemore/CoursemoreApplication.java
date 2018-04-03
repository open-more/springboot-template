package org.openmore.coursemore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Set;

//@EnableCaching
//@EnableAutoConfiguration
@ServletComponentScan
@SpringBootApplication
@MapperScan(value = "org.openmore.coursemore.dao")
@ComponentScan(basePackages = {"org.openmore.coursemore", "org.openmore.sourcegenerator"})
public class CoursemoreApplication {
    public static void main(String[] args) throws ClassNotFoundException {
        SpringApplication.run(CoursemoreApplication.class, args);
    }
}
