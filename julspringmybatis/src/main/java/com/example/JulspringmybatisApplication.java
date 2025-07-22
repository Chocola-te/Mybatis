package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
// 프로젝트에 있는 파일을 스캔해 Bean 생성
public class JulspringmybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(JulspringmybatisApplication.class, args);
	}

  @Bean
  HiddenHttpMethodFilter hiddenHttpMethodFilter() {
    return new HiddenHttpMethodFilter();
  }

}
