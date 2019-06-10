package br.com.ceub.brasileirao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "TB_TIME")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String nome;

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

    @Column(name = "IMAGEM_TIME")
    private String imagem;
}
