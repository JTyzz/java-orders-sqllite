package com.lambdaschool.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "customers")
public class Customer {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long custcode;

    private String custname;
    private String custcity;
    private String workingarea;
    private String custcountry;
    private String grade;
    private Double openingamt;
    private Double receiveamt;
    private Double paymentamt;
    private Double outstandingamt;
    private String phone;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    private Agent agent;

    private @OneToMany
    Set<Order> orders;

    public Customer() {
    }

    public Customer(String custname, String custcity, String workingArea, String custCountry, String grade, Double openingAmt, Double receiveAmt, Double paymentAmt, Double outstandingAmt, String phone, Agent agent) {
        this.custname = custname;
        this.custcity = custcity;
        this.workingarea = workingarea;
        this.custcountry = custcountry;
        this.grade = grade;
        this.openingamt = openingamt;
        this.receiveamt = receiveamt;
        this.paymentamt = paymentamt;
        this.outstandingamt = outstandingamt;
        this.phone = phone;
        this.agent = agent;
    }

    public Long getCustCode() {
        return custcode;
    }

    public String getCustName() {
        return custname;
    }

    public void setCustName(String custName) {
        this.custname = custName;
    }

    public String getCustCity() {
        return custcity;
    }

    public void setCustCity(String custCity) {
        this.custcity = custCity;
    }

    public String getWorkingArea() {
        return workingarea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingarea = workingArea;
    }

    public String getCustCountry() {
        return custcountry;
    }

    public void setCustCountry(String custCountry) {
        this.custcountry = custCountry;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Double getOpeningAmt() {
        return openingamt;
    }

    public void setOpeningAmt(Double openingAmt) {
        this.openingamt = openingAmt;
    }

    public Double getReceiveAmt() {
        return receiveamt;
    }

    public void setReceiveAmt(Double receiveAmt) {
        this.receiveamt = receiveAmt;
    }

    public Double getPaymentAmt() {
        return paymentamt;
    }

    public void setPaymentAmt(Double paymentAmt) {
        this.paymentamt = paymentAmt;
    }

    public Double getOutstandingAmt() {
        return outstandingamt;
    }

    public void setOutstandingAmt(Double outstandingAmt) {
        this.outstandingamt = outstandingAmt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
