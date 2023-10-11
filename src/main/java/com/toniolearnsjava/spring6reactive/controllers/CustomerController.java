package com.toniolearnsjava.spring6reactive.controllers;

import com.toniolearnsjava.spring6reactive.model.CustomerDTO;
import com.toniolearnsjava.spring6reactive.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    public static final String GET_CUSTOMER = "/api/v2/customer";
    public static final String GET_CUSTOMER_ID = GET_CUSTOMER + "/{customerId}";

    private final CustomerService customerService;


    @GetMapping(GET_CUSTOMER)
    Flux<CustomerDTO> listCustomers(){
        return customerService.listCustomers();
    }
}
