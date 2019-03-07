package com.lambdaschool.javaorders;

import com.lambdaschool.javaorders.models.Agent;
import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.repositories.AgentRepository;
import com.lambdaschool.javaorders.repositories.CustomerRepository;
import com.lambdaschool.javaorders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ={}, produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    @Autowired
    AgentRepository agentRepo;

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    OrderRepository orderRepo;


    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }
//    /customer/order - Returns all customers with their orders
    @GetMapping("/customer/order")
    public List<Object[]> getAllCustomersWithOrders() {
        return customerRepo.ordersAndCustomers();
    }

///customer/name/{custname} - Returns all orders for a particular based on name
    @GetMapping("/customer/name/{custname}")
    public List<Object[]> customerByName(@PathVariable String custName) {
        return customerRepo.ordersAndCustomersByName(custName);
    }

///customer/order/{custcode} - Returns all orders for a particular customer based on custcode

    @GetMapping("/customer/order/{custcode}")
    public List<Object[]> customerByCode(@PathVariable Long custCode) {
        return customerRepo.ordersAndCustomersByCode(custCode);
    }

///agents - Returns all agents with their customers
    @GetMapping("/agents")
    public List<Object> agentsWithCustomers() {
        return agentRepo.agentsAndOrders();
    }
///agents/orders - Return a list with the agents name and associated order number and order description

    @GetMapping("/agents/orders")
    public List<Object> agentsWithOrders() {
        return agentRepo.agentsAndOrders();
    }
///customer/{custcode} - Deletes a customer based off of their custcode and deletes all their associated orders

    @DeleteMapping("customer/{custCode")
    public Customer deleteCustomerByCode(@PathVariable Long custCode) {
        final Customer customer = customerRepo.findByCustcode(custCode);
        if(customer != null) {
            customerRepo.delete(customer);
            return customer;
        } else {
            return null;
        }
    }

///agents/{agentcode} - Deletes an agent if they are not assigned to a customer or order (Stretch Goal)
    @DeleteMapping("/agent/{agentCode")
    public Agent deletAgentByCode(@PathVariable Long agentCode) {
        final Agent agent = agentRepo.findAgentByAgentcode(agentCode);
        if(agent != null) {
            agentRepo.delete(agent);
            return agent;
        } else {
            return null;
        }
    }
}
