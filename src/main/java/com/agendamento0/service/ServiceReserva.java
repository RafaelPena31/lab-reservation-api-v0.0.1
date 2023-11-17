package com.agendamento0.service;

import com.agendamento0.model.ModelReserva;
import com.agendamento0.repository.RepositoryReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceReserva {
    @Autowired
    private RepositoryReserva repositoryReserva;

    public void salvar(ModelReserva reserva) {
        repositoryReserva.save(reserva);
    }

    public List<ModelReserva> listAll(){
        return repositoryReserva.findAll();
    }

    public Optional<ModelReserva> get(int id){
        return repositoryReserva.findById(id);
    }
    public Optional<ModelReserva> getData(Date data){
        return repositoryReserva.findByData(data);
    }

    public void excluir(ModelReserva reserva) {
        repositoryReserva.delete(reserva);
    }
}
