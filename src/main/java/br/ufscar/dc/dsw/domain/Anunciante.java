package br.ufscar.dc.dsw.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Anunciante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    @NotBlank
    @Size(max = 15)
    private String telefone;

    @NotBlank
    @Size(max = 14)
    private String cpf;

    @NotBlank
    @Size(max = 200)
    private String endereco;

    @NotBlank
    @Size(max = 20)
    private String tipoPessoa;

    @NotNull
    private java.time.LocalDate dataCadastro;

    // Getters e setters
    // ...
}
