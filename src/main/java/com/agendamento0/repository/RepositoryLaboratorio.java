package com.agendamento0.repository;

import com.agendamento0.model.ModelLaboratorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLaboratorio extends JpaRepository<ModelLaboratorio, Integer> {

}
