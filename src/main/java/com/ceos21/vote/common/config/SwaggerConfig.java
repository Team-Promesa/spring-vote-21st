package com.ceos21.vote.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "VOTE API 명세서",
                description = "프백 합동과제 투표 서비스"
        ),
        security = @io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "Authorization")
)

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        Components components = new Components()
                .addSecuritySchemes("Authorization", new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                        .in(SecurityScheme.In.HEADER)
                        .name("Authorization"))
                .addParameters("Refresh-Token", new Parameter()
                        .in(ParameterIn.HEADER.toString())
                        .schema(new StringSchema())
                        .name("Refresh-Token")
                        .description("리프레시 토큰"));

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("Authorization"))
                .components(components);
    }

    private SecurityRequirement securityRequirement() {
        return new SecurityRequirement().addList("Authorization");
    }
}