package com.usedcar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kunlong Wang
 * @create 2021-12-19 15:11
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    //api --- Interface packet scanning
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.usedcar";
    public static final String VERSION = "1.0.0";
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any()) // Depending on the URL path, you can set which requests are added to the document and which are ignored
                .build()
                .globalOperationParameters(defaultHeader())
                ;
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Information of Used Cars") //Set the title of the document
                .description("Information of Used Cars, API Interface") // Set the description of the document
                .version(VERSION) //  1.0.0 Version information
//                .termsOfServiceUrl("http://www.baidu.com")
                .build();
    }

    private static List<Parameter> defaultHeader(){
        ParameterBuilder appToken = new ParameterBuilder();
        appToken.name("Authorization").description("Authorization : token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        List<Parameter> pars = new ArrayList<>();
        pars.add(appToken.build());
        return pars;
    }
}
