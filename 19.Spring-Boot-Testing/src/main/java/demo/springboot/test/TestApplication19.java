package demo.springboot.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("demo.springboot.test.mapper")
public class TestApplication19 {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication19.class, args);
	}
}
