package peaksoft.service;

import peaksoft.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer saveCustomer(Customer customer);

    void update(long id, Customer customer);

    Customer getById(long id);

    String delete(long id);
}
