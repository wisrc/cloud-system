package com.wisrc.microservice.configurer;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerRedirectConfigurer {

    // swagger服务地址
    @RequestMapping(value = "/swagger")
    public String swaggerRedirect(){
        return "redirect:/swagger-ui.html";
    }

}
