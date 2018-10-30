package develop_spring_react.springreactbook.domain;

import develop_spring_react.springreactbook.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
