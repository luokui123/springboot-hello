package demo.web;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import demo.Application;

public class ApplicationBuilder extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    // 此处Application.class替换为springboot默认启动类
	    return builder.sources(Application.class);
    }

}
