package br.com.ceub.brasileirao.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SimulacaoRodada {

    private Time primeiroTime;
    private Time segundoTime;

    private Integer golsPrimeiroTime;
    private Integer golsSegundoTime;
}
