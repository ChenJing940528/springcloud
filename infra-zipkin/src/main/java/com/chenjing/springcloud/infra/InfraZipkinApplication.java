package com.chenjing.springcloud.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;


@SpringBootApplication
@EnableZipkinServer
public class InfraZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfraZipkinApplication.class, args);
	}
}
