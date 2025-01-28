package br.wk.projeto.bancosangue.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@Builder
public class ObesosPorSexoDTO {
    private Double percentualMasculino;
    private Double percentualFeminino;
}
