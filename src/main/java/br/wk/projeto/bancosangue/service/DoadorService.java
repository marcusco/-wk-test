package br.wk.projeto.bancosangue.service;

import br.wk.projeto.bancosangue.dto.DoadorDTO;
import br.wk.projeto.bancosangue.exception.BaseServiceException;
import br.wk.projeto.bancosangue.model.Doador;
import br.wk.projeto.bancosangue.repository.DoadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoadorService {

    private final DoadorRepository doadorRepository;

    public List<DoadorDTO> findAll() {
        final var tmp = doadorRepository.findAll().stream().map(this::doadorToDto).toList();
        if(tmp.isEmpty()) {
            throw new BaseServiceException(HttpStatus.NOT_FOUND, "Nenhum doador cadastrado");
        }
        return tmp;
    }

    public DoadorDTO salvar(DoadorDTO doadorDTO) {
        validate(doadorDTO);
        final var doador = dtoToDoador(doadorDTO);
        final var tmp = doadorRepository.save(doador);
        return doadorToDto(tmp);
    }

    private void validate(DoadorDTO doadorDTO) {
        if (doadorDTO.getNome() == null || doadorDTO.getNome().isBlank()) {
            throw new BaseServiceException(HttpStatus.BAD_REQUEST, "O nome não pode ser nulo");
        }
        if (doadorDTO.getCpf() == null || doadorDTO.getCpf().isBlank()) {
            throw new BaseServiceException(HttpStatus.BAD_REQUEST, "O CPF não pode ser nulo");
        }
        if (doadorDTO.getMae() == null || doadorDTO.getMae().isBlank()) {
            throw new BaseServiceException(HttpStatus.BAD_REQUEST, "O nome da Mãe não pode ser nulo");
        }
    }

    private DoadorDTO doadorToDto(Doador doador) {
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

    private Doador dtoToDoador(DoadorDTO doadorDTO) {
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
