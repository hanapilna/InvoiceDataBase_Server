package cz.itnetwork.service;

import cz.itnetwork.dto.GeneralStatisticsDTO;
import cz.itnetwork.dto.PersonStatisticsDTO;
import java.util.List;

public interface StatisticsService {

    /**
     * Gets the general statistics with overall sum of prices for all invoices in the database, sum of prices for the current year and the number of invoices
     * @return generalStatisticsDTO with passed statistics
     */
    GeneralStatisticsDTO getGeneralStatistics();

    /**
     * Fetches all personEntities that are not [hidden] and gets their overall revenue
     * @return List of PersonStatisticsDTO
     */
    List<PersonStatisticsDTO> getStatisticsForSellers();
}
