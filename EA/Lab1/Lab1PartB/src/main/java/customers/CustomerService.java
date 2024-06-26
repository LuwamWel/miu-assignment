package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
	ICustomerDAO customerDAO;
	IEmailSender emailSender ;

	public void addCustomer(String name, String email, String street,
			String city, String zip) {
		Customer customer = new Customer(name, email);
		Address address = new Address(street, city, zip);
		customer.setAddress(address);
		customerDAO.save(customer);
		emailSender.sendEmail(email, "Welcome " + name + " as a new customer");
	}
	public void setCustomerDAO(ICustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Autowired
	public CustomerService(ICustomerDAO customerDAO, IEmailSender emailSender) {
		this.customerDAO = customerDAO;
		this.emailSender = emailSender;
	}
}
