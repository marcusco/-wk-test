package br.wk.projeto.bancosangue.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@Builder

public class TipoSanguineoDTO {

    private Long id;
    private String codigo;
    private String doar;
    private String receber;
}
