package mypackage.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mypackage.com.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    // Custom methods if needed, like:
    // List<Invoice> findByStatus(String status);
    // Optional<Invoice> findByInvoiceNumber(String invoiceNumber);

}