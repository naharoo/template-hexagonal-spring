package demo.hexagonalspring.domain.user.operations;

import demo.hexagonalspring.domain.DomainModelOperations;
import demo.hexagonalspring.domain.user.User;
import java.util.Optional;

public interface UserQueryOperations extends DomainModelOperations<User> {
  Optional<User> findById(Long id);
}
