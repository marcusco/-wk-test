package br.wk.projeto.bancosangue.service;

import br.wk.projeto.bancosangue.dto.DoadorDTO;
import br.wk.projeto.bancosangue.model.Doador;
import br.wk.projeto.bancosangue.repository.DoadorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoadorService {

    private final DoadorRepository doadorRepository;

    public List<DoadorDTO> findAll() {
        final var tmp = doadorRepository.findAll().stream().map(this::doadorDTO).toList();

        return tmp;
    }

    private DoadorDTO doadorDTO(Doador doador) {
        return DoadorDTO.builder()
                .id(doador.getId())
                .nome(doador.getNome())
                .cpf(doador.getCpf())
                .datanascimento(doador.getDatanascimento())
                .sexo(doador.getSexo())
                .mae(doador.getMae())
                .pai(doador.getPai())
                .email(doador.getEmail())
                .cep(doador.getCep())
                .endereco(doador.getEndereco())
                .bairro(doador.getBairro())
                .cidade(doador.getCidade())
                .estado(doador.getEstado())
                .telefoneFixo(doador.getTelefoneFixo())
                .celular(doador.getCelular())
                .build();
    }

    private Doador doador(DoadorDTO doadorDTO) {
        final var tmp = new Doador();
        tmp.setId(doadorDTO.getId());
        tmp.setNome(doadorDTO.getNome());
        tmp.setCpf(doadorDTO.getCpf());
        tmp.setDatanascimento(doadorDTO.getDatanascimento());
        tmp.setSexo(doadorDTO.getSexo());
        tmp.setMae(doadorDTO.getMae());
        tmp.setPai(doadorDTO.getPai());
        tmp.setEmail(doadorDTO.getEmail());
        tmp.setCep(doadorDTO.getCep());
        tmp.setEndereco(doadorDTO.getEndereco());
        tmp.setBairro(doadorDTO.getBairro());
        tmp.setCidade(doadorDTO.getCidade());
        tmp.setEstado(doadorDTO.getEstado());
        tmp.setTelefoneFixo(doadorDTO.getTelefoneFixo());
        tmp.setCelular(doadorDTO.getCelular());
        tmp.setTipoSanguineo(doadorDTO.getTipoSanguineo());
        return tmp;
    }


}
