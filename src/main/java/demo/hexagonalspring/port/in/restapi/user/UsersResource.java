package demo.hexagonalspring.port.in.restapi.user;

import com.naharoo.commons.mapstruct.MappingFacade;
import demo.hexagonalspring.domain.user.User;
import demo.hexagonalspring.domain.user.UserCreationRequest;
import demo.hexagonalspring.port.in.restapi.user.model.UserCreationRequestDto;
import demo.hexagonalspring.port.in.restapi.user.model.UserDto;
import demo.hexagonalspring.usecase.user.CreateUserUseCase;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
public class UsersResource {

  private final MappingFacade mappingFacade;
  private final CreateUserUseCase createUserUseCase;

  public UsersResource(
      final MappingFacade mappingFacade, final CreateUserUseCase createUserUseCase) {
    this.mappingFacade = mappingFacade;
    this.createUserUseCase = createUserUseCase;
  }

  @GetMapping("/{id}")
  public UserDto getById(@NotBlank @PathVariable("id") final Long id) {
    throw new IllegalStateException();
  }

  @PostMapping
  public UserDto create(
      @Valid @NotNull @RequestBody final UserCreationRequestDto creationRequestDto) {
    log.debug("Creating User...");

    final UserCreationRequest creationRequest =
        mappingFacade.map(creationRequestDto, UserCreationRequest.class);
    final User user = createUserUseCase.create(creationRequest);
    final UserDto userDto = mappingFacade.map(user, UserDto.class);

    log.info("Successfully created User:{}.", userDto.getId());
    return userDto;
  }
}
