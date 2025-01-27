package br.wk.projeto.bancosangue.controller;

import br.wk.projeto.bancosangue.dto.DoadorDTO;

import br.wk.projeto.bancosangue.service.DoadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/doador")
@RequiredArgsConstructor
public class DoadorController {

    private  final DoadorService doadorService;


    @GetMapping
    List<DoadorDTO> findAll() { return doadorService.findAll(); }
}
