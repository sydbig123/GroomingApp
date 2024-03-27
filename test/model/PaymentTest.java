package model;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    Payment pay = new Payment("Sydney", "Biggar", 75.00, "Credit", 10.00, LocalDate.of(2023, 9, 17));

    @Test
    @Order(1)
    void getName() {
        assertEquals("Sydney Biggar", String.format("%s %s", pay.getFname(), pay.getLname()));
    }

    @Test
    @Order(6)
    void setName() {
        pay.setFname("Adina");
        pay.setLname("Brenner");
        assertEquals("Adina Brenner", String.format("%s %s", pay.getFname(), pay.getLname()));
    }

    @Test
    @Order(2)
    void getAmount() {
        assertEquals(75.00, pay.getAmount());
    }

    @Test
    @Order(7)
    void setAmount() {
        pay.setAmount(100.00);
        assertEquals(100.00, pay.getAmount());
    }

    @Test
    @Order(3)
    void getPayment_type() {
        assertEquals("Credit", pay.getPayment_type());
    }

    @Test
    @Order(8)
    void setPayment_type() {
        pay.setPayment_type("cash");
        assertEquals("cash", pay.getPayment_type());
    }

    @Test
    @Order(4)
    void getTip() {
        assertEquals(10.00, pay.getTip());
    }

    @Test
    @Order(9)
    void setTip() {
        pay.setTip(20.00);
        assertEquals(20.00, pay.getTip());
    }

    @Test
    @Order(5)
    void getDate() {
        assertEquals(LocalDate.of(2023, 9, 17), pay.getDate());
    }

    @Test
    @Order(10)
    void setDate() {
        pay.setDate(LocalDate.of(2023, 9, 16));
        assertEquals(LocalDate.of(2023, 9, 16), pay.getDate());
    }

    @Test
    void testToString() {
        String expected = "Payment{client=Sydney Biggar, amount=75.0, payment_type='Credit', tip=10.0, date=2023-09-17}";
        assertEquals(expected, pay.toString());
    }
}

