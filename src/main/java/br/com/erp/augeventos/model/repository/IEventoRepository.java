package br.com.erp.augeventos.model.repository;

import br.com.erp.augeventos.model.EventoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventoRepository extends JpaRepository<EventoModel, Integer> {

}
