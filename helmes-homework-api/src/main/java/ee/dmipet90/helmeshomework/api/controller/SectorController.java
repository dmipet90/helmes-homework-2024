package ee.dmipet90.helmeshomework.api.controller;

import ee.dmipet90.helmeshomework.api.dto.SectorDto;
import ee.dmipet90.helmeshomework.api.mapper.SectorMapper;
import ee.dmipet90.helmeshomework.api.model.SectorResponseModel;
import ee.dmipet90.helmeshomework.api.service.SectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sector")
@CrossOrigin
@RequiredArgsConstructor
public class SectorController {
    private final SectorService sectorService;
    private final SectorMapper sectorMapper;

    @GetMapping("/all")
    public ResponseEntity<Iterable<SectorResponseModel>> getAllSectors() {
        Iterable<SectorDto> sectorDtos = sectorService.getAllSectors();
        Iterable<SectorResponseModel> response =
                sectorMapper.sectorDtosToSectorsResponse(sectorDtos);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
