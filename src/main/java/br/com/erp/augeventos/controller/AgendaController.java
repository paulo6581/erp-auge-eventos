package br.com.erp.augeventos.controller;

import br.com.erp.augeventos.model.AgendaModel;
import br.com.erp.augeventos.model.repository.IAgendaRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private IAgendaRepository agendaRepository;

    @GetMapping("/")
    public List<AgendaModel> getAllAgendas() {
        return agendaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<AgendaModel> getAgendaById(@PathVariable int id) {
        return agendaRepository.findById(id);
    }

    @PutMapping("/{id}")
    public AgendaModel updateAgenda(@PathVariable int id, @RequestBody AgendaModel updatedAgenda) {
        Optional<AgendaModel> existingAgenda = agendaRepository.findById(id);

        if (existingAgenda.isPresent()) {
            AgendaModel agendaToUpdate = existingAgenda.get();
            agendaToUpdate.setTituloEvento(updatedAgenda.getTituloEvento());
            agendaToUpdate.setDscEvento(updatedAgenda.getDscEvento());
            agendaToUpdate.setDatHoraInicial(updatedAgenda.getDatHoraInicial());
            agendaToUpdate.setDatHoraFinal(updatedAgenda.getDatHoraFinal());

            return agendaRepository.save(agendaToUpdate);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAgenda(@PathVariable int id) {
        // Exclua a agenda com o ID especificado, se existir
        agendaRepository.deleteById(id);
    }

    @PostMapping("/")
    public AgendaModel create(@RequestBody AgendaModel agendaModel, HttpServletRequest request) {
        var idUser = request.getAttribute("idUser");
        agendaModel.setIdUser((Integer) idUser);
        return this.agendaRepository.save(agendaModel);
    }
}
