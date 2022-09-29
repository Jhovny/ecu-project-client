package ecu.project.client.web.controller;

import ecu.project.client.domain.dto.Client;
import ecu.project.client.domain.service.ClientService;
import ecu.project.client.infraestructure.exception.APIException;
import ecu.project.client.infraestructure.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {
    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @GetMapping()
    public ResponseEntity<List<Client>> getAll() {
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getId(@PathVariable long id) throws ResourceNotFoundException {

        return clientService.getById(id)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro cliente para id="+ id));

    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client){

        try {
            return new ResponseEntity<>(this.clientService.save(client), HttpStatus.OK);
        }
        catch (APIException err){
            log.error("Create",err);
            return new ResponseEntity(new APIException("Error Interno, intente nuavamente pf"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@RequestBody Client client,@PathVariable long id) {

        return clientService.getById(id)
                .map(x -> {
                    client.setIdClient(x.getIdClient());
                    return new ResponseEntity<>(clientService.save(x), HttpStatus.OK);})
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {

        if (clientService.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
