package ee.dmipet90.helmeshomework.api.service;

import ee.dmipet90.helmeshomework.api.MockObjectProvider;
import ee.dmipet90.helmeshomework.api.dto.SectorDto;
import ee.dmipet90.helmeshomework.api.dto.UserDto;
import ee.dmipet90.helmeshomework.api.entity.Sector;
import ee.dmipet90.helmeshomework.api.entity.User;
import ee.dmipet90.helmeshomework.api.exception.UserNotFoundException;
import ee.dmipet90.helmeshomework.api.mapper.UserMapper;
import ee.dmipet90.helmeshomework.api.mapper.UserMapperImpl;
import ee.dmipet90.helmeshomework.api.repository.SectorRepository;
import ee.dmipet90.helmeshomework.api.repository.UserRepository;
import ee.dmipet90.helmeshomework.api.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;
    @Mock
    UserRepository userRepository;
    @Mock
    SectorRepository sectorRepository;
    @Spy
    UserMapper userMapper = new UserMapperImpl();

    @Test
    final void testCreateUser() {

        String name = "Dmitri";
        Sector sector = MockObjectProvider.getSectors().stream().toList().get(0);
        UserDto userDto = MockObjectProvider.getUserDtoWithSectorIds();

        // given
        given(sectorRepository.findBySectorId(any())).willReturn(sector);

        // when
        userService.createUser(userDto);
        // then
        then(sectorRepository).should().findBySectorId("321ytrewq");
        then(userRepository).should().save(argThat((User savedUser) ->
                savedUser.getName().equals(name)
                        && savedUser.getSectors().contains(sector)
                        && savedUser.isTermsAgreed()));
        then(userMapper).should().userEntityToUserDto(argThat((User savedUser) ->
                savedUser.getName().equals(name)
                        && savedUser.getSectors().contains(sector)
                        && savedUser.isTermsAgreed()));
    }

    @Test
    final void testUpdateUser() {

        String userId = "qwerty";
        User user = MockObjectProvider.getUser();
        Sector sector = MockObjectProvider.getSectors().stream().toList().get(0);
        SectorDto sectorDto = MockObjectProvider.getSectorDtos().stream().toList().get(0);
        UserDto userDto = MockObjectProvider.getUserDtoWithSectorIds();
        UserDto expectedUserDto = MockObjectProvider.getUserDto();
        expectedUserDto.setSectors(Set.of(sectorDto));

        // given
        given(userRepository.findByUserId(any())).willReturn(user);
        given(sectorRepository.findBySectorId(any())).willReturn(sector);

        // when
        UserDto actualUserDto = userService.updateUser(userId, userDto);

        // then
        then(userRepository).should().findByUserId(userId);
        then(sectorRepository).should().findBySectorId("321ytrewq");
        then(userRepository).should().save(argThat((User savedUser) ->
                savedUser.getName().equals("Dmitri")
                        && savedUser.getSectors().contains(sector)
                        && savedUser.isTermsAgreed()));
        then(userMapper).should().userEntityToUserDto(user);
        assertThat(actualUserDto).usingRecursiveComparison().isEqualTo(expectedUserDto);
    }

    @Test
    final void testGetUser() {

        String userId = "qwerty";
        User user = MockObjectProvider.getUser();
        UserDto expectedUserDto = MockObjectProvider.getUserDto();

        // given
        given(userRepository.findByUserId(any())).willReturn(user);

        // when
        UserDto actualUserDto = userService.getUser(userId);

        // then
        then(userRepository).should().findByUserId(userId);
        then(userMapper).should().userEntityToUserDto(user);
        assertThat(actualUserDto).usingRecursiveComparison().isEqualTo(expectedUserDto);
    }

    @Test
    final void testUser_UserNotFoundException() {

        // given
        given(userRepository.findByUserId(any())).willReturn(null);

        // then
        assertThrows(UserNotFoundException.class, () -> userService.getUser("qwerty"));
    }

}