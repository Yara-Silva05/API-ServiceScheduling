package com.Yara_Silva05.API_ServiceScheduling.repositories;

import com.Yara_Silva05.API_ServiceScheduling.models.AgendamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, UUID> {
}
