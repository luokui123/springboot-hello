package demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"demo.controller","demo.service","demo.dao","demo.web"})
@MapperScan(basePackages={"demo.dao"})
public class Application {
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
