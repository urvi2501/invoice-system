package mypackage.com.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String invoiceNumber;

	    private String customerName;

	    private LocalDate invoiceDate;
	    
	    private Double amount;

	    private String status; // e.g., "PAID", "PENDING", "CANCELLED"

	    private String description;
	    
	     private String email;
	   
	     private String mobileNumber;
	 
	     private LocalDate dueDate;

		@Override
		public String toString() {
			return "Invoice [id=" + id + ", invoiceNumber=" + invoiceNumber + ", customerName=" + customerName
					+ ", invoiceDate=" + invoiceDate + ", amount=" + amount + ", status=" + status + ", description="
					+ description + ", email=" + email + ", mobileNumber=" + mobileNumber + ", dueDate=" + dueDate
					+ "]";
		}

		public Invoice() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Invoice(Long id, String invoiceNumber, String customerName, LocalDate invoiceDate, Double amount,
				String status, String description, String email, String mobileNumber, LocalDate dueDate) {
			super();
			this.id = id;
			this.invoiceNumber = invoiceNumber;
			this.customerName = customerName;
			this.invoiceDate = invoiceDate;
			this.amount = amount;
			this.status = status;
			this.description = description;
			this.email = email;
			this.mobileNumber = mobileNumber;
			this.dueDate = dueDate;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getInvoiceNumber() {
			return invoiceNumber;
		}

		public void setInvoiceNumber(String invoiceNumber) {
			this.invoiceNumber = invoiceNumber;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public LocalDate getInvoiceDate() {
			return invoiceDate;
		}

		public void setInvoiceDate(LocalDate invoiceDate) {
			this.invoiceDate = invoiceDate;
		}

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public LocalDate getDueDate() {
			return dueDate;
		}

		public void setDueDate(LocalDate dueDate) {
			this.dueDate = dueDate;
		}
}
