package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.entity.filter.InvoiceFilter;
import java.util.List;

public interface InvoiceService {
    /**
     * Method creates and saves new InvoiceEntity into database
     * @param invoiceDTO with data from client
     * @return invoiceDTO from the new entity in database (hence including the ID)
     */
    InvoiceDTO addInvoice(InvoiceDTO invoiceDTO);

    /**
     * Method removes invoice based on its id
     * @param id Invoice to delete
     */
    void removeInvoice(Long id);

    /**
     * Method fetches all invoices with no other criteria
     * @return List of all Invoices
     */
    List<InvoiceDTO> getAll(InvoiceFilter filter);

    /**
     * Method fetches invoice by its id
     * @param id
     * @return InvoiceDTO
     */
    InvoiceDTO getInvoiceById(Long id);

    /**
     * Method edits invoice identified by its id
     * @param invoiceDTO
     * @param id
     * @return updated InvoiceDTO
     */
    InvoiceDTO editInvoice(InvoiceDTO invoiceDTO, Long id);



}
