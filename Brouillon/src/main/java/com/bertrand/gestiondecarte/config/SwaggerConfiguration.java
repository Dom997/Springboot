package com.bertrand.gestiondecarte.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.bertrand.gestiondecarte.utils.constants.APP_ROOt;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration
{
    public Docket Api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .description("Gestion de cartes bancaire Apis documentation")
                        .title("Gestion de carte RESTE API ")
                        .build()).
                        groupName("REST API V1").
                        select().apis(RequestHandlerSelectors.basePackage("com.bertrand.gestiondecarte")).
                        paths(PathSelectors.ant(APP_ROOt +"/**")).build();
    }

}
