package br.wk.projeto.bancosangue.controller;

import br.wk.projeto.bancosangue.dto.DoadorDTO;

import br.wk.projeto.bancosangue.dto.DoadoresPorEstadoDTO;
import br.wk.projeto.bancosangue.dto.MediaIdadeTipoSanguineoDTO;
import br.wk.projeto.bancosangue.service.DoadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doador")
@RequiredArgsConstructor
public class DoadorController {

    private  final DoadorService doadorService;

    @GetMapping
    public List<DoadorDTO> findAll() {
        return doadorService.findAll();
    }


    @PostMapping
    public DoadorDTO salvar(@RequestBody  DoadorDTO doadorDTO) {
        return doadorService.salvar(doadorDTO);
    }

    @PostMapping("/todos")
    public List<DoadorDTO> salvarTodos(@RequestBody  List<DoadorDTO> doadores) {
        return doadorService.salvarTodos(doadores);
    }

    @GetMapping("/doadores-por-estado")
    public List<DoadoresPorEstadoDTO> doadoresPorEstado() {
        return doadorService.doadoresPorEstado();
    }


    @GetMapping("/media-idade-por-tipo-sanguineo")
    public List<MediaIdadeTipoSanguineoDTO> calcularMediaIdadePorGrupoSanguineo() {
        return doadorService.calcularMediaIdadePorGrupoSanguineo();
    }
}
