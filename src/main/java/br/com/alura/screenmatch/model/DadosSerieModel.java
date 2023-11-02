package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

//Desserializar (Ler) o json retornado pela api OMBD (https://www.omdbapi.com)
public record DadosSerieModel(
        @JsonAlias("Title") String tituloSerie,
        @JsonAlias("Genre")String generoSerie,
        @JsonAlias("Writer")String autorSerie,
        @JsonAlias("Ratings")String avaliacaoSerie) {
}