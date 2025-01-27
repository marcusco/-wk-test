package br.wk.projeto.bancosangue.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class DoadorDTO {

    private Long id;
    private String nome;
    private String cpf;
    private LocalDate datanascimento;
    private String sexo;
    private String mae;
    private String pai;
    private String email;
    private String cep;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefoneFixo;
    private String celular;
    private Long tipoSanguineo;
}
