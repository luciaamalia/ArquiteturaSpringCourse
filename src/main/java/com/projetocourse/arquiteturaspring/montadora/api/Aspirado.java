package com.projetocourse.arquiteturaspring.montadora.api;

import org.springframework.beans.factory.annotation.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //anotation esta disponivel em tempo de execucao
@Target({ElementType.FIELD, ElementType.METHOD}) //a anotattion pode ser aplicada a atributos campos e métodos
@Qualifier("motorAspirado") //
public @interface Aspirado {
}
