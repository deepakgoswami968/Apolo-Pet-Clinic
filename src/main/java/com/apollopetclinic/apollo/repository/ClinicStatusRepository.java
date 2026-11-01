package com.apollopetclinic.apollo.repository;

//package com.apollopetclinic.apollo.repository;

import com.apollopetclinic.apollo.entity.ClinicStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicStatusRepository extends JpaRepository<ClinicStatus, Long>
{
}