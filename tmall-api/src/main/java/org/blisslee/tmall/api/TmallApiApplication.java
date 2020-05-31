package org.blisslee.tmall.api;

import org.blisslee.tmall.attachment.AttachmentServiceImplConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

@EnableScheduling
@Import({AttachmentServiceImplConfiguration.class})
@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "org.blisslee.tmall.api.mapper")
public class TmallApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmallApiApplication.class, args);
    }

    @Bean
    public Docket createRestApi() {
        // swagger 扫描 api
        Predicate<RequestHandler> apiSelector = RequestHandlerSelectors.basePackage("org.blisslee.tmall.api")::apply;
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(apiSelector::test)
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("TMall API")
                .description("电商系统 API 管理工具")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }

}
