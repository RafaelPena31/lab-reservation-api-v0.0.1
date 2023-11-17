package com.agendamento0.resource;

import com.agendamento0.model.ModelReserva;
import com.agendamento0.service.ServiceReserva;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/reserva")
@SecurityRequirement(name = "security_auth")
public class ResourceReserva {
    @Autowired
    private ServiceReserva serviceReserva;

    @GetMapping("")
    public ResponseEntity<List<ModelReserva>> listAll(){
        return new ResponseEntity<List<ModelReserva>> (serviceReserva.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ModelReserva> getReserva(@PathVariable("codigo") int id){
        Optional<ModelReserva> reservaOptional = serviceReserva.get(id);

        if (reservaOptional.isPresent()){
            return new ResponseEntity<ModelReserva>(reservaOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/salvar")
    public ResponseEntity<ModelReserva> salvar(@RequestBody ModelReserva reserva){
        if (!serviceReserva.getData(reserva.data).isPresent()) {
            serviceReserva.salvar(reserva);
            return new ResponseEntity<ModelReserva>(reserva, HttpStatus.CREATED);
        }
        return new ResponseEntity<ModelReserva>(reserva, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/excluir/{codigo}")
    public ResponseEntity<ModelReserva> excluir(@PathVariable("codigo") int codigo){
        Optional<ModelReserva> optionalReserva = serviceReserva.get(codigo);

        if (optionalReserva.isPresent()){
            serviceReserva.excluir(optionalReserva.get());
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editar/{codigo}")
    public ResponseEntity<ModelReserva> editar(@PathVariable("codigo") int codigo, @RequestBody ModelReserva reserva){

        Optional<ModelReserva> optionalReserva = serviceReserva.get(codigo);

        if (optionalReserva.isPresent() && !serviceReserva.getData(reserva.data).isPresent()){
            reserva.setID(codigo);
            serviceReserva.salvar(reserva);
            return new ResponseEntity<ModelReserva>(reserva, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
