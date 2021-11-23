package by.salei.gym.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "by.salei.gym.dao.entity")
@ComponentScan("by.salei.gym")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
