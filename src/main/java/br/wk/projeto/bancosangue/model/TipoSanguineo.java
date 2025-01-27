package br.wk.projeto.bancosangue.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;

import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "tiposanguineo", schema = "banco")
public class TipoSanguineo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private BigInteger id;
    @Column(name = "codigo", nullable = false, length = 255)
    private String codigo;
    @Column(name = "doar", nullable = false, length = 255)
    private String doar;
    @Column(name = "receber", nullable = false, length = 255)
    private String receber;
}
