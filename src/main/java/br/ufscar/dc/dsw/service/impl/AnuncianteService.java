package br.ufscar.dc.dsw.service.impl;

import br.ufscar.dc.dsw.dao.IAnuncianteDAO;
import br.ufscar.dc.dsw.domain.Anunciante;
import br.ufscar.dc.dsw.service.spec.IAnuncianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnuncianteService implements IAnuncianteService {
    @Autowired
    private IAnuncianteDAO dao;

    public void salvar(Anunciante anunciante) {
        dao.save(anunciante);
    }

    public void excluir(Long id) {
        dao.deleteById(id);
    }

    public Anunciante buscarPorId(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<Anunciante> buscarTodos() {
        return (List<Anunciante>) dao.findAll();
    }
}
