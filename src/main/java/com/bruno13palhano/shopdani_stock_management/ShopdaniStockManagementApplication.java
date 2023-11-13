package com.bruno13palhano.shopdani_stock_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bruno13palhano"})
public class ShopdaniStockManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopdaniStockManagementApplication.class, args);
	}

}
