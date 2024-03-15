package ee.dmipet90.helmeshomework.api.mapper;

import ee.dmipet90.helmeshomework.api.dto.SectorDto;
import ee.dmipet90.helmeshomework.api.entity.Sector;
import ee.dmipet90.helmeshomework.api.model.SectorResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Set;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SectorMapper {
    Iterable<SectorDto> sectorsToSectorDtos(Iterable<Sector> sector);
    Iterable<SectorResponseModel> sectorDtosToSectorsResponse(Iterable<SectorDto> sector);
    Set<Sector> sectorDtoSetToSectorSet(Set<SectorDto> sector);

}
