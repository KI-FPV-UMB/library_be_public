package sk.umb.example.library.customer.controller;

import jakarta.validation.Valid;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.*;
import sk.umb.example.library.customer.service.CustomerRequestDto;
import sk.umb.example.library.customer.service.CustomerDetailDto;
import sk.umb.example.library.customer.service.CustomerService;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/api/customers/hello")
    public String sayHello() {
        return customerService.sayHelloProxyCall();
    }

//    @GetMapping("/api/customers")
//    public List<CustomerDetailDto> searchCustomer(@RequestParam(required = false) String lastName) {
//        System.out.println("Search customer called twice.");
//
//        return Strings.isEmpty(lastName) ? customerService.getAllCustomers()
//                                         : customerService.searchCustomerByLastName(lastName);
//    }
//
//    @GetMapping("/api/customers/{customerId}")
//    public CustomerDetailDto getCustomer(@PathVariable Long customerId) {
//        System.out.println("Get customer called.");
//        return customerService.getCustomerById(customerId);
//    }
//
//    @PostMapping("/api/customers")
//    public Long createCustomer(@Valid @RequestBody CustomerRequestDto customerRequestDTO) {
//        System.out.println("Create customer called:");
//        return customerService.createCustomer(customerRequestDTO);
//    }
//
//    @PutMapping("/api/customers/{customerId}")
//    public void updateCustomer(@PathVariable Long customerId, @Valid  @RequestBody CustomerRequestDto customerRequestDTO) {
//        System.out.println("Update customer called: ID = " + customerId);
//        customerService.updateCustomer(customerId, customerRequestDTO);
//    }
//
//    @DeleteMapping("/api/customers/{customerId}")
//    public void deleteCustomer(@PathVariable Long customerId) {
//        System.out.println("Delete customer called: ID = " + customerId);
//        customerService.deleteCustomer(customerId);
//    }
}
