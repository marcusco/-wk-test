package br.wk.projeto.bancosangue.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class DoadorDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("cpf")
    private String cpf;
    @JsonProperty("rg")
    private String rg;
    @JsonProperty("data_nasc")
    private LocalDate dataNascimento;
    @JsonProperty("sexo")
    private String sexo;
    @JsonProperty("mae")
    private String mae;
    @JsonProperty("pai")
    private String pai;
    @JsonProperty("email")
    private String email;
    @JsonProperty("cep")
    private String cep;
    @JsonProperty("endereco")
    private String endereco;
    @JsonProperty("bairro")
    private String bairro;
    @JsonProperty("cidade")
    private String cidade;
    @JsonProperty("estado")
    private String estado;
    @JsonProperty("telefone_fixo")
    private String telefoneFixo;
    @JsonProperty("celular")
    private String celular;
    @JsonProperty("tipo_sanguineo")
    private String tipoSanguineo;
    @JsonProperty("altura")
    private Double altura;
    @JsonProperty("peso")
    private Double peso;
}
