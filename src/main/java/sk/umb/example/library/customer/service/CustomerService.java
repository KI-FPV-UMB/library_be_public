package sk.umb.example.library.customer.service;

import jakarta.transaction.Transactional;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import sk.umb.example.library.address.persistence.entity.AddressEntity;
import sk.umb.example.library.address.service.AddressDetailDto;
import sk.umb.example.library.customer.persistence.entity.CustomerEntity;

import java.util.*;

@Service
public class CustomerService {
//    private final CustomerRepository customerRepository;
//    private final AddressRepository addressRepository;

    private final CustomerServiceClient customerServiceClient;

    public CustomerService(CustomerServiceClient customerServiceClient) {
        this.customerServiceClient = customerServiceClient;
    }

//    public CustomerService(CustomerRepository customerRepository,
//                           AddressRepository addressRepository) {
//        this.customerRepository = customerRepository;
//        this.addressRepository = addressRepository;
//    }

    public String sayHelloProxyCall() {
        return customerServiceClient.sayHello();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    public List<CustomerDetailDto> getAllCustomers() {
//        return mapToDtoList(customerRepository.findAll());
        return Collections.EMPTY_LIST;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    public List<CustomerDetailDto> searchCustomerByLastName(String lastName) {
//        return mapToDtoList(customerRepository.findByLastName(lastName));
        return Collections.EMPTY_LIST;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    public CustomerDetailDto getCustomerById(Long customerId) {
        return mapToDto(getCustomerEntityById(customerId));
    }

    @Transactional
    @PreAuthorize("hasRole('ROLE_USER')")
    public Long createCustomer(CustomerRequestDto customerRequestDto) {
        CustomerEntity entity = mapToEntity(customerRequestDto);
//        return customerRepository.save(entity).getId();
        return 1L;
    }

    @Transactional
    @PreAuthorize("hasRole('ROLE_USER')")
    public void updateCustomer(Long customerId, CustomerRequestDto customerRequestDTO) {
        CustomerEntity customer = getCustomerEntityById(customerId);

        if (! Strings.isEmpty(customerRequestDTO.getFirstName())) {
            customer.setFirstName(customerRequestDTO.getFirstName());
        }

        if (! Strings.isEmpty(customerRequestDTO.getLastName())) {
            customer.setLastName(customerRequestDTO.getLastName());
        }

        if (! Strings.isEmpty(customerRequestDTO.getEmailContact())) {
            customer.setEmailContact(customerRequestDTO.getEmailContact());
        }

//        customerRepository.save(customer);
    }

    @Transactional
    @PreAuthorize("hasRole('ROLE_USER')")
    public void deleteCustomer(Long customerId) {
//        customerRepository.deleteById(customerId);
    }

    private CustomerEntity getCustomerEntityById(Long customerId) {
//        Optional<CustomerEntity> customer = customerRepository.findById(customerId);
//
//        if (customer.isEmpty()) {
//            throw new LibraryApplicationException("Customer not found. ID: " + customerId);
//        }
//
//        return customer.get();
        return null;
    }

    private CustomerEntity mapToEntity(CustomerRequestDto dto) {
        CustomerEntity customer = new CustomerEntity();

//        Optional<AddressEntity> address = addressRepository.findById(dto.getAddressId());

//        if (address.isPresent()) {
//            customer.setAddress(address.get());
//        } else {
//            throw new LibraryApplicationException("AddressId is invalid.");
//        }

        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmailContact(dto.getEmailContact());

        return customer;
    }

    private List<CustomerDetailDto> mapToDtoList(Iterable<CustomerEntity> customerEntities) {
        List<CustomerDetailDto> customers = new ArrayList<>();

        customerEntities.forEach(customerEntity -> {
                    CustomerDetailDto dto = mapToDto(customerEntity);
                    customers.add(dto);
                });

        return customers;
    }

    private CustomerDetailDto mapToDto(CustomerEntity customerEntity) {
        CustomerDetailDto dto = new CustomerDetailDto();
        dto.setId(customerEntity.getId());
        dto.setAddress(mapToDto(customerEntity.getAddress()));
        dto.setFirstName(customerEntity.getFirstName());
        dto.setLastName(customerEntity.getLastName());
        dto.setEmailContact(customerEntity.getEmailContact());

        return dto;
    }

    private AddressDetailDto mapToDto(AddressEntity addressEntity) {
        AddressDetailDto dto = new AddressDetailDto();
        dto.setId(addressEntity.getId());
        dto.setCity(addressEntity.getCity());

        return dto;
    }
}
