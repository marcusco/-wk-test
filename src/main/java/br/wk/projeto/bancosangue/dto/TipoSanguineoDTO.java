package br.wk.projeto.bancosangue.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@Builder

public class TipoSanguineoDTO {

    private BigInteger id;
    private String codigo;
    private String doar;
    private String receber;
}
