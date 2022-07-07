package br.com.flavianeris.recrutamento.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.flavianeris.recrutamento.entidades.Candidato;
import br.com.flavianeris.recrutamento.repositorios.CandidatoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private CandidatoRepository candidatoRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Candidato candidato1 = new Candidato(null, "Mary", sdf.parse("16/08/2004"), "984562004",
				"985104522", "rua 14, n273A, st Luzia", "Não possui",
				"mary@gmail.com", "teste", "ativo", "não declarar");
	
		Candidato candidato2 = new Candidato(null, "Wender", sdf.parse("06/01/1983"), "985464250",
				"985104522", "rua 14, n273A, st Luzia", "AB",
				"wender@gmail.com", "teste", "ativo", "masculino");
		
		candidatoRepository.saveAll(Arrays.asList(candidato1, candidato2));
	}
}
