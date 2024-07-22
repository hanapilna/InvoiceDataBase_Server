package cz.itnetwork.dto.mapper;

import cz.itnetwork.dto.HistoryTrackerDTO;
import cz.itnetwork.dto.PersonDTO;
import cz.itnetwork.entity.HistoryTrackerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoryTrackerMapper {
    HistoryTrackerEntity toEntity(HistoryTrackerDTO source);

    HistoryTrackerDTO toDTO(HistoryTrackerEntity source);

    HistoryTrackerDTO toSavingDTO(PersonDTO source);
}
