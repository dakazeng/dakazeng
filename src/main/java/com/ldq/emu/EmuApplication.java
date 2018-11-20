package com.ldq.emu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ldq.emu.dao")
public class EmuApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmuApplication.class, args);
	}
}
