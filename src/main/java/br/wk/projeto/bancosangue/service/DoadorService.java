package br.wk.projeto.bancosangue.service;

import br.wk.projeto.bancosangue.dto.DoadorDTO;
import br.wk.projeto.bancosangue.dto.DoadoresPorEstadoDTO;
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
    private final TipoSanguineoService tipoSanguineoService;

    public List<DoadorDTO> findAll() {
        final var tmp = doadorRepository.findAll().stream().map(this::doadorToDto).toList();
        if(tmp.isEmpty()) {
            throw new BaseServiceException(HttpStatus.NOT_FOUND, "Nenhum doador cadastrado");
        }
        return tmp;
    }

    public List<Doador> todos() {
        final var tmp = doadorRepository.findAll();
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

    private Long findTipoSanguineoByCodigo(String codigo) {
        return tipoSanguineoService.findByCodigo(codigo).getId();

    }

    public List<DoadorDTO> salvarTodos(List<DoadorDTO> doadores) {
        return doadores.stream().map(this::salvar).toList();
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
        if (doadorDTO.getTipoSanguineo() == null || doadorDTO.getTipoSanguineo().isBlank()) {
            throw new BaseServiceException(HttpStatus.BAD_REQUEST, "O Tipo sanguíneo não pode ser nulo");
        }
    }

    private DoadorDTO doadorToDto(Doador doador) {

        return DoadorDTO.builder()
                .id(doador.getId())
                .nome(doador.getNome())
                .cpf(doador.getCpf())
                .rg(doador.getRg())
                .dataNascimento(doador.getDataNascimento())
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
                .altura(doador.getAltura())
                .peso(doador.getPeso())
                .build();
    }

    private Doador dtoToDoador(DoadorDTO doadorDTO) {
        final var tmp = new Doador();
        tmp.setId(doadorDTO.getId());
        tmp.setNome(doadorDTO.getNome());
        tmp.setCpf(doadorDTO.getCpf());
        tmp.setRg(doadorDTO.getRg());
        tmp.setDataNascimento(doadorDTO.getDataNascimento());
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
        final  var idTipoSanguineo = findTipoSanguineoByCodigo(doadorDTO.getTipoSanguineo());
        tmp.setIdTipoSanguineo(idTipoSanguineo);
        tmp.setAltura(doadorDTO.getAltura());
        tmp.setPeso(doadorDTO.getPeso());
        return tmp;
    }

    public List<DoadoresPorEstadoDTO> doadoresPorEstado() {
        final var list = doadorRepository.doadoresPorEstado();
        return list.stream().map(this::toDoadoresPorEstado).toList();
    }

    private DoadoresPorEstadoDTO toDoadoresPorEstado(Object[] obj) {
        return DoadoresPorEstadoDTO.builder()
                .estado((String) obj[0])
                .quantidade(Math.toIntExact((Long) obj[1]))
                .build();
    }






}
