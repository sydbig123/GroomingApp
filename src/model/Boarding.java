package model;

import java.time.LocalDate;

public class Boarding extends Appointment implements Printable{

    private LocalDate pickup;    //pick up date

    public Boarding(Dog dog, LocalDate dropoff, LocalDate pickup) {
        super(dog, dropoff);
        this.pickup = pickup;
    }

    public LocalDate getPickupDate() {
        return pickup;
    }

    public void setPickupDate(LocalDate pickup) {
        this.pickup = pickup;
    }

    @Override
    public String getAppointment_details() {
        return "Boarding{" + super.getAppointment_details() +
                '}';
    }

    @Override
    public String toString() {
        return "Boarding{" +
                "pickup=" + pickup +
                ", dog=" + dog +
                ", dropoff=" + dropoff +
                ", appointment_details='" + appointment_details + '\'' +
                '}';
    }

    @Override
    public void BasicDetails() {
        System.out.println("Boarding{" +
                "dog=" + dog.getName() + " " + dog.getLastName() +
                ", dropoff=" + dropoff +
                ", pickup=" + pickup +
                '}');
    }

    @Override
    public void AllDetails() {
        System.out.println(this.toString());
    }
}
