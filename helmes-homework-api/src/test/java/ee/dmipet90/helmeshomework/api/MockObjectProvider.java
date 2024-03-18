package ee.dmipet90.helmeshomework.api;

import ee.dmipet90.helmeshomework.api.dto.SectorDto;
import ee.dmipet90.helmeshomework.api.dto.UserDto;
import ee.dmipet90.helmeshomework.api.entity.Sector;
import ee.dmipet90.helmeshomework.api.entity.User;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@UtilityClass
public class MockObjectProvider {
    public static User getUser() {
        User user = new User();
        user.setId(1L);
        user.setUserId("qwerty");
        user.setName("Dmitri");
        user.setSectors(getSectors());
        user.setTermsAgreed(true);

        return user;
    }

    public static UserDto getUserDtoWithSectorIds() {
        UserDto userDto = new UserDto();
        userDto.setUserId("qwerty");
        userDto.setName("Dmitri");
        userDto.setSectors(new LinkedHashSet<>());
        userDto.setTermsAgreed(true);
        List<String> sectorIds = new ArrayList<>();
        sectorIds.add("321ytrewq");
        userDto.setSectorIds(sectorIds);
        return userDto;
    }

    public static UserDto getUserDto() {
        UserDto userDto = new UserDto();
        userDto.setUserId("qwerty");
        userDto.setName("Dmitri");
        userDto.setSectors(getSectorDtos());
        userDto.setTermsAgreed(true);
        return userDto;
    }

    public static Set<Sector> getSectors() {
        Sector sector1 = new Sector();
        sector1.setId(1L);
        sector1.setSectorId("321ytrewq");
        sector1.setName("Manufacturing");
        sector1.setDepth(0);
        sector1.setParent(null);
        sector1.setChildren(new LinkedHashSet<>());

        Sector sector2 = new Sector();
        sector2.setId(2L);
        sector2.setSectorId("qwerty123");
        sector2.setName("Sport");
        sector2.setDepth(0);
        sector2.setParent(null);
        sector2.setChildren(new LinkedHashSet<>());

        Set<Sector> sectors = new LinkedHashSet<>();
        sectors.add(sector1);
        sectors.add(sector2);

        return sectors;
    }

    public static Set<SectorDto> getSectorDtos() {
        SectorDto sectorDto1 = new SectorDto();
        sectorDto1.setSectorId("321ytrewq");
        sectorDto1.setName("Manufacturing");
        sectorDto1.setDepth(0);
        sectorDto1.setChildren(new LinkedHashSet<>());

        SectorDto sectorDto2 = new SectorDto();
        sectorDto2.setSectorId("qwerty123");
        sectorDto2.setName("Sport");
        sectorDto2.setDepth(0);
        sectorDto2.setChildren(new LinkedHashSet<>());

        Set<SectorDto> sectorDtos = new LinkedHashSet<>();
        sectorDtos.add(sectorDto1);
        sectorDtos.add(sectorDto2);

        return sectorDtos;
    }
}
