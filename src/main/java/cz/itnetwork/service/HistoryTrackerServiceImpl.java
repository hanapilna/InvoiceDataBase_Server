package cz.itnetwork.service;

import cz.itnetwork.constant.ChangeTypes;
import cz.itnetwork.dto.HistoryTrackerDTO;
import cz.itnetwork.dto.mapper.HistoryTrackerMapper;
import cz.itnetwork.entity.HistoryTrackerEntity;
import cz.itnetwork.entity.repository.HistoryTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryTrackerServiceImpl implements HistoryTrackerService{
    @Autowired
    private HistoryTrackerRepository historyTrackerRepository;

    @Autowired
    private HistoryTrackerMapper historyTrackerMapper;

    @Override
    public void add(HistoryTrackerDTO historyTrackerDTO, boolean change){

        historyTrackerDTO.setCreated(LocalDate.now());
        if(change){
            historyTrackerDTO.setChangeType(ChangeTypes.UPDATE);
        }else {
            historyTrackerDTO.setChangeType(ChangeTypes.DELETE);
        }

        HistoryTrackerEntity historyTrackerEntityToBeSaved = historyTrackerMapper.toEntity(historyTrackerDTO);
        historyTrackerRepository.save(historyTrackerEntityToBeSaved);
    }

    @Override
    public List<HistoryTrackerDTO> getAllForPerson(String identificationNumber) {
        List<HistoryTrackerEntity> entityList = new ArrayList<>(historyTrackerRepository.findByIdentificationNumber(identificationNumber));
        return entityList.stream()
                .map(i -> historyTrackerMapper.toDTO(i))
                .toList();

    }
}
