package com.apollopetclinic.apollo.entity;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ownerName;
    private String phone;
    private String petDetails;
    private String service;
    private String date;
    private String time;
    private String status = "BOOKED";
    private LocalDateTime createdAt = LocalDateTime.now();

    public Appointment() {}

    public Appointment(String ownerName, String phone, String petDetails, String service, String date, String time) {
        this.ownerName = ownerName;
        this.phone = phone;
        this.petDetails = petDetails;
        this.service = service;
        this.date = date;
        this.time = time;
    }

    public Long getId() { return id; }
    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getPetDetails() { return petDetails; }
    public void setPetDetails(String petDetails) { this.petDetails = petDetails; }
    public String getService() { return service; }
    public void setService(String service) { this.service = service; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}