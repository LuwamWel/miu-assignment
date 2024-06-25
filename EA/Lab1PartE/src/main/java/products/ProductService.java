package products;

import customers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    private IProductDAO productDAO;
    private IEmailSender emailSender;

    @Override
    public void addProduct(String name, String description, double price) {
        Product product = new Product(name, description, price);
        productDAO.save(product);

        emailSender.sendEmail("luwam@miu.com", "New Product "+ product.getName() +" saved!");
    }

    public void setProductDAO(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Autowired
    public ProductService(IProductDAO productDAO, IEmailSender emailSender) {
        this.productDAO = productDAO;
        this.emailSender = emailSender;
    }
}


