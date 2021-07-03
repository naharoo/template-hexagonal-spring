package demo.hexagonalspring.port.in.restapi.user.model;

import demo.hexagonalspring.port.in.restapi.DtoModel;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.With;

@With
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends DtoModel {
  private long id;
  private String firstName;
  private String lastName;
  private LocalDate birthday;
}
