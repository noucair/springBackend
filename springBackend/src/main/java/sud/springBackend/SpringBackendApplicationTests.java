package sud.springBackend;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import sud.springBackend.dao.CategoryRepository;
import sud.springBackend.dao.ProductRepository;
import sud.springBackend.model.Category;
import sud.springBackend.model.Product;

import java.util.Random;

@SpringBootApplication
class SpringBackendApplicationTests implements CommandLineRunner {
	@Autowired
	ProductRepository productRepository ;
	@Autowired
	CategoryRepository categoryRepository ;
	@Autowired
	public RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main (String[] args) {
		SpringApplication.run(SpringBackendApplicationTests.class, args);
	}




	@Override
	public void run(String... args) throws Exception {

		repositoryRestConfiguration.exposeIdsFor(Product.class , Category.class);
		categoryRepository.save(new Category(null,"Computers",null,null));
		categoryRepository.save(new Category(null,"Printers",null,null));
		categoryRepository.save(new Category(null,"Smartphones",null,null));

		/*for (int i = 0; i < 3; i++){
			Category c = new Category();
			c.setId(null);
			c.setName(names.get(i));
			c.setDescription(null);
			c.setProducts(null);
			categoryRepository.save(c);

		}
		//ici j'appelle n'importe quel méthode sans se soucier de creer les clases, les extends...
		//productRepository.findAll();
		repositoryRestConfiguration.exposeIdsFor(Product.class, Category.class);*/

		Random rnd=new Random();

		categoryRepository.findAll().forEach(category -> {
			for(int i=0;i<10;i++){
				Product p=new Product();
				p.setName(RandomString.make(10));
				p.setCurrentPrice(100+rnd.nextInt(10000));
				p.setAvailable(rnd.nextBoolean());
				p.setPromotion(rnd.nextBoolean());
				p.setSelected(rnd.nextBoolean());
				p.setCategory(category);
				p.setPhotoName("unknown.png");
				productRepository.save(p);
			}
		});


	}

}
