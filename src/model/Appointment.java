package model;
import java.io.Serializable;
import java.time.LocalDate;

public class Appointment implements Printable, Serializable {

    protected Dog dog;    //who the appointment is for
    protected LocalDate dropoff;   //date of appointment
    protected String appointment_details;

    public Appointment(Dog dog, LocalDate dropoff) {
        this.dog = dog;
        this.dropoff = dropoff;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public LocalDate getDropOffDate() {
        return dropoff;
    }

    public void setDropOffDate(LocalDate date) {
        this.dropoff = date;
    }

    public String getAppointment_details() {
        return "Appointment{" +
                "dog=" + dog +
                ", date=" + dropoff +
                '}';
    }

    public void setAppointment_details(String appointment_details) {
        this.appointment_details = appointment_details;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "dog=" + dog +
                ", date=" + dropoff +
                '}';
    }

    @Override
    public void BasicDetails() {
        System.out.println("Appointment{" +
                "dog=" + dog.getName() + " " + dog.getLastName() +
                ", date=" + dropoff +
                '}');
    }

    @Override
    public void AllDetails() {
        System.out.println(this.toString());
    }
}
