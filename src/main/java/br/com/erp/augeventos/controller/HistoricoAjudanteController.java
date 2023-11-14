package br.com.erp.augeventos.controller;

import br.com.erp.augeventos.model.HistoricoAjudanteModel;
import br.com.erp.augeventos.model.repository.IHistoricoAjudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historicoajudante")
public class HistoricoAjudanteController {
    @Autowired
    IHistoricoAjudanteRepository historicoajudanteRepository;

    @PostMapping("/")
    public HistoricoAjudanteModel create(@RequestBody HistoricoAjudanteModel historicoAjudanteModel) {
        return this.historicoajudanteRepository.save (historicoAjudanteModel);
    }
}
