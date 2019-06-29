package sp.zyy.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
  * 类名：SwaggerConfig.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年6月25日
  * @version    1.0
*/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).pathMapping("/").select()
                .apis(RequestHandlerSelectors.basePackage("sp.zyy.controller"))
                .paths(PathSelectors.any()).build()
                .apiInfo(new ApiInfoBuilder().title("献给最爱的小宝贝-赵玥伊")
                        .description("").version("1.0")
                        .contact(new Contact("赵玥伊", "www.zhaoyueyi.cn",
                                "995142516@qq.com"))
                        .license("赵玥伊的网站 :http://www.zhaoyueyi.cn")
                        .licenseUrl("http://www.zhaoyueyi.cn").build());
    }
}
