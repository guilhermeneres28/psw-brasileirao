package br.com.ceub.brasileirao.service;

import br.com.ceub.brasileirao.model.SimulacaoRodada;
import br.com.ceub.brasileirao.model.Time;
import br.com.ceub.brasileirao.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimulacaoRodadaService {

    @Autowired
    private TimeService timeService;

    public void simularRodada(SimulacaoRodada simulacao){
        Time primeiroTime = timeService.buscarTimePeloId(simulacao.getPrimeiroTime().getId());
        Time segundoTime = timeService.buscarTimePeloId(simulacao.getSegundoTime().getId());

        atualizaSaldoDeGols(simulacao);

        atualizarPartidasJogadas(simulacao);

        primeiroTime.setGolsContra(primeiroTime.getGolsContra() + simulacao.getGolsSegundoTime());
        segundoTime.setGolsContra(segundoTime.getGolsContra() + simulacao.getGolsPrimeiroTime());
        primeiroTime.setGolsPro(primeiroTime.getGolsPro() + simulacao.getGolsPrimeiroTime());
        segundoTime.setGolsPro(segundoTime.getGolsPro() + simulacao.getGolsSegundoTime());

        if(simulacao.getGolsPrimeiroTime() > simulacao.getGolsSegundoTime()) {
            vitoriaTime1(primeiroTime, segundoTime);
        } else if(simulacao.getGolsSegundoTime() > simulacao.getGolsPrimeiroTime()) {
            vitoriaTime2(primeiroTime, segundoTime);
        } else {
            empate(primeiroTime, segundoTime);
        }
    }

    private void atualizaSaldoDeGols(SimulacaoRodada simulacaoRodada){
        simulacaoRodada.getPrimeiroTime().setSaldoDeGols(
                simulacaoRodada.getPrimeiroTime().getSaldoDeGols() + simulacaoRodada.getGolsPrimeiroTime());

        simulacaoRodada.getSegundoTime().setSaldoDeGols(
                simulacaoRodada.getSegundoTime().getSaldoDeGols() + simulacaoRodada.getGolsSegundoTime());
    }

    private void atualizarPartidasJogadas(SimulacaoRodada simulacaoRodada) {
        simulacaoRodada.getPrimeiroTime().setPartidasJogadas(simulacaoRodada.getPrimeiroTime().getPartidasJogadas() + 1);
        simulacaoRodada.getSegundoTime().setPartidasJogadas(simulacaoRodada.getSegundoTime().getPartidasJogadas() + 1);
    }

    private void vitoriaTime1(Time primeiroTime, Time segundoTime) {
        primeiroTime.setVitorias(primeiroTime.getVitorias() + 1);
        segundoTime.setDerrotas(segundoTime.getDerrotas() + 1);
        primeiroTime.setPontos(primeiroTime.getPontos() + 3);

        persistirTimes(primeiroTime, segundoTime);
    }

    private void vitoriaTime2(Time primeiroTime, Time segundoTime) {
        segundoTime.setVitorias(segundoTime.getVitorias() + 1);
        primeiroTime.setDerrotas(primeiroTime.getDerrotas() + 1);
        segundoTime.setPontos(primeiroTime.getPontos() + 3);

        persistirTimes(primeiroTime, segundoTime);
    }

    private void empate(Time primeiroTime, Time segundoTime) {
        primeiroTime.setEmpates(primeiroTime.getEmpates() + 1);
        segundoTime.setEmpates(segundoTime.getEmpates() + 1);
        primeiroTime.setPontos(primeiroTime.getPontos() + 1);
        segundoTime.setPontos(segundoTime.getPontos() + 1);

        persistirTimes(primeiroTime, segundoTime);
    }

    private void persistirTimes(Time primeiroTime, Time segundoTime) {
        timeService.atualizarTime(primeiroTime);
        timeService.atualizarTime(segundoTime);
    }
}
