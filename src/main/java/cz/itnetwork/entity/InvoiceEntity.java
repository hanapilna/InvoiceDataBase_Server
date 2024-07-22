package cz.itnetwork.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "invoice")
@Getter
@Setter
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int invoiceNumber;

    @Column(nullable = false)
    private LocalDate issued;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Column(nullable = false)
    private String product;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int vat;

    @Column(nullable = true)
    private String note;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private PersonEntity buyer;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private PersonEntity seller;


}
