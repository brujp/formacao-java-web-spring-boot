package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//Desserializar (Converter Json para um objeto Java) o json retornado pela api OMBD (https://www.omdbapi.com)
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerieRecord(
        @JsonAlias("Title") String titulo,
        @JsonAlias("Genre")String genero,
        @JsonAlias("Writer")String autor,
        @JsonAlias("totalSeasons") Integer totalTemporadas,
        @JsonAlias("Ratings")List<?> avaliacao
){
}
