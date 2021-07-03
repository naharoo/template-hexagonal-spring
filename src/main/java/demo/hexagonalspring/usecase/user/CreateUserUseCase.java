package demo.hexagonalspring.usecase.user;

import demo.hexagonalspring.domain.user.User;
import demo.hexagonalspring.domain.user.UserCreationRequest;
import demo.hexagonalspring.domain.user.operations.UserCommandOperations;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CreateUserUseCase {

  private final UserCommandOperations userCommandOperations;

  public CreateUserUseCase(final UserCommandOperations userCommandOperations) {
    this.userCommandOperations = userCommandOperations;
  }

  @Transactional
  public User create(@NonNull final UserCreationRequest creationRequest) {
    final User userToCreate =
        User.builder()
            .firstName(creationRequest.getFirstName())
            .lastName(creationRequest.getLastName())
            .birthday(creationRequest.getBirthday())
            .build();

    return userCommandOperations.createOrUpdate(userToCreate);
  }
}
