package br.wk.projeto.bancosangue.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DoadoresPorEstadoDTO {

    private String estado;
    private Integer quantidade;

}
