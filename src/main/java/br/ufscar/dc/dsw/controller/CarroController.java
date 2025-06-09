package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.domain.Carro;
import br.ufscar.dc.dsw.service.spec.ICarroService;
import jakarta.validation.Valid;
import br.ufscar.dc.dsw.service.spec.IAnuncianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private ICarroService carroService;
    @Autowired
    private IAnuncianteService anuncianteService;

    @GetMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("carros", carroService.buscarTodos());
        return "carro/lista";
    }

    @GetMapping("/cadastro")
    public String cadastro(Carro carro, Model model) {
        model.addAttribute("anunciantes", anuncianteService.buscarTodos());
        return "carro/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Carro carro, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("anunciantes", anuncianteService.buscarTodos());
            return "carro/cadastro";
        }
        carroService.salvar(carro);
        return "redirect:/carros/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("carro", carroService.buscarPorId(id));
        model.addAttribute("anunciantes", anuncianteService.buscarTodos());
        return "carro/cadastro";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id) {
        carroService.excluir(id);
        return "redirect:/carros/lista";
    }
}
