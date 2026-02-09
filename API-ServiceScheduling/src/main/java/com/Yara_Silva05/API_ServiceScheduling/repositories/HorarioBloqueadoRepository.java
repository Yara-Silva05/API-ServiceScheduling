package com.Yara_Silva05.API_ServiceScheduling.repositories;

import com.Yara_Silva05.API_ServiceScheduling.models.HorarioBloqueadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HorarioBloqueadoRepository extends JpaRepository<HorarioBloqueadoModel, UUID> {

}
