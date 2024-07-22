package cz.itnetwork.entity.filter;

import cz.itnetwork.entity.PersonEntity;
import lombok.Data;

@Data
public class InvoiceFilter {
    private PersonEntity buyer;
    private PersonEntity seller;
    private String product;
    private Integer minPrice;
    private Integer maxPrice;
    private Integer limit = Integer.MAX_VALUE;
}
