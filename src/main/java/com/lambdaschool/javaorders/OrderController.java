package com.lambdaschool.javaorders;

import com.lambdaschool.javaorders.models.Agent;
import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.models.Order;
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



//
//    GET /agents/agentcode/{agentcode}
//
//    POST /customers - adds a customer
//
//    POST /orders - adds an order
//
//    POST /agents - adds an agent
//
//    PUT /customers/custocode/{custcode} - updates a customer based on custcode
//
//    PUT /orders/ordnum/{ordnum} - updates an order based on ordnum
//
//    PUT /agents/agentcode/{agentcode} - updates an agent based on ordnum
//
//    DELETE /customers/custcode/{custcode} - Deletes a customer based off of their custcode and deletes all their associated orders
//
//
//    DELETE agents/agentcode/{agentcode} - Deletes an agent if they are not assigned to a customer or order (Stretch Goal)

    //    GET /customers - returns all the customer
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @GetMapping("/customer/order")
    public List<Object[]> getAllCustomersWithOrders() {
        return customerRepo.ordersAndCustomers();
    }

    @GetMapping("/customer/name/{custname}")
    public List<Object[]> customerByName(@PathVariable String custName) {
        return customerRepo.ordersAndCustomersByName(custName);
    }

    @GetMapping("/customer/order/{custcode}")
    public List<Object[]> customerByCode(@PathVariable Long custCode) {
        return customerRepo.ordersAndCustomersByCode(custCode);
    }

    //    GET /customers/custcode/{custcode}
    @GetMapping("/customers/custcode/{custcode}")
    public Customer getCustomer(@PathVariable long custcode){
        return customerRepo.findById(custcode).orElseThrow();
    }

    //    GET /agents - return all the agents
    @GetMapping("/agents")
    public List<Agent> getAllAgents(){
        return agentRepo.findAll();
    }

    @GetMapping("/agents/orders")
    public List<Object> agentsWithOrders() {
        return agentRepo.agentsAndOrders();
    }

//    GET /orders - return all the orders
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }

    //    GET /orders/ordnum/{ordnum}
    @GetMapping("/orders/ordnum/{ordnum}")
    public Order getOrderByOrdnum(@PathVariable long ordnum) {
        return orderRepo.findById(ordnum).orElseThrow();
    }



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

    @DeleteMapping("/agent/{agentCode")
    public Agent deleteAgentByCode(@PathVariable Long agentCode) {
        final Agent agent = agentRepo.findAgentByAgentcode(agentCode);
        if(agent != null) {
            agentRepo.delete(agent);
            return agent;
        } else {
            return null;
        }
    }
    //    DELETE /orders/ordnum/{ordnum} - deletes an order based off its ordnum

    @DeleteMapping("/orders/ordnum/{ordnum}")
    public Order deleteOrder(@PathVariable long ordnum){
        var foundOrder = orderRepo.findById(ordnum);
        if(foundOrder.isPresent()){
            orderRepo.deleteById(ordnum);
            return foundOrder.get();
        }
        return null;
    }
}
