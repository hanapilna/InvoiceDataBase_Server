package cz.itnetwork.controller;

import cz.itnetwork.dto.GeneralStatisticsDTO;
import cz.itnetwork.dto.PersonStatisticsDTO;
import cz.itnetwork.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StatisticsController {
    @Autowired
    StatisticsService statisticsService;

    @GetMapping("/invoices/statistics")
    public GeneralStatisticsDTO getOverallStatistics(){
        return statisticsService.getGeneralStatistics();
    }

    @GetMapping("/persons/statistics")
    public List<PersonStatisticsDTO> getRevenuesForSellers() { return statisticsService.getStatisticsForSellers(); }
}
