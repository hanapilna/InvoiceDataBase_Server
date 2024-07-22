package cz.itnetwork.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PersonStatisticsDTO {
    private Long personId;
    private String identificationNumber;
    private String personName;
    private BigDecimal revenue;
    private BigDecimal expenses;

}
