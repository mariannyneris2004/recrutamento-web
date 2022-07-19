package br.com.flavianeris.recrutamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flavianeris.recrutamento.entidades.CandidatoVaga;
import br.com.flavianeris.recrutamento.repositorios.CandidatoVagaRepository;

@Service
public class CandidatoVagaService {

	@Autowired
	private CandidatoVagaRepository repository;

	public List<CandidatoVaga> findAll() {
		return repository.findAll();
	}

	public CandidatoVaga findById(Long id) {
		Optional<CandidatoVaga> obj = repository.findById(id);
		return obj.get();
	}
}
