package com.encore.outpick_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.encore.outpick_backend.Login.mapper")
public class OutpickBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutpickBackendApplication.class, args);
	}

}
