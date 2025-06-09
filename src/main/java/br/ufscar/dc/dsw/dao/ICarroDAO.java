package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Carro;
import org.springframework.data.repository.CrudRepository;

public interface ICarroDAO extends CrudRepository<Carro, Long> {
    // Métodos adicionais se necessário
}
