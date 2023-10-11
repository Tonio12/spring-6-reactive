package com.toniolearnsjava.spring6reactive.services;

import com.toniolearnsjava.spring6reactive.mappers.CustomerMapper;
import com.toniolearnsjava.spring6reactive.model.CustomerDTO;
import com.toniolearnsjava.spring6reactive.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public Flux<CustomerDTO> listCustomers() {
        return customerRepository.findAll()
                .map(customerMapper::customerToCustomerDto);
    }
}
