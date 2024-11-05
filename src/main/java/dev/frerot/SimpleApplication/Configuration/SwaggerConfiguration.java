package dev.frerot.SimpleApplication.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI(){
        Info info = new Info().title(
                "Simple Java spring-boot application Learn App"
        ).version("1.0")
                .description("this in Learn Aggregation App");
        return new OpenAPI().info(info);
    };
}
