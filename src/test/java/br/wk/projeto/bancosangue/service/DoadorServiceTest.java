package br.wk.projeto.bancosangue.service;

import br.wk.projeto.bancosangue.dto.DoadorDTO;
import br.wk.projeto.bancosangue.exception.BaseServiceException;
import br.wk.projeto.bancosangue.model.Doador;
import br.wk.projeto.bancosangue.repository.DoadorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DoadorServiceTest {

    @InjectMocks
    private DoadorService doadorService;
    @Mock
    private DoadorRepository doadorRepository;

    @Test
    void testSalvarDoador_Sucesso() {
        //given
        final var dto = buildDoadorDTO();
        final var doador = buildDoador();
        when(doadorRepository.save(any())).thenReturn(doador);
        //when
        final var response = doadorService.salvar(dto);
        //then
        assertEquals(dto.getNome(), response.getNome());
    }

    @Test
    void testSalvarDoador_NomeNulo() {
        //given
        final var dto = buildDoadorDTO();
        dto.setId(null);
        dto.setNome(null);
        //when
        final var exception = assertThrows(BaseServiceException.class, () -> doadorService.salvar(dto));
        //then
        assertEquals(exception.getHttpStatus(), HttpStatus.BAD_REQUEST);
    }

    private DoadorDTO buildDoadorDTO(){
        return DoadorDTO.builder()
                .id(1L)
                .nome("Teste")
                .cpf("123456789")
                .mae("Teste")
                .sexo("F")
                .datanascimento(LocalDate.now())
                .build();
    }


    private Doador buildDoador(){
        final var doador = new Doador();
        doador.setId(1L);
        doador.setNome("Teste");
        doador.setMae("Teste");
        doador.setCpf("123456789");
        doador.setSexo("F");
        doador.setDatanascimento(LocalDate.now());
        return doador;

    }
}
