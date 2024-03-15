package ee.dmipet90.helmeshomework.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserDto {
    private String userId;
    private String name;
    private List<String> sectorIds;
    private Set<SectorDto> sectors;
    private boolean termsAgreed;
}
