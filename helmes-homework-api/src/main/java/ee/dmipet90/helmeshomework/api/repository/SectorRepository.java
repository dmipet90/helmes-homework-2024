package ee.dmipet90.helmeshomework.api.repository;

import ee.dmipet90.helmeshomework.api.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<Sector, Long> {
    Sector findBySectorId(String sectorId);
    Iterable<Sector> findAllByParentIsNull();
}
