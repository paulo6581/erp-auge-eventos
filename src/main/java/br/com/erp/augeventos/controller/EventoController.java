package br.com.erp.augeventos.controller;

import br.com.erp.augeventos.model.EventoModel;
import br.com.erp.augeventos.model.repository.IEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Importe a classe correta
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    IEventoRepository eventoRepository;

    @PostMapping("/")
    public String create(@ModelAttribute EventoModel eventoModel) {
        eventoRepository.save(eventoModel);
        return "redirect:/evento/formulario";
    }
}
