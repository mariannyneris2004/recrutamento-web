package br.com.flavianeris.recrutamento.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.flavianeris.recrutamento.entidades.Candidato;
import br.com.flavianeris.recrutamento.entidades.CandidatoInfo;
import br.com.flavianeris.recrutamento.entidades.CandidatoVaga;
import br.com.flavianeris.recrutamento.entidades.Cargo;
import br.com.flavianeris.recrutamento.entidades.Cliente;
import br.com.flavianeris.recrutamento.entidades.FinalizarVaga;
import br.com.flavianeris.recrutamento.entidades.Vaga;
import br.com.flavianeris.recrutamento.entidades.enums.CandidatoCNH;
import br.com.flavianeris.recrutamento.entidades.enums.CandidatoGenero;
import br.com.flavianeris.recrutamento.entidades.enums.CandidatoInfoTipo;
import br.com.flavianeris.recrutamento.entidades.enums.CandidatoStatus;
import br.com.flavianeris.recrutamento.entidades.enums.CandidatoVagaStatus;
import br.com.flavianeris.recrutamento.entidades.enums.FinalizarVagaModalidade;
import br.com.flavianeris.recrutamento.entidades.enums.FinalizarVagaStatus;
import br.com.flavianeris.recrutamento.repositorios.CandidatoInfoRepository;
import br.com.flavianeris.recrutamento.repositorios.CandidatoRepository;
import br.com.flavianeris.recrutamento.repositorios.CandidatoVagaRepository;
import br.com.flavianeris.recrutamento.repositorios.CargoRepository;
import br.com.flavianeris.recrutamento.repositorios.ClienteRepository;
import br.com.flavianeris.recrutamento.repositorios.FinalizarVagaRepository;
import br.com.flavianeris.recrutamento.repositorios.VagaRepository;

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
	
	@Autowired
	private CandidatoVagaRepository cvRepository;
	
	@Autowired
	private VagaRepository vagaRepository;
	
	@Autowired
	private FinalizarVagaRepository finalizarRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Candidato candidato1 = new Candidato(null, "Mary", sdf.parse("16/08/2004"), "984562004",
				"985104522", "rua 14, n273A, st Luzia", CandidatoCNH.NÃOPOSSUI,
				"mary@gmail.com", "teste", CandidatoStatus.ATIVO, CandidatoGenero.NÃODECLARAR);
	
		Candidato candidato2 = new Candidato(null, "Wender", sdf.parse("06/01/1983"), "985464250",
				"985104522", "rua 14, n273A, st Luzia", CandidatoCNH.B,
				"wender@gmail.com", "teste", CandidatoStatus.ATIVO, CandidatoGenero.MASCULINO);
		
		candidatoRepository.saveAll(Arrays.asList(candidato1, candidato2));
		
		Cargo cargo1 = new Cargo(null, "teste", "Teste Cargo 1", "curso 1, curso 2", "1234567");
		
		Cargo cargo2 = new Cargo(null, "teste 2", "Teste Cargo 2", "curso 3, curso 4", "7654321");
		
		cargoRepository.saveAll(Arrays.asList(cargo1, cargo2));
		
		Cliente cliente1 = new Cliente(null, "Flávia Neris", "Flávia", "1234567", 
				"RH", "nenhuma", "nenhuma", "985104522", "flavia@gmail.com");
		
		clienteRepository.saveAll(Arrays.asList(cliente1));
		
		CandidatoInfo ci1 = new CandidatoInfo(candidato2, null, CandidatoInfoTipo.FORMAÇÃO, "2020", "2022",
				"Ensino médio", cargo2);
		
		ciRepository.saveAll(Arrays.asList(ci1));
		
		Vaga vaga1 = new Vaga(null, "Título vaga", "Requisitos - teste", 
				sdf.parse("01/07/2022"), sdf.parse("30/07/2022"), "2000", 
				"Benefícios - teste", "200H", "8H", "Periculosidade", "Insalubridade", 
				"Descrição - teste", null, null);
		
		vagaRepository.saveAll(Arrays.asList(vaga1));
		
		CandidatoVaga cv1 = new CandidatoVaga(null, "Observação - teste", 
				CandidatoVagaStatus.ANÁLISE, "Classificação - teste", null, null);
		
		cvRepository.saveAll(Arrays.asList(cv1));
		
		FinalizarVaga finalizar1 = new FinalizarVaga(null, null, null, 
				sdf.parse("14/07/2022"), FinalizarVagaModalidade.QUARENTAECINCO, 
				FinalizarVagaStatus.EFETIVADO, "", "teste");
		
		finalizarRepository.saveAll(Arrays.asList(finalizar1));
	}
}
