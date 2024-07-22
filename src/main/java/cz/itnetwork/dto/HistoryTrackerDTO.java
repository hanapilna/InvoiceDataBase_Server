package cz.itnetwork.dto;

import cz.itnetwork.constant.ChangeTypes;
import cz.itnetwork.constant.Countries;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryTrackerDTO {

    private Long id;
    private String name;
    private String identificationNumber;
    private String taxNumber;
    private String accountNumber;
    private String bankCode;
    private String iban;
    private String telephone;
    private String mail;
    private String street;
    private String zip;
    private String city;
    private Countries country;
    private String note;
    private ChangeTypes changeType;
    private LocalDate created;
}
