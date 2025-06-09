package br.ufscar.dc.dsw.config;

import br.ufscar.dc.dsw.domain.Anunciante;
import br.ufscar.dc.dsw.domain.Carro;
import br.ufscar.dc.dsw.dao.IAnuncianteDAO;
import br.ufscar.dc.dsw.dao.ICarroDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private IAnuncianteDAO anuncianteDAO;
    @Autowired
    private ICarroDAO carroDAO;

    @Override
    public void run(String... args) throws Exception {
        if (anuncianteDAO.count() == 0) {
            Anunciante a1 = new Anunciante();
            a1.setNome("João Silva");
            a1.setEmail("joao@email.com");
            a1.setTelefone("11999999999");
            a1.setCpf("123.456.789-00");
            a1.setEndereco("Rua A, 123");
            a1.setTipoPessoa("Física");
            a1.setDataCadastro(LocalDate.now());
            anuncianteDAO.save(a1);

            Anunciante a2 = new Anunciante();
            a2.setNome("AutoCar Ltda");
            a2.setEmail("contato@autocar.com");
            a2.setTelefone("1133334444");
            a2.setCpf("12.345.678/0001-00");
            a2.setEndereco("Av. Central, 456");
            a2.setTipoPessoa("Jurídica");
            a2.setDataCadastro(LocalDate.now());
            anuncianteDAO.save(a2);

            Carro c1 = new Carro();
            c1.setMarca("Toyota");
            c1.setModelo("Corolla");
            c1.setAno(2020);
            c1.setCor("Prata");
            c1.setPreco(95000.0);
            c1.setQuilometragem(30000);
            c1.setCambio("Automático");
            c1.setCombustivel("Flex");
            c1.setPlaca("ABC1D23");
            c1.setDescricao("Carro em ótimo estado");
            c1.setAnunciante(a1);
            carroDAO.save(c1);

            Carro c2 = new Carro();
            c2.setMarca("Honda");
            c2.setModelo("Civic");
            c2.setAno(2019);
            c2.setCor("Preto");
            c2.setPreco(88000.0);
            c2.setQuilometragem(40000);
            c2.setCambio("Manual");
            c2.setCombustivel("Gasolina");
            c2.setPlaca("DEF4G56");
            c2.setDescricao("Único dono, revisado");
            c2.setAnunciante(a2);
            carroDAO.save(c2);
        }
    }
}
