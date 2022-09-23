package ecu.project.client.web.controller;

import ecu.project.client.domain.dto.Client;
import ecu.project.client.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping()
    public ResponseEntity<List<Client>> getAll() {
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getAll(@PathVariable long id) {

        return clientService.getById(id)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client){
        return  new ResponseEntity<>(this.clientService.save(client), HttpStatus.OK) ;
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
