package com.agendamento0.repository;

import com.agendamento0.model.ModelReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface RepositoryReserva extends JpaRepository<ModelReserva, Integer> {
    Optional<ModelReserva> findByData(Date data);
}