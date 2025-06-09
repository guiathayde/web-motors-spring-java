package br.ufscar.dc.dsw.service.spec;

import br.ufscar.dc.dsw.domain.Carro;
import java.util.List;

public interface ICarroService {
    void salvar(Carro carro);

    void excluir(Long id);

    Carro buscarPorId(Long id);

    List<Carro> buscarTodos();
}
