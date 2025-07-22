package customers;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductDAO implements IProductDAO{
    private ILogger logger;
    @Autowired
    public ProductDAO(ILogger logger){
        this.logger = logger;
    }

    @Override
    public void save(Product product) {
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ProductDAO: saving product "+product.getProduct());
        logger.log("Product is saved in the DB: "+ product.getProduct() );
    }
}
