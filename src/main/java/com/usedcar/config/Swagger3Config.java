package com.usedcar.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import springfox.documentation.builders.*;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.schema.ModelRef;
//import springfox.documentation.schema.ScalarType;
//import springfox.documentation.service.*;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.util.ArrayList;
//import java.util.List;

/**
 * @author Kunlong Wang
 * @create 2021-12-09 14:02
 */
//@Configuration
//@EnableOpenApi
public class Swagger3Config {
//    @Bean
//    public Docket createRestApi() {
//        ParameterBuilder ticketPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<Parameter>();
//        ticketPar.name("Authorization").description("user ticket")//Token 以及Authorization 为自定义的参数，session保存的名字是哪个就可以写成那个
//                .modelRef(new ModelRef("string")).parameterType("header")
//                .required(false).build(); //header中的ticket参数非必填，传空也可以
//        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数
//
//        //Return document summary information
//        Docket docket = new Docket(DocumentationType.OAS_30)
//                .apiInfo(apiInfo()).enable(true)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.usedcar"))
////                .apis(RequestHandlerSelectors.withMethodAnnotation(Operation.class))
//                .paths(PathSelectors.any())
//                .build()
//                .globalOperationParameters(pars)
//                .globalRequestParameters(getGlobalRequestParameters())
//                .globalResponses(HttpMethod.GET, getGlobalResponseMessage())
//                .globalResponses(HttpMethod.POST, getGlobalResponseMessage());
//        return docket;
//    }
//
//    /**
//     * Generates interface information, including the title and contacts
//     */
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Swagger Interface")
//                .description("Author: Kunlong Wang")
//                .version("1.0")
//                .build();
//    }
//
//    /**
//     * Encapsulate global generic parameters
//     */
//    private List<RequestParameter> getGlobalRequestParameters() {
//        List<RequestParameter> parameters = new ArrayList<>();
//        parameters.add(new RequestParameterBuilder()
//                .name("uuid")
//                .description("uuid")
//                .required(true)
//                .in(ParameterType.QUERY)
//                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
//                .required(false)
//                .build());
//        return parameters;
//    }
//
//    /**
//     * Encapsulate common response information
//     */
//    private List<Response> getGlobalResponseMessage() {
//        List<Response> responseList = new ArrayList<>();
//        responseList.add(new ResponseBuilder().code("404").description("Resource not found").build());
//        return responseList;
//    }
}
