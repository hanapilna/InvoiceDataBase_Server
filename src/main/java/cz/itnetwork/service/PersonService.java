package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.PersonDTO;
import java.util.List;

public interface PersonService {

    /**
     * Creates a new person
     *
     * @param personDTO Person to create
     * @return newly created person
     */
    PersonDTO addPerson(PersonDTO personDTO);

    /**
     * <p>Saves the person to be deleted into HistoryTrackerRepository and then removes the person from PersonRepository</p>
     * <p>In case a person with the passed [id] isn't found, the method <b>silently fails</b></p>
     *
     * @param id Person to delete
     */
    void removePerson(Long id);

    /**
     * Fetches all persons
     *
     * @return List of all non-hidden persons
     */
    List<PersonDTO> getAll();

    /**
     * Fetches person by their ID
     * @param id
     * @return personDTO
     */
    PersonDTO getPersonById(Long id);

    /**
     * Fetches all invoices based on the person Id
     * @param id person id
     * @param personType buyer or seller
     * @return list of InvoiceDTO
     */
    List<InvoiceDTO> getAllInvoicesForPerson(Long id, String personType);

    /**
     * Edits person identified by its Id; the original person is set as hidden and a new one with updated data is created
     * @param id
     * @param personDTO
     * @return updated personDTO
     */
    PersonDTO editPerson(Long id, PersonDTO personDTO);

}
