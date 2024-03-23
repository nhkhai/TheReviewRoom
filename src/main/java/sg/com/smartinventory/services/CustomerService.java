package sg.com.smartinventory.services;

import java.util.ArrayList;

import sg.com.smartinventory.entities.Customer;
// import sg.com.smartinventory.entities.Review;

public interface CustomerService {
    Customer createCustomer(Customer customer);

    Customer getCustomer(long id);

    ArrayList<Customer> getAllCustomers();

    Customer updateCustomer(long id, Customer customer);

    void deleteCustomer(long id);

    // Review addReviewToCustomer(long customerId, long productId, Review review);
}