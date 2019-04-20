package com.wisrc.microservice.configurer;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class SwaggerRedirectConfigurer {

    // swagger服务地址
    @RequestMapping(value = "/swagger")
    public String swaggerRedirect(){
        return "redirect:/swagger-ui.html";
    }

}
