package cn.rongcapital.mc2.me.ewq.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
