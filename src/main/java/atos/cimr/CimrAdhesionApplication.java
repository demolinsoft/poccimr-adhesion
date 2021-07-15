package atos.cimr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients("atos.cimr.configuration")
public class CimrAdhesionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CimrAdhesionApplication.class, args);
	}

}
