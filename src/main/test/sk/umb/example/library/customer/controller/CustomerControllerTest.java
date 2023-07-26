package sk.umb.example.library.customer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import sk.umb.example.library.address.persistence.repository.AddressRepository;
import sk.umb.example.library.customer.persistence.repository.CustomerRepository;
import sk.umb.example.library.customer.service.CustomerDetailDto;
import sk.umb.example.library.customer.service.CustomerService;
import sk.umb.example.library.exception.LibraryApplicationException;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
@AutoConfigureMockMvc(addFilters = false)
@Import({CustomerService.class, CustomerServiceClientTestImpl.class})
class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerService customerService;


    @Test
    public void searchCustomerAll() throws Exception {
        mockMvc.perform(
                get("/api/customers/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",
                                    Matchers.equalTo("TEST-IMPL")));
    }
}