package com.encore.outpick_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Springdoc 테스트")
                .description("Springdoc을 사용한 Swagger UI 테스트")
                .version("1.0.0");
    }


    // @Bean
    // public OpenAPI openAPI() {
    //     String jwt = "JWT";
    //     SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwt);
    //     Components components = new Components().addSecuritySchemes(jwt, new SecurityScheme()
    //             .name(jwt)
    //             .type(SecurityScheme.Type.HTTP)
    //             .scheme("bearer")
    //             .bearerFormat("JWT")
    //     );
    //     return new OpenAPI()
    //             .components(new Components())
    //             .info(apiInfo())
    //             .addSecurityItem(securityRequirement)
    //             .components(components);
    // }
    // private Info apiInfo() {
    //     return new Info()
    //             .title("API Test") // API의 제목
    //             .description("Let's practice Swagger UI") // API에 대한 설명
    //             .version("1.0.0"); // API의 버전
    // }
}