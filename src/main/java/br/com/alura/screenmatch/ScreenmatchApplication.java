package br.com.alura.screenmatch;

import br.com.alura.screenmatch.data.ConsumoAPI;
import br.com.alura.screenmatch.mapper.ConverteDados;
import br.com.alura.screenmatch.models.DadosSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoAPI();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=bb4d9b1e");
		IO.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		IO.println(dados+"ab");
	}
}
