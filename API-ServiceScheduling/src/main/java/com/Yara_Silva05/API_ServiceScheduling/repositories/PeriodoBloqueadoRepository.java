package com.Yara_Silva05.API_ServiceScheduling.repositories;

import com.Yara_Silva05.API_ServiceScheduling.models.PeriodoBloqueadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PeriodoBloqueadoRepository extends JpaRepository<PeriodoBloqueadoModel, UUID> {

}
