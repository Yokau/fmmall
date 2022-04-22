package com.yokau.fmmall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /*swagger 会生成接口文档
     * 1.配置生成的文档信息
     * 2.配置生成规则
     * */
    /*Docket封装接口文档信息*/
    @Bean
    public Docket getDocket(){
        //如何获取一个接口对象
        //new 接口。需要在构造器方法后的{}实现接口中的所有抽象方法
        //new 子类/实现类
        //工厂模式
        //制定生成的文档中的封面信息，文档标题、版本、作者

        //创建封面信息对象
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("《锋迷商城》后端接口说明")
                .description("文档详细说明了锋迷商城项目后端接口规范")
                .version("v2.0.1")
                .contact(new Contact("yokau","www.yokau.top","yang722900@gmail.com"));

        ApiInfo apiInfo = apiInfoBuilder.build();

        //制定文档风格
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yokau.fmmall.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }

}
