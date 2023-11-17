package br.com.erp.augeventos.controller;

import br.com.erp.augeventos.model.ClienteModel;
import br.com.erp.augeventos.model.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteModel> getAllCliente() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ClienteModel getClienteById(@PathVariable int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ClienteModel createCliente(@RequestBody ClienteModel clienteModel) {
        return clienteRepository.save(clienteModel);
    }

    @PutMapping("/{id}")
    public ClienteModel updateCliente(@PathVariable int id, @RequestBody ClienteModel clienteModel) {
        clienteModel.setIdCliente(id);
        return clienteRepository.save(clienteModel);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable int id) {
        clienteRepository.deleteById(id);
    }
}