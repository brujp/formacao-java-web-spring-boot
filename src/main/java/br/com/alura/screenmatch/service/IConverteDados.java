package br.com.alura.screenmatch.service;

public interface IConverteDados {

    //Utilizamos Generics pois não sabemos ainda o retorno que vamos querer
    <T> T obterDados(String json, Class<T> classe);
}
