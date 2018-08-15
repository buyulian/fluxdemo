package com.me.fluxstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.me.fluxstudy.dao")
public class FluxstudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FluxstudyApplication.class, args);
	}
}
