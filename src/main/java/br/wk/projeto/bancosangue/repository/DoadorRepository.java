package br.wk.projeto.bancosangue.repository;

import br.wk.projeto.bancosangue.model.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.math.BigInteger;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, Long> {
}
