package peaksoft.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import peaksoft.model.Customer;
import peaksoft.service.CustomerService;

import java.util.List;
@Service
@Transactional

public class CustomerServiceImpl implements CustomerService {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Customer> getAllCustomers() {
        return entityManager.createQuery("select c from Customer c",Customer.class)
                .getResultList();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Customer customer1=entityManager.persist(customer);
        return customer1;
    }

    @Override
    public void update(long id, Customer customer) {

    }

    @Override
    public Customer getById(long id) {
        return null;
    }

    @Override
    public String delete(long id) {
        return null;
    }
}
