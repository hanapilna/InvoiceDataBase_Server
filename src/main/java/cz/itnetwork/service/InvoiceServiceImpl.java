package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.mapper.InvoiceMapper;
import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.PersonEntity;
import cz.itnetwork.entity.filter.InvoiceFilter;
import cz.itnetwork.entity.repository.InvoiceRepository;
import cz.itnetwork.entity.repository.PersonRepository;
import cz.itnetwork.entity.repository.specification.InvoiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private InvoiceMapper invoiceMapper;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;

    @Override
    public InvoiceDTO addInvoice(InvoiceDTO invoiceDTO) {
        if((invoiceDTO.getBuyer().equals(invoiceDTO.getSeller())) || (invoiceDTO.getDueDate().isBefore(invoiceDTO.getIssued()))){
            throw new RuntimeException();
        }
        InvoiceEntity newInvoice = invoiceMapper.toEntity(invoiceDTO);
        newInvoice = invoiceRepository.save(newInvoice);
        InvoiceDTO newInvoiceDTO = invoiceMapper.toTDO(newInvoice);
        newInvoiceDTO.setBuyer(personService.getPersonById(newInvoice.getBuyer().getId()));
        newInvoiceDTO.setSeller(personService.getPersonById(newInvoice.getSeller().getId()));
        return newInvoiceDTO;
    }

    @Override
    public void removeInvoice(Long id) {
        InvoiceEntity fetchedInvoice = fetchInvoiceById(id);
        invoiceRepository.delete(fetchedInvoice);
    }

    @Override
    public List<InvoiceDTO> getAll(InvoiceFilter filter) {
        InvoiceSpecification specification = new InvoiceSpecification(filter);

        return invoiceRepository.findAll(specification, PageRequest.of(0, filter.getLimit()))
                .stream()
                .map(i -> invoiceMapper.toTDO(i))
                .toList();
    }

    @Override
    public InvoiceDTO getInvoiceById(Long id) {
        InvoiceEntity fetchedInvoice = fetchInvoiceById(id);
        return invoiceMapper.toTDO(fetchedInvoice);
    }

    @Override
    public InvoiceDTO editInvoice(InvoiceDTO invoiceDTO, Long id){
        if((invoiceDTO.getBuyer().equals(invoiceDTO.getSeller())) || (invoiceDTO.getDueDate().isBefore(invoiceDTO.getIssued()))){
            throw new RuntimeException();
        }
        InvoiceEntity entityToBeUpdated = invoiceRepository.getReferenceById(id);
        invoiceDTO.setId(id);
        InvoiceEntity updatedEntity = invoiceMapper.updateEntity(invoiceDTO, entityToBeUpdated);

        PersonEntity buyer = personRepository.getReferenceById(invoiceDTO.getBuyer().getId());
        updatedEntity.setBuyer(buyer);
        PersonEntity seller = personRepository.getReferenceById(invoiceDTO.getSeller().getId());
        updatedEntity.setSeller(seller);

        InvoiceEntity savedEntity = invoiceRepository.save(updatedEntity);
        return invoiceMapper.toTDO(savedEntity);
    }

    //private method

    /**
     * <p>Attempts to fetch an invoice.</p>
     * <p>In case an invoice with the passed [id] doesn't exist a [{@link org.webjars.NotFoundException}] is thrown.</p>
     *
     * @param id Invoice to fetch
     * @return Fetched entity
     * @throws org.webjars.NotFoundException In case an invoice with the passed [id] isn't found
     */
    private InvoiceEntity fetchInvoiceById(Long id){
        return invoiceRepository.findById(id).orElseThrow(()-> new NotFoundException("Invoice with ID " + id + " was not found in the database"));
    }

}
