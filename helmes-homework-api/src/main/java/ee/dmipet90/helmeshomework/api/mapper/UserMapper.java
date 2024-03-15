package ee.dmipet90.helmeshomework.api.mapper;

import ee.dmipet90.helmeshomework.api.dto.UserDto;
import ee.dmipet90.helmeshomework.api.entity.User;
import ee.dmipet90.helmeshomework.api.model.UserRequestModel;
import ee.dmipet90.helmeshomework.api.model.UserResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User userDtoToUserEntity(UserDto userDto);
    UserDto userRequestToUserDto(UserRequestModel userRequestModel);
    UserResponseModel userDtoToUserResponse(UserDto userDto);
    UserDto userEntityToUserDto(User user);
}
