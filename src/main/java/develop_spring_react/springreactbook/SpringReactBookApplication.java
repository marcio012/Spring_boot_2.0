package develop_spring_react.springreactbook;

import develop_spring_react.springreactbook.domain.CarRepository;
import develop_spring_react.springreactbook.entity.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.NoRepositoryBean;

@SpringBootApplication
public class SpringReactBookApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringReactBookApplication.class);

    @Autowired
    private CarRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringReactBookApplication.class, args);
        logger.info("Hello World.");
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {

            // Salve os dados de demostração no banco de dados
            repository.save(new Car("Ford", "Mustang", "Red", "ADF-1177", 2017, 59000));
            repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000));
            repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000));
        };
    }
}
