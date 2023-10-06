package com.evangelista.controlecervejaria;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@OpenAPIDefinition(info = @Info(title = "Controle Cervejaria", version = "1", description = "API desenvolvida para o controle pedidos de uma cervejaria"))
@SpringBootApplication
@EnableFeignClients
public class ControleCervejariaApplication{

	public static void main(String[] args) {
		SpringApplication.run(ControleCervejariaApplication.class, args);
	}

}
