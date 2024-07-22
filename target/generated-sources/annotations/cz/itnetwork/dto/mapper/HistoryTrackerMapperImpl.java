package cz.itnetwork.dto.mapper;

import cz.itnetwork.dto.HistoryTrackerDTO;
import cz.itnetwork.dto.PersonDTO;
import cz.itnetwork.entity.HistoryTrackerEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Amazon.com Inc.)"
)
@Component
public class HistoryTrackerMapperImpl implements HistoryTrackerMapper {

    @Override
    public HistoryTrackerEntity toEntity(HistoryTrackerDTO source) {
        if ( source == null ) {
            return null;
        }

        HistoryTrackerEntity historyTrackerEntity = new HistoryTrackerEntity();

        historyTrackerEntity.setId( source.getId() );
        historyTrackerEntity.setName( source.getName() );
        historyTrackerEntity.setIdentificationNumber( source.getIdentificationNumber() );
        historyTrackerEntity.setTaxNumber( source.getTaxNumber() );
        historyTrackerEntity.setAccountNumber( source.getAccountNumber() );
        historyTrackerEntity.setBankCode( source.getBankCode() );
        historyTrackerEntity.setIban( source.getIban() );
        historyTrackerEntity.setTelephone( source.getTelephone() );
        historyTrackerEntity.setMail( source.getMail() );
        historyTrackerEntity.setStreet( source.getStreet() );
        historyTrackerEntity.setZip( source.getZip() );
        historyTrackerEntity.setCity( source.getCity() );
        historyTrackerEntity.setCountry( source.getCountry() );
        historyTrackerEntity.setNote( source.getNote() );
        historyTrackerEntity.setChangeType( source.getChangeType() );
        historyTrackerEntity.setCreated( source.getCreated() );

        return historyTrackerEntity;
    }

    @Override
    public HistoryTrackerDTO toDTO(HistoryTrackerEntity source) {
        if ( source == null ) {
            return null;
        }

        HistoryTrackerDTO historyTrackerDTO = new HistoryTrackerDTO();

        historyTrackerDTO.setId( source.getId() );
        historyTrackerDTO.setName( source.getName() );
        historyTrackerDTO.setIdentificationNumber( source.getIdentificationNumber() );
        historyTrackerDTO.setTaxNumber( source.getTaxNumber() );
        historyTrackerDTO.setAccountNumber( source.getAccountNumber() );
        historyTrackerDTO.setBankCode( source.getBankCode() );
        historyTrackerDTO.setIban( source.getIban() );
        historyTrackerDTO.setTelephone( source.getTelephone() );
        historyTrackerDTO.setMail( source.getMail() );
        historyTrackerDTO.setStreet( source.getStreet() );
        historyTrackerDTO.setZip( source.getZip() );
        historyTrackerDTO.setCity( source.getCity() );
        historyTrackerDTO.setCountry( source.getCountry() );
        historyTrackerDTO.setNote( source.getNote() );
        historyTrackerDTO.setChangeType( source.getChangeType() );
        historyTrackerDTO.setCreated( source.getCreated() );

        return historyTrackerDTO;
    }

    @Override
    public HistoryTrackerDTO toSavingDTO(PersonDTO source) {
        if ( source == null ) {
            return null;
        }

        HistoryTrackerDTO historyTrackerDTO = new HistoryTrackerDTO();

        historyTrackerDTO.setId( source.getId() );
        historyTrackerDTO.setName( source.getName() );
        historyTrackerDTO.setIdentificationNumber( source.getIdentificationNumber() );
        historyTrackerDTO.setTaxNumber( source.getTaxNumber() );
        historyTrackerDTO.setAccountNumber( source.getAccountNumber() );
        historyTrackerDTO.setBankCode( source.getBankCode() );
        historyTrackerDTO.setIban( source.getIban() );
        historyTrackerDTO.setTelephone( source.getTelephone() );
        historyTrackerDTO.setMail( source.getMail() );
        historyTrackerDTO.setStreet( source.getStreet() );
        historyTrackerDTO.setZip( source.getZip() );
        historyTrackerDTO.setCity( source.getCity() );
        historyTrackerDTO.setCountry( source.getCountry() );
        historyTrackerDTO.setNote( source.getNote() );

        return historyTrackerDTO;
    }
}
