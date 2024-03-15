package ee.dmipet90.helmeshomework.api.repository;

import ee.dmipet90.helmeshomework.api.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectorRepository extends JpaRepository<Sector, Long> {
    Sector findBySectorId(String sectorId);
    List<Sector> findAllByParentIsNull();
}
