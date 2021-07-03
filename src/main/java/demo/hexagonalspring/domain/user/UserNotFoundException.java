package demo.hexagonalspring.domain.user;

import demo.hexagonalspring.domain.DomainModelNotFoundException;

public class UserNotFoundException extends DomainModelNotFoundException {

  public UserNotFoundException(final String identifier) {
    super(User.class, identifier);
  }

  public UserNotFoundException() {
    super(User.class);
  }
}
