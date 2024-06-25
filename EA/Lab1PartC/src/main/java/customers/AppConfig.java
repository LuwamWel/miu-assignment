package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public IEmailSender emailSender() {
        return new EmailSender();
    }

    @Bean
    public ILogger Logger(){
        return new Logger();
    }

    @Bean
    public ICustomerDAO customerDAO(ILogger logger){
        return new CustomerDAO(logger);
    }
    @Bean
    public ICustomerService customerService(ICustomerDAO customerDAO, IEmailSender emailSender){
        return new CustomerService(customerDAO, emailSender);
    }
}
