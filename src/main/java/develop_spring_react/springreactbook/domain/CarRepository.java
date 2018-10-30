package develop_spring_react.springreactbook.domain;

import develop_spring_react.springreactbook.entity.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    // extender a class CrudRepository ja tem todo o CRUD padão pelo Spring;

    // busca pela Brand
    List<Car> findByBrand (String brand);

    // busca pela cor
    List<Car> findByColor(String color);

    // busca pelo ano
    List<Car> findByYear(int year);

    // outros tipos de buscas

    // Busca por marca e modelo
    List<Car> findByBrandAndColor(String brand, String model);

    // Busca por marca ou cor
    List<Car> findByBrandOrColor(String brand, String cor);

    // Busca por ordenação
    List<Car> findByBrandOrderByYearAsc(String brand);



    // busca por query SQL
    // @Query("select c from Car c where c.brand = ?1")
    // List<Car> findByBrand(String brand);

    // busca com query usando o LIKE
    // @Query("select c from Car c where c.brand like %?1")
    // List<Car> findByBrandEndsWith(String brand);

    // PagingAndSortingRepository Usar essa classe para paginação
    // de grandes quantidades de dados.
}
