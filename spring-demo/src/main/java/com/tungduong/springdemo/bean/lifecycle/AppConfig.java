
package com.tungduong.springdemo.bean.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfig {

	@Bean(initMethod = "customInitMethod") // Chỉ định tên init method
	public DatabaseConnector databaseConnector() {
		DatabaseConnector connector = new DatabaseConnector();

		// Thực hiện DI cho thuộc tính (Setter Injection)
		connector.setConnectionUrl("jdbc:postgresql://localhost:5432/mydb");
		return connector;
	}
}
