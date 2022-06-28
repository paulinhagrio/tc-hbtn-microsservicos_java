package com.example.jpah2demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
        try{
            return new ResponseEntity<>(clienteRepository.save(cliente), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
        try {
            return new ResponseEntity(clienteRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        Optional<Cliente> cliente = this.clienteRepository.findById(idClient);

        if (cliente.isPresent()) return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/removeClientById/{id}")
    public ResponseEntity<HttpStatus> removerCliente(@PathVariable("id") Long idClient) {
        try {
            this.clienteRepository.deleteById(idClient);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateClientById/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteOld = this.clienteRepository.findById(id);

        if (clienteOld.isPresent()) {
            Cliente clienteUpdated = clienteOld.get();
            clienteUpdated.setNome(cliente.getNome());
            clienteUpdated.setIdade(cliente.getIdade());
            clienteUpdated.setEmail(cliente.getEmail());
            clienteUpdated.setTelefones(cliente.getTelefones());
            clienteUpdated.setEnderecos(cliente.getEnderecos());

            return new ResponseEntity<>(this.clienteRepository.save(clienteUpdated), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

//        @PostMapping("/addClient")
//        @RequestMapping("/cliente")
//        public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
//            return addClient(cliente);
//        }
//
//        @GetMapping("/findAllClients")
//        @ResponseStatus(HttpStatus.OK)
//        public ResponseEntity<List<Cliente>> findAllClients() {
//            return findAllClients();
//        }
//
//        @GetMapping("/findClientById/{id}")
//        @ResponseStatus(HttpStatus.OK)
//        public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
//            return findClientById(idClient);
//        }
//
//        @DeleteMapping("/removeClientById/{id}")
//        @ResponseStatus(HttpStatus.NO_CONTENT)
//        public void removerCliente(@PathVariable("id") Long idClient){
//            removerCliente(idClient);
//        }
//
//        @PutMapping("/updateClientById/{id}")
//        @ResponseStatus(HttpStatus.NO_CONTENT)
//        public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
//            updateCliente(id, cliente);
//        }
}

