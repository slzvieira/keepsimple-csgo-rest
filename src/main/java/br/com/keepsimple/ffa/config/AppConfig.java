package br.com.keepsimple.ffa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.keepsimple.ffa.interceptor.ControllerInterceptor;

@Component
public class AppConfig extends WebMvcConfigurerAdapter {

    
    @Autowired
    private ControllerInterceptor interceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }
}
