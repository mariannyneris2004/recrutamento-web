package br.com.flavianeris.recrutamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flavianeris.recrutamento.entidades.CandidatoVaga;
import br.com.flavianeris.recrutamento.repositorios.CandidatoVagaRepository;
import br.com.flavianeris.recrutamento.services.exceptions.ResourceNotFoundException;

@Service
public class CandidatoVagaService {

	@Autowired
	private CandidatoVagaRepository repository;

	public List<CandidatoVaga> findAll() {
		return repository.findAll();
	}

	public CandidatoVaga findById(Long id) {
		Optional<CandidatoVaga> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public CandidatoVaga insert(CandidatoVaga obj) {
		return repository.save(obj);
	}
}
