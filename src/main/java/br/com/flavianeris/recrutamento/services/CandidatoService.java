package br.com.flavianeris.recrutamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.flavianeris.recrutamento.entidades.Candidato;
import br.com.flavianeris.recrutamento.repositorios.CandidatoRepository;

public class CandidatoService {

	@Autowired
	private CandidatoRepository repository;
	
	public List<Candidato> findAll(){
		return repository.findAll();
	}
	
	public Candidato findById(Long id) {
		Optional<Candidato> obj = repository.findById(id);
		return obj.get();
	}
}
