package com.fuint.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    /*
        这个方法的返回值交给Spring 管理
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//com包下所有API都交给Swagger2管理
                .apis(RequestHandlerSelectors.basePackage("com"))
                .paths(PathSelectors.any()).build();
    }

    //API文档页面显示信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("演示项目API")//标题
                .description("学习Swagger2的演示项目")//描述
                .build();
        /**
         * 该套 API 说明，包含作者、简介、版本、host、服务URL
         * @return
         */

    }
}