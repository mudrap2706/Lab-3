/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author mudra
 */
import java.awt.Image;
import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String message;
    private String patientType;
    private String gender;
    private Image photo;
    private Date appointmentDate;

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getPatientType() { return patientType; }
    public void setPatientType(String patientType) { this.patientType = patientType; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public Image getPhoto() { return photo; }
    public void setPhoto(Image photo) { this.photo = photo; }

    public Date getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(Date appointmentDate) { this.appointmentDate = appointmentDate; }
}
