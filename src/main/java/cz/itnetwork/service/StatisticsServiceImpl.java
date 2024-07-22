package cz.itnetwork.service;

import cz.itnetwork.dto.GeneralStatisticsDTO;
import cz.itnetwork.dto.PersonStatisticsDTO;
import cz.itnetwork.entity.repository.InvoiceRepository;
import cz.itnetwork.entity.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;

@Service
public class StatisticsServiceImpl implements StatisticsService{
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    PersonRepository personRepository;

    @Override
    public GeneralStatisticsDTO getGeneralStatistics(){
        GeneralStatisticsDTO statistics = new GeneralStatisticsDTO();
        List<Object[]> rawStatistics = new ArrayList<>(invoiceRepository.getGeneralStatistics());
        statistics.setInvoicesCount((Long) (rawStatistics.get(0)[0]));
        statistics.setAllTimeSum((BigDecimal) (rawStatistics.get(0)[1]));
        statistics.setCurrentYearSum((BigDecimal) (rawStatistics.get(0)[2]));
        return statistics;
    }

    @Override
    public List<PersonStatisticsDTO> getStatisticsForSellers(){
        List<PersonStatisticsDTO> personStatisticsDTOS = new ArrayList<>();
        List<Object[]> rawResultsFromDatabase = new ArrayList<>(personRepository.getPersonRevenueAndExpenses());

        for(Object[] result : rawResultsFromDatabase){
            PersonStatisticsDTO personStatisticsDTO = new PersonStatisticsDTO();
            personStatisticsDTO.setPersonId((Long) result[0]);
            personStatisticsDTO.setIdentificationNumber((String) result[1]);
            personStatisticsDTO.setPersonName((String) result[2]);
            personStatisticsDTO.setRevenue((BigDecimal) result[3]);
            personStatisticsDTO.setExpenses((BigDecimal) result[4]);
            personStatisticsDTOS.add(personStatisticsDTO);
        }
        return personStatisticsDTOS;
    }


}
