package com.Yara_Silva05.API_ServiceScheduling.repositories;

import com.Yara_Silva05.API_ServiceScheduling.models.PeriodoBloqueadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.UUID;

public interface PeriodoBloqueadoRepository extends JpaRepository<PeriodoBloqueadoModel, UUID> {

    @Query("""
    SELECT COUNT(p) > 0
    FROM PeriodoBloqueadoModel p
    WHERE p.inicioPeriodoBloqueio < :encerramento
      AND p.finalPeriodoBloqueio > :inicio
    """)
    boolean existePeriodoBloqueadoConflitante(
            @Param("inicio") LocalDateTime inicio,
            @Param("encerramento") LocalDateTime encerramento
    );

}
