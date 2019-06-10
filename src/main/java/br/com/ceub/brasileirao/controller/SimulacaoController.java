package br.com.ceub.brasileirao.controller;

import br.com.ceub.brasileirao.model.SimulacaoRodada;
import br.com.ceub.brasileirao.service.SimulacaoRodadaService;
import br.com.ceub.brasileirao.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimulacaoController {

    @Autowired
    private TimeService timeService;

    @Autowired
    private SimulacaoRodadaService simulacaoRodadaService;

    @GetMapping("/simulacao")
    public ModelAndView simulacao(Model model){
        ModelAndView modelAndView = new ModelAndView("simulacao");
        modelAndView.addObject("times", timeService.listarTimes());
        return modelAndView;
    }

    @GetMapping("/rodada")
    public ModelAndView indexRodada(Model model) {
        ModelAndView modelAndView = new ModelAndView("rodada");
        modelAndView.addObject("times", timeService.listarTimes());
        model.addAttribute("simulacaoRodada", new SimulacaoRodada());
        return modelAndView;
    }

    @PostMapping("/simular-rodada")
    public String simularRodada(@ModelAttribute SimulacaoRodada simulacao){
        simulacaoRodadaService.simularRodada(simulacao);
        return "sucesso";
    }
}
