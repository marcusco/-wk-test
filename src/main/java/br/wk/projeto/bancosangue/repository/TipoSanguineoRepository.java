package br.wk.projeto.bancosangue.repository;

import br.wk.projeto.bancosangue.model.TipoSanguineo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface TipoSanguineoRepository extends JpaRepository<TipoSanguineo, BigInteger> {
}
