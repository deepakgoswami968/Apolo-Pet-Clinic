//package com.apollopetclinic.apollo.repository;

//package com.apollopetclinic.repository;
//import com.apollopetclinic.apollo.entity.Appointment;
//import com.apollopetclinic.entity.Appointment;
package com.apollopetclinic.apollo.repository;

import com.apollopetclinic.apollo.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.time.LocalTime;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    boolean existsByDateAndTime(LocalDate date, LocalTime time);
}