package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosEpisodioRecord;
import br.com.alura.screenmatch.model.DadosSerieRecord;
import br.com.alura.screenmatch.model.DadosTemporadaRecord;
import br.com.alura.screenmatch.service.ConsumoApiService;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var consumoApi = new ConsumoApiService();

		ConverteDados conversor = new ConverteDados();

		//Fazendo uma requisição para a api que retorna os dados da série Gilmore Girls
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);

		//Desserializando os dados da série
		DadosSerieRecord dadosSerie = conversor.obterDados(json, DadosSerieRecord.class);
		System.out.println(dadosSerie);

		//Fazendo uma requisição para a api que retorna os dados de um episódio específico da série Gilmore Girls
		json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
		System.out.println(json);

		//Desserializando os dados do episódio
		DadosEpisodioRecord dadosEpisodio = conversor.obterDados(json, DadosEpisodioRecord.class);
		System.out.println(dadosEpisodio);

		//Desserializando os dados das temporadas - Percorrendo todas as temporadas
		List<DadosTemporadaRecord> temporadas = new ArrayList<>();

		for(int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
			json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=6585022c");
			DadosTemporadaRecord dadosTemporada = conversor.obterDados(json, DadosTemporadaRecord.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);
	}
}
