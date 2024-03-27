package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Grooming extends Appointment implements Printable{

    private ArrayList<String> services;

    public Grooming(Dog dog, LocalDate dropoff, ArrayList<String> services) {
        super(dog, dropoff);
        this.services = services;
    }

    @Override
    public String getAppointment_details() {
        return "Grooming{" + super.getAppointment_details() +
                ", service details=" + services +
                '}';
    }

    public ArrayList<String> getServices() {
        return services;
    }

    public void setServices(ArrayList<String> services) {
        this.services = services;
    }

    @Override
    public void setAppointment_details(String appointment_details) {
        super.setAppointment_details(appointment_details);
    }

    @Override
    public String toString() {
        return "Grooming{" +
                "services=" + services +
                ", dog=" + dog +
                ", dropoff=" + dropoff +
                ", appointment_details='" + appointment_details + '\'' +
                '}';
    }


    @Override
    public void BasicDetails() {
        System.out.println("Grooming{" +
                "dog=" + dog.getName() + " " + dog.getLastName() +
                ", date=" + dropoff +
                '}');
    }

    @Override
    public void AllDetails() {
        System.out.println(this.toString());
    }

}
