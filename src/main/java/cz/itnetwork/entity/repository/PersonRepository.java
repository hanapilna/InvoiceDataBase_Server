/*  _____ _______         _                      _
 * |_   _|__   __|       | |                    | |
 *   | |    | |_ __   ___| |___      _____  _ __| | __  ___ ____
 *   | |    | | '_ \ / _ \ __\ \ /\ / / _ \| '__| |/ / / __|_  /
 *  _| |_   | | | | |  __/ |_ \ V  V / (_) | |  |   < | (__ / /
 * |_____|  |_|_| |_|\___|\__| \_/\_/ \___/|_|  |_|\_(_)___/___|
 *                                _
 *              ___ ___ ___ _____|_|_ _ _____
 *             | . |  _| -_|     | | | |     |  LICENCE
 *             |  _|_| |___|_|_|_|_|___|_|_|_|
 *             |_|
 *
 *   PROGRAMOVÁNÍ  <>  DESIGN  <>  PRÁCE/PODNIKÁNÍ  <>  HW A SW
 *
 * Tento zdrojový kód je součástí výukových seriálů na
 * IT sociální síti WWW.ITNETWORK.CZ
 *
 * Kód spadá pod licenci prémiového obsahu a vznikl díky podpoře
 * našich členů. Je určen pouze pro osobní užití a nesmí být šířen.
 * Více informací na http://www.itnetwork.cz/licence
 */
package cz.itnetwork.entity.repository;

import cz.itnetwork.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    @Query(value = "SELECT " +
            "person.id AS Id, " +
            "person.identification_number AS identificationNumber, " +
            "person.name AS personName, " +
            "COALESCE(revenue_summary.total_revenue, 0) AS revenue, " +
            "COALESCE(expense_summary.total_expenses, 0) AS expenses " +
            "FROM person " +
            "LEFT JOIN (SELECT seller_id, SUM(price) AS total_revenue FROM invoice GROUP BY seller_id) AS revenue_summary ON person.id = revenue_summary.seller_id " +
            "LEFT JOIN (SELECT buyer_id, SUM(price) AS total_expenses FROM invoice GROUP BY buyer_id) AS expense_summary ON person.id = expense_summary.buyer_id;",
            nativeQuery = true)
    List<Object[]> getPersonRevenueAndExpenses();


    //Notes from review...try to implement the approach bellow...yeh this doesn't seem to be working..but we still made it better with the above
    /*
    @Query("""
            SELECT new cz.itnetwork.dto.PersonStatisticsDTO(
                person.id,
                person.name,
                SUM(INFULL(sales.price, 0)
            )
            FROM person AS person
            LEFT JOIN person.sales AS sales
            GROUP BY person.id
            """)
    List<PersonStatisticsDTO>getPersonStatistics();

     */


}
