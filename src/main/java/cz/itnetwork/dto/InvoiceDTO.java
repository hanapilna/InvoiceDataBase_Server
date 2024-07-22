package cz.itnetwork.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO {

    @JsonProperty("_id")
    private Long id;

    @NotNull
    private int invoiceNumber;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate issued;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dueDate;

    @NotNull
    private String product;

    @NotNull
    private BigDecimal price;

    @NotNull
    private int vat;

    private String note;

    @NotNull
    private PersonDTO buyer;

    @NotNull
    private PersonDTO seller;
}
