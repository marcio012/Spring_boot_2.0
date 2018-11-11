package develop_spring_react.springreactbook.domain;

import develop_spring_react.springreactbook.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository repository;

    @Test
    public void saveCar() {
        Car car = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000);
        entityManager.persistAndFlush(car);

        assertThat(car.getId()).isNotNull();
    }

    @Test
    public void deleteCars() {
        entityManager.persistAndFlush(
                new Car(
                        "Fusca",
                        "Modelo 70",
                        "Branco",
                        "ABC-1234",
                        1970,
                        5000
                ));

        entityManager.persistAndFlush(
                new Car(
                        "Min",
                        "Coopeer",
                        "Amarelo Banana",
                        "DEV-6788",
                        2010,
                        15000
                ));

        repository.deleteAll();
        assertThat(repository.findAll()).isEmpty();
    }

}