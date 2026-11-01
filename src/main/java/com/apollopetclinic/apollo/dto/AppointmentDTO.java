package com.apollopetclinic.apollo.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AppointmentDTO {
    @NotBlank(message = "Owner name is required")
    private String ownerName;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits")
    private String phone;

    @NotBlank(message = "Pet details are required")
    private String petDetails;

    @NotBlank(message = "Service selection is required")
    private String service;

    @NotBlank(message = "Date is required")
    private String date;

    @NotBlank(message = "Time is required")
    private String time;

    public String getOwnerName() { return ownerName; }
    public String getPhone() { return phone; }
    public String getPetDetails() { return petDetails; }
    public String getService() { return service; }
    public String getDate() { return date; }
    public String getTime() { return time; }
}