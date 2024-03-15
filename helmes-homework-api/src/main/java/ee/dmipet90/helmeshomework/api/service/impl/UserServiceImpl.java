package ee.dmipet90.helmeshomework.api.service.impl;

import ee.dmipet90.helmeshomework.api.dto.UserDto;
import ee.dmipet90.helmeshomework.api.entity.Sector;
import ee.dmipet90.helmeshomework.api.entity.User;
import ee.dmipet90.helmeshomework.api.exception.SectorNotFoundException;
import ee.dmipet90.helmeshomework.api.exception.UserNotFoundException;
import ee.dmipet90.helmeshomework.api.mapper.UserMapper;
import ee.dmipet90.helmeshomework.api.repository.SectorRepository;
import ee.dmipet90.helmeshomework.api.repository.UserRepository;
import ee.dmipet90.helmeshomework.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SectorRepository sectorRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());
        List<String> sectorIds = userDto.getSectorIds();
        Set<Sector> sectors = findSectorsBySectorIds(sectorIds);
        User user = userMapper.userDtoToUserEntity(userDto);
        user.setSectors(sectors);
        userRepository.save(user);
        return userMapper.userEntityToUserDto(user);
    }

    @Override
    public UserDto updateUser(String userId, UserDto userDto) {
        User existingUser = findUserByUserId(userId);
        List<String> sectorIds = userDto.getSectorIds();
        Set<Sector> sectors = findSectorsBySectorIds(sectorIds);
        existingUser.setName(userDto.getName());
        existingUser.setSectors(sectors);
        existingUser.setTermsAgreed(userDto.isTermsAgreed());
        userRepository.save(existingUser);
        return userMapper.userEntityToUserDto(existingUser);
    }

    @Override
    public UserDto getUser(String userId) {
        User existingUser = findUserByUserId(userId);
        return userMapper.userEntityToUserDto(existingUser);
    }

    private User findUserByUserId (String userId) {
        User existingUser = userRepository.findByUserId(userId);
        if (existingUser == null) {
            throw new UserNotFoundException("No user with id '" + userId + "' found");
        }
        return existingUser;
    }

    private Set<Sector> findSectorsBySectorIds (List<String> sectorIds) {
        Set<Sector> sectors = new HashSet<>();
        sectorIds.forEach(sectorId -> {
            Sector sector = sectorRepository.findBySectorId(sectorId);
            if (sector == null) {
                throw new SectorNotFoundException("No sector with id '" + sectorId + "' found");
            }
            sectors.add(sector);
        });
        return sectors;
    }
}
