package develop_spring_react.springreactbook.domain;

import develop_spring_react.springreactbook.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {


}
