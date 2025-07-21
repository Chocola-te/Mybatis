package com.example.julspringweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.HiddenHttpMethodFilter;

// 서버 동작, ComponentScan
@SpringBootApplication

// 내가 속한 패키지와 그 하위 패키지를 자동 스캔
@ComponentScan(basePackages = "com.example")
public class JulspringwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(JulspringwebApplication.class, args);
	}

  @Bean
  HiddenHttpMethodFilter hiddenHttpMethodFilter() {
    return new HiddenHttpMethodFilter();
  } // _method라는 이름으로 전달된 값을 요청방식으로 인식한다.

}
