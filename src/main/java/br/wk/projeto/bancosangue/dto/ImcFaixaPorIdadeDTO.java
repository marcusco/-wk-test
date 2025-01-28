package br.wk.projeto.bancosangue.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ImcFaixaPorIdadeDTO {
    private String faixa;
    private Double somaImc;
    private Double mediaImc;
    private Double quantidade;
}
