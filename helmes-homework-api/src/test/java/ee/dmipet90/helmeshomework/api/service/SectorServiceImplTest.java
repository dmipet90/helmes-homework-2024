package ee.dmipet90.helmeshomework.api.service;

import ee.dmipet90.helmeshomework.api.MockObjectProvider;
import ee.dmipet90.helmeshomework.api.dto.SectorDto;
import ee.dmipet90.helmeshomework.api.entity.Sector;
import ee.dmipet90.helmeshomework.api.mapper.SectorMapper;
import ee.dmipet90.helmeshomework.api.mapper.SectorMapperImpl;
import ee.dmipet90.helmeshomework.api.repository.SectorRepository;
import ee.dmipet90.helmeshomework.api.service.impl.SectorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class SectorServiceImplTest {
    @InjectMocks
    SectorServiceImpl sectorService;
    @Mock
    SectorRepository sectorRepository;
    @Spy
    SectorMapper sectorMapper = new SectorMapperImpl();

    @Test
    final void getAllSectors() {

        Iterable<Sector> sectors = MockObjectProvider.getSectors();
        Iterable<SectorDto> expectedSectorDtos = MockObjectProvider.getSectorDtos();

        // given
        given(sectorRepository.findAllByParentIsNull()).willReturn(sectors);

        // when
        Iterable<SectorDto> actualSectorDtos = sectorService.getAllSectors();

        // then
        then(sectorRepository).should().findAllByParentIsNull();
        then(sectorMapper).should().sectorsToSectorDtos(sectors);
        assertThat(actualSectorDtos).usingRecursiveComparison().isEqualTo(expectedSectorDtos);
    }
}
