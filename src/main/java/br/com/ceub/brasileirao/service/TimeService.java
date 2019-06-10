package br.com.ceub.brasileirao.service;

import br.com.ceub.brasileirao.model.Time;
import br.com.ceub.brasileirao.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public List<Time> listarTimes(){
        return timeRepository.findAll(Sort.by(Sort.Direction.DESC, "pontos", "saldoDeGols"));
    }

    public Time buscarTimePeloId(Long id){
        return timeRepository.findById(id).get();
    }

    public void atualizarTime(Time time) {
        timeRepository.saveAndFlush(time);
    }
}
