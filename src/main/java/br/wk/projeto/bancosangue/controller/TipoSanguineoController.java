package br.wk.projeto.bancosangue.controller;

import br.wk.projeto.bancosangue.dto.TipoSanguineoDTO;
import br.wk.projeto.bancosangue.service.TipoSanguineoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tipo-sanguineo")
public class TipoSanguineoController {

    private final TipoSanguineoService tipoSanguineoService;

    @GetMapping
    public List<TipoSanguineoDTO> findAll() { return tipoSanguineoService.findAll(); }


}
