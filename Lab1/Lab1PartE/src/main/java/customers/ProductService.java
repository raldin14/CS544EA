package customers;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductService implements IProductService{
    @Autowired
    IProductDAO productDAO;
    @Autowired
    IEmailSender emailSender;

    @Override
    public void addProduct(String product, String email) {
        Product newProduct = new Product(product);
        productDAO.save(newProduct);
        emailSender.sendEmail(email, "The product " + product + " has been added");
    }
}
