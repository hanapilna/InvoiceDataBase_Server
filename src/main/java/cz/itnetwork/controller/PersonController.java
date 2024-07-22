package cz.itnetwork.controller;

import cz.itnetwork.dto.HistoryTrackerDTO;
import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.PersonDTO;
import cz.itnetwork.service.HistoryTrackerService;
import cz.itnetwork.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private HistoryTrackerService historyTrackerService;

    @PostMapping("/persons")
    public PersonDTO addPerson(@Valid @RequestBody PersonDTO personDTO) {
        return  personService.addPerson(personDTO);
    }

    @GetMapping("/persons")
    public List<PersonDTO> getPersons() {
        return personService.getAll();
    }

    @DeleteMapping("/persons/{personId}")
    public void deletePerson(@PathVariable Long personId) {
        personService.removePerson(personId);
    }

    @GetMapping("/persons/{personId}")
    public PersonDTO getPerson(@PathVariable Long personId){
        return personService.getPersonById(personId);
    }

    @PutMapping("/persons/{personId}")
    public PersonDTO editPerson(@PathVariable Long personId,@Valid @RequestBody PersonDTO personDTO){
        return personService.editPerson(personId, personDTO);
    }
    @GetMapping("/identification/{personId}/sales")
    public List<InvoiceDTO> getSales(@PathVariable Long personId){
        return personService.getAllInvoicesForPerson(personId, "seller");
    }
    @GetMapping("/identification/{personId}/purchases")
    public List<InvoiceDTO> getPurchases(@PathVariable Long personId){
        return personService.getAllInvoicesForPerson(personId, "buyer");
    }
    @GetMapping("/{identificationNumber}/change-history")
    public List<HistoryTrackerDTO> getHistory(@PathVariable String identificationNumber){
        return historyTrackerService.getAllForPerson(identificationNumber);
    }

}

