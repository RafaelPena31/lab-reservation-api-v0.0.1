package com.agendamento0.resource;

import com.agendamento0.model.ModelLaboratorio;
import com.agendamento0.service.ServiceLaboratorio;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/laboratorio")
@SecurityRequirement(name = "security_auth")
public class ResourceLaboratorio {
    @Autowired
    private ServiceLaboratorio serviceLaboratorio;

    @GetMapping("")
    public ResponseEntity<List<ModelLaboratorio>> listAll(){
        return new ResponseEntity<List<ModelLaboratorio>> (serviceLaboratorio.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ModelLaboratorio> getLaboratorio(@PathVariable("codigo") int id){
        Optional<ModelLaboratorio> laboratorioOptional = serviceLaboratorio.get(id);

        if (laboratorioOptional.isPresent()){
            return new ResponseEntity<ModelLaboratorio>(laboratorioOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/salvar")
    public ResponseEntity<ModelLaboratorio> salvar(@RequestBody ModelLaboratorio laboratorio){

        serviceLaboratorio.salvar(laboratorio);
        return new ResponseEntity<ModelLaboratorio>(laboratorio, HttpStatus.CREATED);
    }

    @DeleteMapping("/excluir/{codigo}")
    public ResponseEntity<ModelLaboratorio> excluir(@PathVariable("codigo") int codigo){
        Optional<ModelLaboratorio> optionalLaboratorio = serviceLaboratorio.get(codigo);

        if (optionalLaboratorio.isPresent()){
            serviceLaboratorio.excluir(optionalLaboratorio.get());
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editar/{codigo}")
    public ResponseEntity<ModelLaboratorio> editar(@PathVariable("codigo") int codigo, @RequestBody ModelLaboratorio laboratorio){

        Optional<ModelLaboratorio> optionalLaboratorio = serviceLaboratorio.get(codigo);

        if (optionalLaboratorio.isPresent()){
            laboratorio.setID(codigo);
            serviceLaboratorio.salvar(laboratorio);
            return new ResponseEntity<ModelLaboratorio>(laboratorio, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
