package br.com.flavianeris.recrutamento.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.flavianeris.recrutamento.entidades.Candidato;
import br.com.flavianeris.recrutamento.entidades.CandidatoInfo;
import br.com.flavianeris.recrutamento.entidades.Cargo;
import br.com.flavianeris.recrutamento.entidades.Cliente;
import br.com.flavianeris.recrutamento.repositorios.CandidatoInfoRepository;
import br.com.flavianeris.recrutamento.repositorios.CandidatoRepository;
import br.com.flavianeris.recrutamento.repositorios.CargoRepository;
import br.com.flavianeris.recrutamento.repositorios.ClienteRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CandidatoInfoRepository ciRepository;

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
		
		Cargo cargo1 = new Cargo(null, "teste", "Teste Cargo 1", "curso 1, curso 2", "1234567");
		
		Cargo cargo2 = new Cargo(null, "teste 2", "Teste Cargo 2", "curso 3, curso 4", "7654321");
		
		cargoRepository.saveAll(Arrays.asList(cargo1, cargo2));
		
		Cliente cliente1 = new Cliente(null, "Flávia Neris", "Flávia", "1234567", 
				"RH", "nenhuma", "nenhuma", "985104522", "flavia@gmail.com");
		
		clienteRepository.saveAll(Arrays.asList(cliente1));
		
		CandidatoInfo ci1 = new CandidatoInfo(candidato2, null, "Formação", "2020", "2022",
				"Ensino médio", cargo2);
		
		ciRepository.saveAll(Arrays.asList(ci1));
	}
}
