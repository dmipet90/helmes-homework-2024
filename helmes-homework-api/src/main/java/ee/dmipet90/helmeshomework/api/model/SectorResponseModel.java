package ee.dmipet90.helmeshomework.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SectorResponseModel {
    private String sectorId;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<SectorResponseModel> children;

}
