package demo.hexagonalspring.port.in.restapi.user.model;

import com.naharoo.commons.mapstruct.UnidirectionalMapper;
import demo.hexagonalspring.domain.user.UserCreationRequest;
import org.mapstruct.Mapper;

@Mapper
public interface UserCreationRequestDtoMapper
    extends UnidirectionalMapper<UserCreationRequestDto, UserCreationRequest> {}
