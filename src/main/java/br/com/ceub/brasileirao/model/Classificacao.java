package br.com.ceub.brasileirao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "TB_CLASSIFICACAO")
public class Classificacao {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "PONTOS")
    private Integer pontos;

    @Column(name = "PARTIDAS_JOGADAS")
    private Integer partidasJogadas;

    @Column(name = "VITORIAS")
    private Integer vitorias;

    @Column(name = "EMPATES")
    private Integer empates;

    @Column(name = "DERROTAS")
    private Integer derrotas;

    @Column(name = "GOLS_PRO")
    private Integer golsPro;

    @Column(name = "GOLS_CONTRA")
    private Integer golsContra;

    @Column(name = "SALDO_GOLS")
    private Integer saldoDeGols;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "time_id")
    private Time time;

}
