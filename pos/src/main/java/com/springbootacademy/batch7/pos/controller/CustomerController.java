package com.springbootacademy.batch7.pos.controller;

import com.springbootacademy.batch7.pos.dto.CustomerDTO;
import com.springbootacademy.batch7.pos.dto.request.CustomerUpdateDTO;
import com.springbootacademy.batch7.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return "saved";
    }
    @PutMapping("/update")
    public  String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String message = customerService.updateCustomer(customerUpdateDTO);
        return message;
    }
    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerid){
        System.out.println("Print value " +customerid);
        CustomerDTO customerDTO = customerService.getCustomerById(customerid);
        return customerDTO;
    }
    @GetMapping(
            path = {"/get-all-customer"}
    )
    public List<CustomerDTO> getAllCustomer(){
        List<CustomerDTO> allCustomer = customerService.getAllCustomer();
        return allCustomer;
    }
    @DeleteMapping(
            path = "delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable (value = "id")int customerid){
        String deleted = customerService.deleteCustomer(customerid);
        return  deleted;

    }
    @GetMapping(
            path = {"/get-all-customer-by-active-state/{status}"}
    )
    public List<CustomerDTO> getAllCustomerByActiveState(@PathVariable (value = "status")boolean activeState){
        List<CustomerDTO> allCustomer = customerService.getAllCustomerByActiveState(activeState);
        return allCustomer;
    }
}
