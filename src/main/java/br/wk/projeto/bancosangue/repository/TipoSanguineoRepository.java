package br.wk.projeto.bancosangue.repository;

import br.wk.projeto.bancosangue.model.TipoSanguineo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TipoSanguineoRepository extends JpaRepository<TipoSanguineo, Long> {

    TipoSanguineo findByCodigo(String codigo);
}
