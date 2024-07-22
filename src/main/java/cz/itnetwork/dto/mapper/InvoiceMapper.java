package cz.itnetwork.dto.mapper;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.entity.InvoiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {PersonMapper.class})
public interface InvoiceMapper {
    InvoiceEntity toEntity(InvoiceDTO source);

    InvoiceDTO toTDO(InvoiceEntity source);

    @Mapping(target = "buyer", ignore = true)
    @Mapping(target = "seller", ignore = true)
    InvoiceEntity updateEntity(InvoiceDTO source, @MappingTarget InvoiceEntity target);

}
