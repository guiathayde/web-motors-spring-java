package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.domain.Anunciante;
import br.ufscar.dc.dsw.service.spec.IAnuncianteService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/anunciantes")
public class AnuncianteController {
    @Autowired
    private IAnuncianteService service;

    @GetMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("anunciantes", service.buscarTodos());
        return "anunciante/lista";
    }

    @GetMapping("/cadastro")
    public String cadastro(Anunciante anunciante) {
        return "anunciante/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Anunciante anunciante, BindingResult result) {
        if (result.hasErrors()) {
            return "anunciante/cadastro";
        }
        service.salvar(anunciante);
        return "redirect:/anunciantes/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("anunciante", service.buscarPorId(id));
        return "anunciante/cadastro";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/anunciantes/lista";
    }
}
