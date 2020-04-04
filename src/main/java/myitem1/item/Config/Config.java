package myitem1.item.Config;

import myitem1.item.compoent.LoginHandlerIntercceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class Config implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry){

        registry.addViewController("/").setViewName("login");
        registry.addViewController("login.html").setViewName("login");
        registry.addViewController("/user/login").setViewName("login");
        registry.addViewController("main.html").setViewName("main");

        registry.addViewController("list.html").setViewName("list");

        registry.addViewController("add.html").setViewName("add");
}



/*拦截器*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("拦截器进入");
        registry.addInterceptor(new LoginHandlerIntercceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login","/login.html,/login");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}