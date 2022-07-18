package br.com.flavianeris.recrutamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.flavianeris.recrutamento.entidades.FinalizarVaga;
import br.com.flavianeris.recrutamento.repositorios.FinalizarVagaRepository;

public class FinalizarVagaService {

	@Autowired
	private FinalizarVagaRepository repository;
	
	public List<FinalizarVaga> findAll(){
		return repository.findAll();
	}
	
	public FinalizarVaga findById(Long id) {
		Optional<FinalizarVaga> obj = repository.findById(id);
		return obj.get();
	}
}
