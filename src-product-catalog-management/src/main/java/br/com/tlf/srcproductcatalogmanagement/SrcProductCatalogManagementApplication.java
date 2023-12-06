package br.com.tlf.srcproductcatalogmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SrcProductCatalogManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrcProductCatalogManagementApplication.class, args);
	}

}
