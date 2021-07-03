package demo.hexagonalspring.domain.user;

import static demo.hexagonalspring.domain.user.User.Constants.Column.BIRTHDAY;
import static demo.hexagonalspring.domain.user.User.Constants.Column.FIRST_NAME;
import static demo.hexagonalspring.domain.user.User.Constants.Column.ID;
import static demo.hexagonalspring.domain.user.User.Constants.Column.LAST_NAME;
import static demo.hexagonalspring.domain.user.User.Constants.TABLE_NAME;
import static javax.persistence.GenerationType.IDENTITY;

import demo.hexagonalspring.domain.DomainModel;
import demo.hexagonalspring.domain.PersistentModel;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.With;

@With
@Data
@Builder
@ToString
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = TABLE_NAME)
public class User extends DomainModel implements PersistentModel {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = ID, nullable = false, insertable = false, updatable = false, unique = true)
  @EqualsAndHashCode.Include
  private Long id;

  @Column(name = FIRST_NAME, nullable = false)
  private String firstName;

  @Column(name = LAST_NAME, nullable = false)
  private String lastName;

  @Column(name = BIRTHDAY, nullable = false)
  private LocalDate birthday;

  interface Constants {
    String TABLE_NAME = "users";

    interface Column {
      String ID = "id";
      String FIRST_NAME = "first_name";
      String LAST_NAME = "last_name";
      String BIRTHDAY = "birthday";
    }
  }
}
