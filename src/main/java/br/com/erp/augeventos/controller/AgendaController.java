package br.com.erp.augeventos.controller;

import br.com.erp.augeventos.model.AgendaModel;
import br.com.erp.augeventos.model.repository.IAgendaRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private IAgendaRepository agendaRepository;

    @PostMapping("/")
    public AgendaModel create(@RequestBody AgendaModel agendaModel, HttpServletRequest request) {
        var idUser = request.getAttribute("idUser");
        agendaModel.setIdUser((Integer) idUser);
        return this.agendaRepository.save(agendaModel);

    }
}
