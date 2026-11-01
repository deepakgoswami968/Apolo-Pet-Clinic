package com.apollopetclinic.apollo.controller;

//package com.apollopetclinic.controller;

import com.apollopetclinic.apollo.dto.AppointmentDTO;
import com.apollopetclinic.apollo.entity.Appointment;
import com.apollopetclinic.apollo.entity.ClinicStatus;
import com.apollopetclinic.apollo.repository.AppointmentRepository;
import com.apollopetclinic.apollo.repository.ClinicStatusRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @PostMapping("/appointments")
    public ResponseEntity<Appointment> bookAppointment(@Valid @RequestBody AppointmentDTO dto) {
        Appointment appointment = new Appointment(
                dto.getOwnerName(), dto.getPhone(), dto.getPetDetails(),
                dto.getService(), dto.getDate(), dto.getTime()
        );
        return ResponseEntity.ok(appointmentRepository.save(appointment));
    }

    @GetMapping("/admin/appointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentRepository.findAll());
    }
    @Autowired
    private ClinicStatusRepository clinicStatusRepository;

// Public Endpoint: Koi bhi (User/Visitor) status check kar sakta hai
public ResponseEntity<Map<String, Boolean>> getClinicStatus() {
    ClinicStatus status = clinicStatusRepository.findById(1L)
            .orElseGet(() -> clinicStatusRepository.save(new ClinicStatus(true)));
    Map<String, Boolean> res = new HashMap<>();
    res.put("open", status.isOpen());
    return ResponseEntity.ok(res);
}


    // Admin Only Endpoint: Status change karne ke liye
@PostMapping("/api/admin/clinic/status")
public ResponseEntity<Map<String, String>> toggleClinicStatus(@RequestBody Map<String, Boolean> request) {
    Boolean isOpen = request.get("open");
    ClinicStatus status = clinicStatusRepository.findById(1L)
            .orElse(new ClinicStatus(true));
    status.setOpen(isOpen != null && isOpen);
    clinicStatusRepository.save(status);

    Map<String, String> res = new HashMap<>();
    res.put("message", "Clinic status updated to: " + (status.isOpen() ? "OPEN" : "CLOSED"));
    return ResponseEntity.ok(res);
}

}