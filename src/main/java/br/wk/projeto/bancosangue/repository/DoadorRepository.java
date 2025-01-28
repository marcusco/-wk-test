package br.wk.projeto.bancosangue.repository;

import br.wk.projeto.bancosangue.model.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, Long> {

    @Query(value = "select estado, count(*) from doador group by estado order by estado", nativeQuery = true)
    List<Object[]> doadoresPorEstado();
}
