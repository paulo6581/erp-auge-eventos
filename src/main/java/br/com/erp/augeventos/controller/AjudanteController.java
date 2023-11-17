package br.com.erp.augeventos.controller;

import br.com.erp.augeventos.model.AjudanteModel;
import br.com.erp.augeventos.model.repository.IAjudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajudante")
public class AjudanteController {

    @Autowired
    private IAjudanteRepository ajudanteRepository;

    @GetMapping
    public List<AjudanteModel> getAllAjudantes() {
        return ajudanteRepository.findAll();
    }

    @GetMapping("/{id}")
    public AjudanteModel getAjudanteById(@PathVariable int id) {
        return ajudanteRepository.findById(id).orElse(null);
    }

    @PostMapping
    public AjudanteModel createAjudante(@RequestBody AjudanteModel ajudanteModel) {
        return ajudanteRepository.save(ajudanteModel);
    }

    @PutMapping("/{id}")
    public AjudanteModel updateAjudante(@PathVariable int id, @RequestBody AjudanteModel ajudanteModel) {
        ajudanteModel.setIdAjudante(id);
        return ajudanteRepository.save(ajudanteModel);
    }
    
    @DeleteMapping("/{id}")
    public void deleteAjudante(@PathVariable int id) {
        ajudanteRepository.deleteById(id);
    }
}
