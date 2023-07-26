package sk.umb.example.library.customer.service;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceClientImpl implements CustomerServiceClient {
    public String sayHello() {
        return "IMPL";
    }
}
