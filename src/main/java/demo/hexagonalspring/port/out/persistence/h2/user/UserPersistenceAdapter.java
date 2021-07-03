package demo.hexagonalspring.port.out.persistence.h2.user;

import static org.springframework.transaction.annotation.Propagation.MANDATORY;

import demo.hexagonalspring.domain.user.User;
import demo.hexagonalspring.domain.user.operations.UserCommandOperations;
import demo.hexagonalspring.domain.user.operations.UserQueryOperations;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true, propagation = MANDATORY)
public class UserPersistenceAdapter implements UserQueryOperations, UserCommandOperations {

  private final UserRepository repository;

  public UserPersistenceAdapter(final UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public User createOrUpdate(final User user) {
    return repository.save(user);
  }

  @Override
  public Optional<User> findById(final Long id) {
    return repository.findById(id);
  }
}
