package mypackage.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mypackage.com.model.Invoice;
import mypackage.com.service.InvoiceService;

@RestController
@RequestMapping("/api/invoices")
@CrossOrigin(origins = "http://localhost:3000")
public class InvoiceController {

	@Autowired
    private InvoiceService invoiceService;
	
	  // Create a new invoice
    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice){
    	 Invoice created=invoiceService.createInvoice(invoice);
		return ResponseEntity.ok(created);
    	
    }
    
    // Get all invoices
    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices(){
		return ResponseEntity.ok(invoiceService.getAllInvoices());
    	
    }
    
   // Get single invoice by ID
    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable("id") Long id){
		return invoiceService.getInvoiceById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
    	
    }
    

    // Update invoice
    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable("id") Long id, @RequestBody Invoice invoice) {
        Invoice updated = invoiceService.updateInvoice(id, invoice);
        
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Delete invoice
//    @DeleteMapping("invoices/{id}")
//    public ResponseEntity<String> deleteInvoice(@PathVariable Long id) {
//    boolean deleted = invoiceService.deletInvoice(id);
//    if (deleted) {
//        return ResponseEntity.ok("Invoice deleted successfully.");
//    } else {
//        return ResponseEntity.notFound().build();
//    }
//    
//   }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInvoice(@PathVariable("id") Long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.ok().build();
    }
}


















