/*  _____ _______         _                      _
 * |_   _|__   __|       | |                    | |
 *   | |    | |_ __   ___| |___      _____  _ __| | __  ___ ____
 *   | |    | | '_ \ / _ \ __\ \ /\ / / _ \| '__| |/ / / __|_  /
 *  _| |_   | | | | |  __/ |_ \ V  V / (_) | |  |   < | (__ / /
 * |_____|  |_|_| |_|\___|\__| \_/\_/ \___/|_|  |_|\_(_)___/___|
 *                                _
 *              ___ ___ ___ _____|_|_ _ _____
 *             | . |  _| -_|     | | | |     |  LICENCE
 *             |  _|_| |___|_|_|_|_|___|_|_|_|
 *             |_|
 *
 *   PROGRAMOVÁNÍ  <>  DESIGN  <>  PRÁCE/PODNIKÁNÍ  <>  HW A SW
 *
 * Tento zdrojový kód je součástí výukových seriálů na
 * IT sociální síti WWW.ITNETWORK.CZ
 *
 * Kód spadá pod licenci prémiového obsahu a vznikl díky podpoře
 * našich členů. Je určen pouze pro osobní užití a nesmí být šířen.
 * Více informací na http://www.itnetwork.cz/licence
 */
package cz.itnetwork.service;

import cz.itnetwork.dto.HistoryTrackerDTO;
import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.PersonDTO;
import cz.itnetwork.dto.mapper.HistoryTrackerMapper;
import cz.itnetwork.dto.mapper.InvoiceMapper;
import cz.itnetwork.dto.mapper.PersonMapper;
import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.PersonEntity;
import cz.itnetwork.entity.repository.InvoiceRepository;
import cz.itnetwork.entity.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private InvoiceMapper invoiceMapper;
    @Autowired
    private HistoryTrackerService historyTrackerService;
    @Autowired
    private HistoryTrackerMapper historyTrackerMapper;
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public PersonDTO addPerson(PersonDTO personDTO) {
        PersonEntity entity = personMapper.toEntity(personDTO);
        entity = personRepository.save(entity);

        return personMapper.toDTO(entity);
    }

    @Override
    public void removePerson(Long personId) {
        try {
            PersonEntity person = fetchPersonById(personId);
            PersonDTO personDTO = personMapper.toDTO(person);
            HistoryTrackerDTO personToBeArchivedDTO= historyTrackerMapper.toSavingDTO(personDTO);
            historyTrackerService.add(personToBeArchivedDTO, false);
            personRepository.delete(person);
        } catch (NotFoundException ignored) {
            // The contract in the interface states, that no exception is thrown, if the entity is not found.
        }
    }

    @Override
    public List<PersonDTO> getAll() {
        return personRepository.findAll()
                .stream()
                .map(i -> personMapper.toDTO(i))
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO getPersonById(Long id) {
        PersonEntity person = fetchPersonById(id);
        return personMapper.toDTO(person);
    }


    @Override
    public PersonDTO editPerson(Long id, PersonDTO personDTO){
        PersonEntity entityToBeArchived = fetchPersonById(id);
        PersonDTO personDTOToBeArchived = personMapper.toDTO(entityToBeArchived);
        personDTOToBeArchived.setId(null);
        HistoryTrackerDTO archivedItem = historyTrackerMapper.toSavingDTO(personDTOToBeArchived);
        historyTrackerService.add(archivedItem, true);

        PersonEntity entityToBeUpdated = fetchPersonById(id);
        personDTO.setId(id);
        PersonEntity updatedEntity = personMapper.updateEntity(personDTO, entityToBeUpdated);
        PersonEntity savedEntity = personRepository.save(updatedEntity);
        return personMapper.toDTO(savedEntity);
    }

    @Override
    public List<InvoiceDTO> getAllInvoicesForPerson(Long id, String personType) {
        List<InvoiceEntity> invoiceEntities = new ArrayList<>();
        if(personType.equals("buyer")){
           invoiceEntities.addAll(invoiceRepository.findByBuyerId(id));
        }else {
           invoiceEntities.addAll(invoiceRepository.findBySellerId(id));
        }
        return invoiceEntities.stream().map(i -> invoiceMapper.toTDO(i)).toList();
    }

    // region: Private methods

    /**
     * <p>Attempts to fetch a person.</p>
     * <p>In case a person with the passed [id] doesn't exist a [{@link org.webjars.NotFoundException}] is thrown.</p>
     *
     * @param id Person to fetch
     * @return Fetched entity
     * @throws org.webjars.NotFoundException In case a person with the passed [id] isn't found
     */
    private PersonEntity fetchPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Person with id " + id + " wasn't found in the database."));
    }

    // endregion
}
