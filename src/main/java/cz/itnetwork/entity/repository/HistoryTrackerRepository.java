package cz.itnetwork.entity.repository;

import cz.itnetwork.entity.HistoryTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryTrackerRepository extends JpaRepository<HistoryTrackerEntity, Long> {

    List<HistoryTrackerEntity> findByIdentificationNumber(String identificationNumber);
}
