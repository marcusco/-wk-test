package br.wk.projeto.bancosangue.service;

import br.wk.projeto.bancosangue.dto.DoadorDTO;
import br.wk.projeto.bancosangue.dto.DoadoresPorEstadoDTO;
import br.wk.projeto.bancosangue.dto.MediaIdadeTipoSanguineoDTO;
import br.wk.projeto.bancosangue.dto.TipoSanguineoDTO;
import br.wk.projeto.bancosangue.exception.BaseServiceException;
import br.wk.projeto.bancosangue.model.Doador;
import br.wk.projeto.bancosangue.repository.DoadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class DoadorService {

    private final DoadorRepository doadorRepository;
    private final TipoSanguineoService tipoSanguineoService;

    public List<DoadorDTO> findAll() {
        final var tmp = doadorRepository.findAll().stream().map(this::doadorToDto).toList();
        if (tmp.isEmpty()) {
            throw new BaseServiceException(HttpStatus.NOT_FOUND, "Nenhum doador cadastrado");
        }
        return tmp;
    }

    public List<Doador> todos() {
        final var tmp = doadorRepository.findAll();
        if (tmp.isEmpty()) {
            throw new BaseServiceException(HttpStatus.NOT_FOUND, "Nenhum doador cadastrado");
        }
        return tmp;
    }

    public DoadorDTO salvar(DoadorDTO doadorDTO) {
        validate(doadorDTO);
        final var doador = dtoToDoador(doadorDTO);
        final var doadprTmp = doadorRepository.findByCpf(doador.getCpf());
        if(!Objects.isNull(doadprTmp)){
            doador.setId(doadprTmp.getId());
        }
        final var tmp = doadorRepository.save(doador);
        return doadorToDto(tmp);
    }

    private TipoSanguineoDTO findTipoSanguineoByCodigo(String codigo) {
        return tipoSanguineoService.findByCodigo(codigo);

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
        final var tipoSanguineo = findTipoSanguineoByCodigo(doadorDTO.getTipoSanguineo());
        tmp.setIdTipoSanguineo(tipoSanguineo.getId());
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


    public List<MediaIdadeTipoSanguineoDTO> calcularMediaIdadePorGrupoSanguineo() {
        Map<String, Integer> somaIdades = new HashMap<>();
        Map<String, Integer> contador = new HashMap<>();
        final var listMediaIdade = new ArrayList<MediaIdadeTipoSanguineoDTO>();
        final var doadores = todos();

        // Calcula a soma das idades e o total de pessoas para cada tipo sanguíneo
        for (Doador doador : doadores) {
            final var tipo = tipoSanguineoService.findById(doador.getIdTipoSanguineo());
            ;
            final var idade = LocalDate.now().getYear() - doador.getDataNascimento().getYear();
            somaIdades.put(tipo.getCodigo(), somaIdades.getOrDefault(tipo.getCodigo(), 0) + idade);
            contador.put(tipo.getCodigo(), contador.getOrDefault(tipo.getCodigo(), 0) + 1);
        }

        int totalIdade = 0;
        int totalDoares = 0;
        double mediaIdade = 0.0;

        // Calcula e exibe a média de idade para cada tipo sanguíneo
        for (String tipo : somaIdades.keySet()) {
            totalIdade = somaIdades.get(tipo);
            totalDoares = contador.get(tipo);
            mediaIdade = totalDoares > 0 ? (double) totalIdade / totalDoares : 0.0;
            listMediaIdade.add(MediaIdadeTipoSanguineoDTO
                    .builder()
                    .tipoSanguineo(tipo)
                    .mediaIdade(mediaIdade)
                    .build());

        }
        return listMediaIdade;
    }


}
