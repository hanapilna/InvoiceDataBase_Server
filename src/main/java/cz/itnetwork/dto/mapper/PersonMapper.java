package cz.itnetwork.dto.mapper;

import cz.itnetwork.dto.PersonDTO;
import cz.itnetwork.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonEntity toEntity(PersonDTO source);

    PersonDTO toDTO(PersonEntity source);

    PersonEntity updateEntity(PersonDTO source,@MappingTarget PersonEntity target);
}
