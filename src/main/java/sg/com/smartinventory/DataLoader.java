package sg.com.smartinventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import sg.com.smartinventory.entity.Customer;
import sg.com.smartinventory.entity.Product;
import sg.com.smartinventory.entity.Review;
import sg.com.smartinventory.repository.CustomerRepository;
import sg.com.smartinventory.repository.ProductRepository;
import sg.com.smartinventory.repository.ReviewRepository;

@Component
public class DataLoader {
  //Inject all repositories
  private CustomerRepository customerRepository;
  private ProductRepository productRepository;
  private ReviewRepository reviewRepository;

  @Autowired
  public DataLoader(CustomerRepository customerRepository, ProductRepository productRepository, ReviewRepository reviewRepository){
    this.customerRepository = customerRepository;
    this.productRepository = productRepository;
    this.reviewRepository = reviewRepository;
  }

  @PostConstruct
  public void loadData(){
    //Clear all data
    customerRepository.deleteAll();
    productRepository.deleteAll();
    reviewRepository.deleteAll();

    //Create fake data
    customerRepository.save(new Customer("John", "Doe", "USA", "123 Main St", 12345, 1234567890, "john.doe@example.com", 101));
    customerRepository.save(new Customer("Alice", "Smith", "Canada", "456 Maple Ave", 54321, 987654321, "alice.smith@example.com", 102));
    customerRepository.save(new Customer("Michael", "Johnson", "UK", "789 Oak Rd", 67890, 987612345, "michael.johnson@example.com", 103));
    customerRepository.save(new Customer("Emily", "Brown", "Australia", "321 Elm St", 13579, 456789123, "emily.brown@example.com", 104));
    customerRepository.save(new Customer("David", "Wilson", "Germany", "654 Pine Rd", 98765, 369852147, "david.wilson@example.com", 105));

    productRepository.save(new Product("Electronics", "Smartphone", "High-end smartphone with advanced features", 999.99, 100, "101"));
    productRepository.save(new Product("Clothing", "Men's T-Shirt", "Comfortable cotton t-shirt for everyday wear", 29.99, 500, "102"));
    productRepository.save(new Product("Home & Kitchen", "Coffee Maker", "Automatic coffee maker with programmable settings", 49.99, 50, "103"));
    productRepository.save(new Product("Beauty", "Perfume", "Elegant fragrance with floral and citrus notes", 79.99, 200, "104"));
    productRepository.save(new Product("Books", "Science Fiction Novel", "Bestselling sci-fi novel set in a dystopian future", 14.99, 300, "105"));

    reviewRepository.save(new Review("Electronics", "Great smartphone with excellent features.", 5, 101, 201));
    reviewRepository.save(new Review("Clothing", "Very comfortable t-shirt, fits perfectly.", 4, 102, 202));
    reviewRepository.save(new Review("Home & Kitchen", "Makes delicious coffee, easy to use.", 4, 103, 203));
    reviewRepository.save(new Review("Beauty", "Lovely fragrance, long-lasting.", 5, 104, 204));
    reviewRepository.save(new Review("Books", "Intriguing plot, couldn't put it down.", 5, 105, 205));

  }

}
