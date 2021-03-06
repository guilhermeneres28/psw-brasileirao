package br.com.ceub.brasileirao.controller;

import br.com.ceub.brasileirao.repository.TimeRepository;
import br.com.ceub.brasileirao.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClassificacaoController {

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private TimeService timeService;

    @GetMapping("/classificacao")
    public ModelAndView classificacao() {
        ModelAndView modelAndView = new ModelAndView("classificacao");
        modelAndView.addObject("times", timeRepository.findAll());
        return modelAndView;
    }
}
