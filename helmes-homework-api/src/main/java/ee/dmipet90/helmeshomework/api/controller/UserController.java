package ee.dmipet90.helmeshomework.api.controller;

import ee.dmipet90.helmeshomework.api.dto.UserDto;
import ee.dmipet90.helmeshomework.api.mapper.UserMapper;
import ee.dmipet90.helmeshomework.api.model.UserRequestModel;
import ee.dmipet90.helmeshomework.api.model.UserResponseModel;
import ee.dmipet90.helmeshomework.api.service.UserService;
import ee.dmipet90.helmeshomework.api.validation.ValidationErrorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final ValidationErrorMapper validationErrorMapper;
    @PostMapping("/create")
    public ResponseEntity<?> createUser(
            @Valid @RequestBody UserRequestModel userDetails, BindingResult result) {
        ResponseEntity<?> errMap = validationErrorMapper.mapValidationError(result);
        if (errMap != null) return errMap;
        UserDto userDto = userMapper.userRequestToUserDto(userDetails);
        userDto = userService.createUser(userDto);
        UserResponseModel response = userMapper.userDtoToUserResponse(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String userId,
            @Valid @RequestBody UserRequestModel userDetails, BindingResult result) {
        ResponseEntity<?> errMap = validationErrorMapper.mapValidationError(result);
        if (errMap != null) return errMap;
        UserDto userDto = userMapper.userRequestToUserDto(userDetails);
        userDto = userService.updateUser(userId, userDto);
        UserResponseModel response = userMapper.userDtoToUserResponse(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseModel> getArtist(@PathVariable String userId) {
        UserDto userDto = userService.getUser(userId);
        UserResponseModel response = userMapper.userDtoToUserResponse(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
