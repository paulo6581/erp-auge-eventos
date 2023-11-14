package br.com.erp.augeventos.controller;

import br.com.erp.augeventos.model.EventoModel;
import br.com.erp.augeventos.model.repository.IEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    IEventoRepository eventoRepository;

    @PostMapping("/")
    public EventoModel create(@RequestBody EventoModel eventoModel) {
        System.out.println("Chegoou no Controller");

        return this.eventoRepository.save(eventoModel);
    }
}
