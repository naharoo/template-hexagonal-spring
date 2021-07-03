package demo.hexagonalspring.domain.user.utility;

import static org.springframework.transaction.annotation.Propagation.MANDATORY;

import demo.hexagonalspring.domain.user.User;
import demo.hexagonalspring.domain.user.UserNotFoundException;
import demo.hexagonalspring.domain.user.operations.UserQueryOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserByIdExistenceAssuredFetcher {

  private final UserQueryOperations queryOperations;

  public UserByIdExistenceAssuredFetcher(final UserQueryOperations queryOperations) {
    this.queryOperations = queryOperations;
  }

  @Transactional(readOnly = true, propagation = MANDATORY)
  public User fetch(final long id) {
    return queryOperations.findById(id).orElseThrow(UserNotFoundException::new);
  }
}
