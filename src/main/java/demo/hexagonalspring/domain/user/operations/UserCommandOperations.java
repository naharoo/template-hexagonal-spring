package demo.hexagonalspring.domain.user.operations;

import demo.hexagonalspring.domain.DomainModelOperations;
import demo.hexagonalspring.domain.user.User;

public interface UserCommandOperations extends DomainModelOperations<User> {
  User createOrUpdate(User user);
}
