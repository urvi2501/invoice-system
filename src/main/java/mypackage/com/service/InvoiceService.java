package mypackage.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.com.model.Invoice;
import mypackage.com.repository.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
    private InvoiceRepository invoiceRepository;
	
	
	 //CREATE Invoice
	public Invoice createInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
	
	
	// READ All Invoices
	public List<Invoice> getAllInvoices()
	{
		return invoiceRepository.findAll();
	}
	
	// UPDATE Invoice
	public Invoice updateInvoice(Long id,Invoice updatedInvoice) {
		return invoiceRepository.findById(id)
				.map(invoice -> {
                    invoice.setInvoiceNumber(updatedInvoice.getInvoiceNumber());
                    invoice.setCustomerName(updatedInvoice.getCustomerName());
                    invoice.setInvoiceDate(updatedInvoice.getInvoiceDate());
                    invoice.setAmount(updatedInvoice.getAmount());
                    invoice.setStatus(updatedInvoice.getStatus());
                    invoice.setDescription(updatedInvoice.getDescription());
                    return invoiceRepository.save(invoice);
                })
                .orElse(null);
	}
	
	//DELETE Invoice
	public Boolean deleteInvoice(Long id) {
		 if (invoiceRepository.existsById(id)) {
	            invoiceRepository.deleteById(id);
		return true;
		 } else {
	            return false;
	        }
	}

	 //READ Invoice by ID
    public Optional<Invoice> getInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }
	
}




















