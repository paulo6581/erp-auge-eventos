package br.com.erp.augeventos.model.repository;

import br.com.erp.augeventos.model.AgendaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAgendaRepository extends JpaRepository<AgendaModel, Integer> {


}
