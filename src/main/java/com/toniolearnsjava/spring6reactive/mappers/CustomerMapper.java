package com.toniolearnsjava.spring6reactive.mappers;

import com.toniolearnsjava.spring6reactive.domain.Customer;
import com.toniolearnsjava.spring6reactive.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDTO dto);
    CustomerDTO customerToCustomerDto(Customer customer);
}
