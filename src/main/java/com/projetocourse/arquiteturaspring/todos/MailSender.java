package com.projetocourse.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void enviar(String message){
        System.out.println("Enviado email " + message);
    }
}
