package sk.umb.example.library.customer.controller;

import sk.umb.example.library.customer.service.CustomerServiceClient;

public class CustomerServiceClientTestImpl implements CustomerServiceClient {
    @Override
    public String sayHello() {
        return "TEST-IMPL";
    }
}
