package com.toniolearnsjava.spring6reactive.services;


import com.toniolearnsjava.spring6reactive.model.CustomerDTO;
import reactor.core.publisher.Flux;

public interface CustomerService {
    Flux<CustomerDTO> listCustomers();
}
