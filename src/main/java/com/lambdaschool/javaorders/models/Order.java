package com.lambdaschool.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long ordnum;

    private double ordamount;
    private double advanceamount;
    private String orddate;

    private @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    Agent agent;

    private @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    Customer customer;

    private String orddescription;

    public Order() {
    }

    public Order(double ordAmount, double advanceAmount, String ordDate, Agent agent, Customer customer, String orderDescription) {
        this.ordamount = ordAmount;
        this.advanceamount = advanceAmount;
        this.orddate = ordDate;
        this.agent = agent;
        this.customer = customer;
        this.orddescription = orderDescription;
    }

    public Long getOrdNum() {
        return ordnum;
    }

    public double getOrdAmount() {
        return ordamount;
    }

    public void setOrdAmount(double ordAmount) {
        this.ordamount = ordAmount;
    }

    public double getAdvanceAmount() {
        return advanceamount;
    }

    public void setAdvanceAmount(double advanceAmount) {
        this.advanceamount = advanceAmount;
    }

    public String getOrdDate() {
        return orddate;
    }

    public void setOrdDate(String ordDate) {
        this.orddate = ordDate;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderDescription() {
        return orddescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orddescription = orderDescription;
    }
}
