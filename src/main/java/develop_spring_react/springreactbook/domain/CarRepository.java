package develop_spring_react.springreactbook.domain;

import develop_spring_react.springreactbook.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {

    // extender a class CrudRepository ja tem todo o CRUD padão pelo Spring;

    // busca pela Brand
    List<Car> findByBrand (@Param("brand") String brand);

    // busca pela cor
    List<Car> findByColor(@Param("color") String color);

    // busca pelo ano
//    List<Car> findByYear(int year);

    // outros tipos de buscas

    // Busca por marca e modelo
//    List<Car> findByBrandAndColor(String brand, String model);

    // Busca por marca ou cor
//    List<Car> findByBrandOrColor(String brand, String cor);

    // Busca por ordenação
//    List<Car> findByBrandOrderByYearAsc(String brand);



    // busca por query SQL
    // @Query("select c from Car c where c.brand = ?1")
    // List<Car> findByBrand(String brand);

    // busca com query usando o LIKE
    // @Query("select c from Car c where c.brand like %?1")
    // List<Car> findByBrandEndsWith(String brand);

    // PagingAndSortingRepository Usar essa classe para paginação
    // de grandes quantidades de dados.
}
