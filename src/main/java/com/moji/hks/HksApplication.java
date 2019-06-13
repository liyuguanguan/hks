package com.moji.hks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:kaptcha.xml"})
@MapperScan("com.moji.hks.mybaties.mapper")
public class HksApplication {

	public static void main(String[] args) {
		SpringApplication.run(HksApplication.class, args);
	}

}
