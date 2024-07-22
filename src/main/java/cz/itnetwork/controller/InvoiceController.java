package cz.itnetwork.controller;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.entity.filter.InvoiceFilter;
import cz.itnetwork.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/invoices")
    public InvoiceDTO addInvoice(@Valid @RequestBody InvoiceDTO invoiceDTO){
        return invoiceService.addInvoice(invoiceDTO);
    }

    @GetMapping("/invoices")
    public List<InvoiceDTO> getInvoices(InvoiceFilter filter){
        return invoiceService.getAll(filter);
    }

    @GetMapping("/invoices/{id}")
    public InvoiceDTO getInvoice(@PathVariable Long id){
        return invoiceService.getInvoiceById(id);
    }

    @DeleteMapping("/invoices/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable Long id){
        invoiceService.removeInvoice(id);
    }

    @PutMapping("/invoices/{id}")
    public InvoiceDTO editInvoice(@PathVariable Long id,@Valid @RequestBody InvoiceDTO invoiceDTO){
        return invoiceService.editInvoice(invoiceDTO, id);
    }

}
