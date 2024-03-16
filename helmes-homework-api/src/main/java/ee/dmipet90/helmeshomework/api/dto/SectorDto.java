package ee.dmipet90.helmeshomework.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class SectorDto {
    private String sectorId;
    private String name;
    private int depth;
    private Set<SectorDto> children;
}
