package cz.itnetwork.service;

import cz.itnetwork.dto.HistoryTrackerDTO;
import java.util.List;


public interface HistoryTrackerService {
    void add(HistoryTrackerDTO source, boolean change);

    List<HistoryTrackerDTO> getAllForPerson(String identificationNumber);
}
