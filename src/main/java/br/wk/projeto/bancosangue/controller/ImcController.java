package br.wk.projeto.bancosangue.controller;

import br.wk.projeto.bancosangue.dto.ImcFaixaPorIdadeDTO;
import br.wk.projeto.bancosangue.dto.ObesosPorSexoDTO;
import br.wk.projeto.bancosangue.service.ImcService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/imc")
@RequiredArgsConstructor
public class ImcController {

    private final ImcService imcService;

    @GetMapping("/por-faixa-idade")
    public List<ImcFaixaPorIdadeDTO> faixaPorIdade(){
        return imcService.calcularPorFaixaEtaria();
    }

    @GetMapping("/percentual-obesos-por-sexo")
    public ObesosPorSexoDTO calcularPercentualObesosPorSexo(){
        return imcService.calcularPercentualObesosPorSexo();
    }
}
