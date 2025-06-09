package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Anunciante;
import org.springframework.data.repository.CrudRepository;

public interface IAnuncianteDAO extends CrudRepository<Anunciante, Long> {
    // Métodos adicionais se necessário
}
