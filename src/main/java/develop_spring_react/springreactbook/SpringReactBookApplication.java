package develop_spring_react.springreactbook;

import develop_spring_react.springreactbook.domain.CarRepository;
import develop_spring_react.springreactbook.domain.OwnerRepository;
import develop_spring_react.springreactbook.domain.UserRepository;
import develop_spring_react.springreactbook.entity.Car;
import develop_spring_react.springreactbook.entity.Owner;
import develop_spring_react.springreactbook.entity.User;
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

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired

    public static void main(String[] args) {
        SpringApplication.run(SpringReactBookApplication.class, args);
        logger.info("Hello World.");
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {

            // Salve os dados de demostração no banco de dados
            Owner owner1 = new Owner("Márcio", "Heleno");
            Owner owner2 = new Owner("José", "Levi");
            ownerRepository.save(owner1);
            ownerRepository.save(owner2);


            repository.save(new Car("Ford", "Mustang", "Red", "ADF-1177", 2017, 59000, owner1));
            repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
            repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));
            repository.save(new Car("Siena", "Sedan", "Blue", "MAR-1208", 2015, 22000, owner1));

            // Processo de Bcrypt
            // username user senha: MAR@120881
            //16384$8$1$.53Uk2nQFlg=$2e82c9ccad152313f70747ba68d481b1cdc5ded0f68b3338ed1d6e1b3a649611
            userRepository.save(new User("user",
                    "$2a$04$yvHAiOz399q08118vwcBBeqNqX5EfNu/ZNhVUxTuNBxLbhrSm67ZS",
                    "USER"));

            // user admin senha: 12345678
            // $2y$12$AFfHf7LYvdgM0BFHo/vvM.e9c8P4X76yz6cIUqfxpsaebPex9YrcK

            userRepository.save(new User("admin",
                    "$2a$04$3GwA3gWzNBTUMCc8ACe4Bu4XEqNa3Hna6ABmxiX2oL3fTTLeh603S",
                    "ADMIN"));




        };
    }
}
