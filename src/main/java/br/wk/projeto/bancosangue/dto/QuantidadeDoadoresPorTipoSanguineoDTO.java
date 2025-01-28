package br.wk.projeto.bancosangue.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class QuantidadeDoadoresPorTipoSanguineoDTO {
    private String tipoSanguineo;
    private String receber;
    private int quantidade;
}
