package br.ufscar.dc.dsw.service.spec;

import br.ufscar.dc.dsw.domain.Anunciante;
import java.util.List;

public interface IAnuncianteService {
    void salvar(Anunciante anunciante);

    void excluir(Long id);

    Anunciante buscarPorId(Long id);

    List<Anunciante> buscarTodos();
}
