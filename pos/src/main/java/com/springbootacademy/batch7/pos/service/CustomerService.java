package com.springbootacademy.batch7.pos.service;

import com.springbootacademy.batch7.pos.dto.CustomerDTO;
import com.springbootacademy.batch7.pos.dto.request.CustomerUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);


    CustomerDTO getCustomerById(int customerid);

    List<CustomerDTO> getAllCustomer();

    String deleteCustomer(int customerid);

    List<CustomerDTO> getAllCustomerByActiveState(boolean activeState);
}
