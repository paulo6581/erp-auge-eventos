package br.com.erp.augeventos.controller;

import br.com.erp.augeventos.model.HistoricoAjudanteModel;
import br.com.erp.augeventos.model.repository.IHistoricoAjudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class HistoricoAjudanteController {
    @Autowired
    IHistoricoAjudanteRepository historicoAjudanteRepository;

    @PostMapping("/")
    public HistoricoAjudanteModel create(@RequestBody HistoricoAjudanteModel historicoAjudanteModel) {
        return this.historicoAjudanteRepository.save (historicoAjudanteModel);
    }
}
