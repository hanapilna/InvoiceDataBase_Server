package cz.itnetwork.entity;

import cz.itnetwork.constant.ChangeTypes;
import cz.itnetwork.constant.Countries;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "history_tracker")
@Getter
@Setter
public class HistoryTrackerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String identificationNumber;

    @Column
    private String taxNumber;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String bankCode;

    @Column
    private String iban;

    @Column(nullable = false)
    private String telephone;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String zip;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Countries country;

    @Column
    private String note;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ChangeTypes changeType;

    @Column
    private LocalDate created;
}
