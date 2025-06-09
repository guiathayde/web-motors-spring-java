package br.ufscar.dc.dsw.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String marca;

    @NotBlank
    @Size(max = 50)
    private String modelo;

    @NotNull
    @Min(1900)
    @Max(2100)
    private Integer ano;

    @NotBlank
    @Size(max = 30)
    private String cor;

    @NotNull
    @DecimalMin("0.0")
    private Double preco;

    @NotNull
    @Min(0)
    private Integer quilometragem;

    @NotBlank
    @Size(max = 20)
    private String cambio;

    @NotBlank
    @Size(max = 20)
    private String combustivel;

    @NotBlank
    @Size(max = 8)
    private String placa;

    @Size(max = 255)
    private String descricao;

    @ManyToOne(optional = false)
    private Anunciante anunciante;

    // Getters e setters
    // ...
}
