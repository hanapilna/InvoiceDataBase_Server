package cz.itnetwork.entity;

import cz.itnetwork.constant.ChangeTypes;
import cz.itnetwork.constant.Countries;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HistoryTrackerEntity.class)
public abstract class HistoryTrackerEntity_ {

	public static volatile SingularAttribute<HistoryTrackerEntity, String> zip;
	public static volatile SingularAttribute<HistoryTrackerEntity, String> bankCode;
	public static volatile SingularAttribute<HistoryTrackerEntity, Countries> country;
	public static volatile SingularAttribute<HistoryTrackerEntity, String> note;
	public static volatile SingularAttribute<HistoryTrackerEntity, String> mail;
	public static volatile SingularAttribute<HistoryTrackerEntity, String> city;
	public static volatile SingularAttribute<HistoryTrackerEntity, LocalDate> created;
	public static volatile SingularAttribute<HistoryTrackerEntity, ChangeTypes> changeType;
	public static volatile SingularAttribute<HistoryTrackerEntity, String> taxNumber;
	public static volatile SingularAttribute<HistoryTrackerEntity, String> telephone;
	public static volatile SingularAttribute<HistoryTrackerEntity, String> accountNumber;
	public static volatile SingularAttribute<HistoryTrackerEntity, String> street;
	public static volatile SingularAttribute<HistoryTrackerEntity, String> iban;
	public static volatile SingularAttribute<HistoryTrackerEntity, String> name;
	public static volatile SingularAttribute<HistoryTrackerEntity, String> identificationNumber;
	public static volatile SingularAttribute<HistoryTrackerEntity, Long> id;

	public static final String ZIP = "zip";
	public static final String BANK_CODE = "bankCode";
	public static final String COUNTRY = "country";
	public static final String NOTE = "note";
	public static final String MAIL = "mail";
	public static final String CITY = "city";
	public static final String CREATED = "created";
	public static final String CHANGE_TYPE = "changeType";
	public static final String TAX_NUMBER = "taxNumber";
	public static final String TELEPHONE = "telephone";
	public static final String ACCOUNT_NUMBER = "accountNumber";
	public static final String STREET = "street";
	public static final String IBAN = "iban";
	public static final String NAME = "name";
	public static final String IDENTIFICATION_NUMBER = "identificationNumber";
	public static final String ID = "id";

}

