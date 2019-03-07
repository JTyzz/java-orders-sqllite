package com.lambdaschool.javaorders.repositories;

import com.lambdaschool.javaorders.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    @Query(value = "SELECT agents.agentcode as agentcode, agents.agentname, agents.workingarea as agentsworkingarea, agents.commission, agents.phone as agentsphone, agents.country, customers.id as customerid, customers.custcode, customers.custname, customers.custcity, customers.workingarea as customersworkingarea, customers.custcountry, customers.grade, customers.openingamt, customers.receiveamt, customers.paymentamt, customers.outstandingamt, customers.phone as customersphone, customers.agentid " +
            "FROM agents " +
            "JOIN customers WHERE agents.agentCode=Customers.agentCode", nativeQuery = true)
    List<Object> agentsAndCustomers();

    @Query(value = "SELECT agents.agentname, orders.ordnum, orders.orddescription " +
            "FROM agents " +
            "JOIN orders WHERE agents.agentCode=orders.agentCode", nativeQuery = true)
    List<Object> agentsAndOrders();

    Agent findAgentByAgentcode(Long agentcode);
}