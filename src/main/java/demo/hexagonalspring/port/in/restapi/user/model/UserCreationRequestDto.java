package demo.hexagonalspring.port.in.restapi.user.model;

import demo.hexagonalspring.port.in.restapi.DtoModel;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.With;

@With
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserCreationRequestDto extends DtoModel {
  @NotBlank private String firstName;
  @NotBlank private String lastName;
  @NotNull private LocalDate birthday;
}
