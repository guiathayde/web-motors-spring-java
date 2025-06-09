package br.ufscar.dc.dsw.service.impl;

import br.ufscar.dc.dsw.dao.ICarroDAO;
import br.ufscar.dc.dsw.domain.Carro;
import br.ufscar.dc.dsw.service.spec.ICarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService implements ICarroService {
    @Autowired
    private ICarroDAO dao;

    public void salvar(Carro carro) {
        dao.save(carro);
    }

    public void excluir(Long id) {
        dao.deleteById(id);
    }

    public Carro buscarPorId(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<Carro> buscarTodos() {
        return (List<Carro>) dao.findAll();
    }
}
