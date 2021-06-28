package sud.springBackend.entities;

import org.springframework.data.rest.core.config.Projection;
import sud.springBackend.model.Product;

@Projection(name = "P1" , types = Product.class)
public interface ProductProjection {
    public double getCurrentPrice();
}
