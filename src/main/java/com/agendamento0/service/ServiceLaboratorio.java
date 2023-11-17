package com.agendamento0.service;

import com.agendamento0.model.ModelLaboratorio;
import com.agendamento0.repository.RepositoryLaboratorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceLaboratorio {
    @Autowired
    private RepositoryLaboratorio repositoryLaboratorio;

    public void salvar(ModelLaboratorio laboratorio) {
        repositoryLaboratorio.save(laboratorio);
    }

    public List<ModelLaboratorio> listAll(){
        return repositoryLaboratorio.findAll();
    }

    public Optional<ModelLaboratorio> get(int id){
        return repositoryLaboratorio.findById(id);
    }

    public void excluir(ModelLaboratorio laboratorio) {
        repositoryLaboratorio.delete(laboratorio);
    }
}
