package ee.dmipet90.helmeshomework.api.service;

import ee.dmipet90.helmeshomework.api.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(String userId, UserDto userDto);

    UserDto getUser(String userId);
}
