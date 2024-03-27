package model;

import java.time.LocalDate;
import java.time.Month;

public class Payment {

    //private Person client;      //person who is charged
    private String fname;   //first name of person who is charged
    private String lname;   //last name of person who is charged
    private Double amount;
    private String payment_type;
    private Double tip;
    private LocalDate date;


    public Payment(String fname, String lname, Double amount, String payment_type, Double tip, LocalDate date) {
        this.fname = fname;
        this.lname = lname;
        this.amount = amount;
        this.payment_type = payment_type;
        this.tip = tip;
        this.date = date;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public Double getTip() {
        return tip;
    }

    public void setTip(Double tip) {
        this.tip = tip;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "client=" + fname + " " + lname +
                ", amount=" + amount +
                ", payment_type='" + payment_type + '\'' +
                ", tip=" + tip +
                ", date=" + date +
                '}';
    }
}

