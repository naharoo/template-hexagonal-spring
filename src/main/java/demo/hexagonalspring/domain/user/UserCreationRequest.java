package demo.hexagonalspring.domain.user;

import demo.hexagonalspring.domain.DomainModel;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.With;

@With
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserCreationRequest extends DomainModel {
  @NonNull private String firstName;
  @NonNull private String lastName;
  @NonNull private LocalDate birthday;
}
