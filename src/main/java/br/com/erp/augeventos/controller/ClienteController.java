package br.com.erp.augeventos.controller;

import br.com.erp.augeventos.model.ClienteModel;
import br.com.erp.augeventos.model.repository.IClienteRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(description = "Busca o cliente pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o cliente"),
            @ApiResponse(responseCode = "400", description = "Não existe o cliente com o id informado")
    })

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
