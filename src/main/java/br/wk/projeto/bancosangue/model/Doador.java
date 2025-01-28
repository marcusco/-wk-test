package br.wk.projeto.bancosangue.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "doador", schema = "banco", uniqueConstraints={@UniqueConstraint(columnNames={"cpf"})})
public class Doador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;
    @Column(name = "cpf", nullable = false, length = 255)
    private String cpf;
    @Column(name = "rg", nullable = false, length = 255)
    private String rg;
    @Column(name = "datanascimento", nullable = false)
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private LocalDate dataNascimento;
    @Column(name = "sexo", nullable = false)
    private String sexo;
    @Column(name = "mae", nullable = false, length = 255)
    private String mae;
    @Column(name = "pai", nullable = true, length = 255)
    private String pai;
    @Column(name = "email", nullable = true)
    private String email;
    @Column(name = "cep", nullable = true, length = 9)
    private String cep;
    @Column(name = "endereco", nullable = true, length = 255)
    private String endereco;
    @Column(name = "bairro", nullable = true, length = 255)
    private String bairro;
    @Column(name = "cidade", nullable = true, length = 255)
    private String cidade;
    @Column(name = "estado", nullable = true, length = 255)
    private String estado;
    @Column(name = "telefonefixo", nullable = true, length = 255)
    private String telefoneFixo;
    @Column(name = "celular", nullable = true, length = 255)
    private String celular;
    @Column(name = "idtiposanguineo", nullable = true, length = 255)
    private Long idTipoSanguineo;
    @Column(name = "peso")
    private Double peso;
    @Column(name = "altura")
    private Double altura;

}

