package sut.sa.g13.controller;

import org.springframework.web.bind.annotation.*;
import sut.sa.g13.entity.Customer;
import sut.sa.g13.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
class CustomerController {
    @Autowired private final CustomerRepository customerRepository;

    CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/Customers")
    public Collection<Customer> customers() {
        return customerRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/Customer/user/{username}")
    public Optional<Customer> Customers (@PathVariable String username) {
        Customer findCus = customerRepository.findByUsername(username);
        Optional<Customer> C = customerRepository.findById(findCus.getId());
        return C;
    }

    @PostMapping("/Customer/add/{username}/{customerName}/{tel}/{email}")
    public Customer newCustomer(@PathVariable String username ,@PathVariable String customerName, @PathVariable String tel, @PathVariable String email){
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setCustomerName(customerName);
        customer.setTel(tel);
        customer.setEmail(email);
        return customerRepository.save(customer);
    }
}
