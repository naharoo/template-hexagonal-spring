package demo.hexagonalspring.port.in.restapi.user.model;

import com.naharoo.commons.mapstruct.UnidirectionalMapper;
import demo.hexagonalspring.domain.user.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserDtoMapper extends UnidirectionalMapper<User, UserDto> {}
