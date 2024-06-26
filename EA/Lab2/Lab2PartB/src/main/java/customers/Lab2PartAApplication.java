package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import products.Product;
import products.ProductService;

@ComponentScan(basePackages = {"products", "customers"} )
@SpringBootApplication
public class Lab2PartAApplication implements CommandLineRunner {

	@Autowired
	CustomerService customerService;
	@Autowired
	ProductService productService;
	public static void main(String[] args) {

		SpringApplication.run(Lab2PartAApplication.class, args);
	}
	@Override
	public void run(String ...args)throws Exception{
		customerService.addCustomer("Frank Brown", "fbrown@acme.com",
			"mainstreet 5", "Chicago", "60613");
		productService.addProduct(new Product(1, "IPhone 14"));
	}

}
