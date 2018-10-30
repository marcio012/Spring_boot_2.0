package develop_spring_react.springreactbook.domain;

import develop_spring_react.springreactbook.entity.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {



}
