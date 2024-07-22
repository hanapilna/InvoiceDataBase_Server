package cz.itnetwork.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.itnetwork.constant.Countries;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    @JsonProperty("_id")
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String identificationNumber;

    @NotBlank
    @Size(min=6, message = "DIČ musí mít alespoň 6 znaků")
    private String taxNumber;

    @NotBlank
    @Size(min=6, message = "Číslo účtu musí mít alespoň 6 znaků")
    private String accountNumber;

    @NotBlank
    @Size(min=4, max=4, message = "Vyplňte validní kód banky")
    private String bankCode;
    private String iban;

    @NotBlank
    @Size(min = 12, max = 13, message = "Vyplňte validní telefonní číslo s předvolbou")
    private String telephone;

    @NotBlank
    @Email
    private String mail;

    @NotBlank(message = "Ulice musí být vyplněná")
    private String street;

    @NotBlank
    @Size(min=5, max = 5, message = "Vyplňte validní PSČ")
    private String zip;

    @NotBlank(message = "Město musí být vyplněné")
    private String city;

    private Countries country;
    private String note;
}
