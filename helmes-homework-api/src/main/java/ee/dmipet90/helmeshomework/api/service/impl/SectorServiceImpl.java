package ee.dmipet90.helmeshomework.api.service.impl;

import ee.dmipet90.helmeshomework.api.dto.SectorDto;
import ee.dmipet90.helmeshomework.api.entity.Sector;
import ee.dmipet90.helmeshomework.api.mapper.SectorMapper;
import ee.dmipet90.helmeshomework.api.repository.SectorRepository;
import ee.dmipet90.helmeshomework.api.service.SectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectorServiceImpl implements SectorService {
    private final SectorRepository sectorRepository;
    private final SectorMapper sectorMapper;

    @Override
    public Iterable<SectorDto> getAllSectors() {
        List<Sector> sectors = sectorRepository.findAllByParentIsNull();
        return sectorMapper.sectorsToSectorDtos(sectors);
    }


}
