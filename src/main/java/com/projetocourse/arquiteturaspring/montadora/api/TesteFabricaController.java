package com.projetocourse.arquiteturaspring.montadora.api;

import com.projetocourse.arquiteturaspring.montadora.CarroStatus;
import com.projetocourse.arquiteturaspring.montadora.Chave;
import com.projetocourse.arquiteturaspring.montadora.HondaHRV;
import com.projetocourse.arquiteturaspring.montadora.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/carros")
public class TesteFabricaController {

    @Autowired
    @Eletrico
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave){
        var carro = new HondaHRV(motor);
        return carro.darIgnicao(chave);
    }
}
