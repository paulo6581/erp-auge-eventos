package br.com.erp.augeventos.model.repository;

import br.com.erp.augeventos.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<ClienteModel, Integer> {
    ClienteModel findClienteModelBy();

}
