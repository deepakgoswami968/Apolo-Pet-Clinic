package com.apollopetclinic.apollo.entity;

//Spackage com.apollopetclinic.apollo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clinic_status")
public class ClinicStatus {
    @Id
    private Long id = 1L; // Always 1 single row for clinic status

    private boolean open = true;

    public ClinicStatus() {}

    public ClinicStatus(boolean open) {
        this.open = open;
    }

    public Long getId() { return id; }
    public boolean isOpen() { return open; }
    public void setOpen(boolean open) { this.open = open; }
}