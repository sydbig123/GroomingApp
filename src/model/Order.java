package model;

import java.time.LocalDate;

public class Order {
    private Dog dog;
    private int orderNumber;
    //private LocalDate date;
    private int orderPriority;
    private int aggression;

    public Order(Dog dog) {
        this.dog = dog;
//        this.orderNumber = orderNumber;
//        this.orderDate = orderDate;
//        this.orderPriority = orderPriority;
//        this.sizeNum = dog.getSizeNum();
        this.setOrderPriority();
        this.setAggression();
    }

    public Dog getDog() {
        return dog;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

//    public LocalDate getOrderDate() {
//        return orderDate;
//    }

    public int getOrderPriority() {
        return orderPriority;
    }
    public void setOrderPriority() {
        if (dog.getSize().equals(Dog.Size.Small)) {
            orderPriority = 1;
        }
        if (dog.getSize().equals(Dog.Size.Medium)) {
            orderPriority = 2;
        }
        if (dog.getSize().equals(Dog.Size.Large)) {
            orderPriority = 3;
        }
    }
    public void setOrderPriority(int priority) {
        this.orderPriority = priority;
    }
    public int getAggression() {return aggression;}
    public void setAggression() {
        if (dog.getAggressive().equals(Dog.Aggression.No)) {
            aggression = 1;
        }
        if (dog.getAggressive().equals(Dog.Aggression.Unknown)) {
            aggression = 2;
        }
        if (dog.getAggressive().equals(Dog.Aggression.Yes)) {
            aggression = 3;
        }
    }

    public boolean decideToInsert(Order order){
        boolean decision = false;
        if (this.orderPriority > order.orderPriority) {
            decision = true;
        }
        if (this.orderPriority == order.orderPriority) {
            if (this.aggression > order.aggression) {
                decision = true;
            }
        }
        return decision;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Dog=" + dog.getName() + " " + dog.getLastName() +
//                "orderItem=" + orderItem +
//                ", orderNumber=" + orderNumber +
//                ", orderDate=" + orderDate +
                ", orderPriority=" + orderPriority +
                ", aggression=" + dog.getAggressive() +
                ", size=" + dog.getSize() +
                '}';
    }
}

