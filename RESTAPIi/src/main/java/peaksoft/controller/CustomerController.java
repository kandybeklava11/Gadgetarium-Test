package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Customer;
import peaksoft.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor

public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @PostMapping("/create")
    public Customer save(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }
    @DeleteMapping("/{id}")
    public String  delete(@PathVariable long id){
        return customerService.delete(id);
    }
    @PutMapping("/update/{id}")
    public void update (@PathVariable long id ,@RequestBody Customer customer){
        customerService.update(id,customer);
    }
    @GetMapping("/{id}")
    public Customer getById(@PathVariable long id){
        return customerService.getById(id);
    }
}
