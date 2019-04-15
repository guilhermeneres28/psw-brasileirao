package br.com.ceub.brasileirao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassificacaoController {

    @GetMapping("/classificacao")
    public String classificacao() {
        return "classificacao";
    }
}
