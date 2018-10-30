package develop_spring_react.springreactbook.web;

import develop_spring_react.springreactbook.domain.CarRepository;
import develop_spring_react.springreactbook.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;



    @RequestMapping("/cars")
    public Iterable<Car> getCars() {
        return carRepository.findAll();
    }
}
