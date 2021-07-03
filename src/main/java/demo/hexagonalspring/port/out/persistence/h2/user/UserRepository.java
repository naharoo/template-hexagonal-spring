package demo.hexagonalspring.port.out.persistence.h2.user;

import demo.hexagonalspring.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
