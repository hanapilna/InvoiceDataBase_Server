package cz.itnetwork.entity.repository;

import cz.itnetwork.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long>, JpaSpecificationExecutor<InvoiceEntity> {

    List<InvoiceEntity> findBySellerId(Long id);

    List<InvoiceEntity> findByBuyerId(Long id);

    @Query(value = "SELECT" +
            "(SELECT COUNT(*) FROM `invoice`) AS invoicesCount," +
            "(SELECT SUM(`price`) FROM `invoice`) AS allTimeSum," +
            "(SELECT SUM(`price`) FROM `invoice` WHERE YEAR(`issued`) = YEAR(CURRENT_TIMESTAMP)) AS currentYearSum;", nativeQuery = true)
    List<Object[]> getGeneralStatistics();

}
