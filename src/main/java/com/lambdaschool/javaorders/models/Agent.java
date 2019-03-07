package com.lambdaschool.javaorders.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="agents")
public class Agent {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long agentcode;

    private String agentname;
    private String workingarea;
    private Double commission;
    private String phone;
    private String country;

    private @OneToMany(cascade = CascadeType.REMOVE, mappedBy="agent")
    Set<Customer> customers;

    private @OneToMany
    Set<Order> orders;

    public Agent() {
    }

    public Agent(String agentName, String workingArea, Double commission, String phone, String country, Set<Customer> customers) {
        this.agentname = agentName;
        this.workingarea = workingArea;
        this.commission = commission;
        this.phone = phone;
        this.country = country;
        this.customers = customers;
    }

    public Long getAgentCode() {
        return agentcode;
    }

    public String getAgentName() {
        return agentname;
    }

    public void setAgentName(String agentName) {
        this.agentname = agentName;
    }

    public String getWorkingArea() {
        return workingarea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingarea = workingArea;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
