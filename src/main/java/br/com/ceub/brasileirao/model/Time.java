package br.com.ceub.brasileirao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "TB_TIME")
public class Time {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @OneToOne(mappedBy = "TB_TIME",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Classificacao classificacao;
}
