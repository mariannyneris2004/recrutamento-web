package br.com.flavianeris.recrutamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flavianeris.recrutamento.entidades.Candidato;
import br.com.flavianeris.recrutamento.entidades.FinalizarVaga;
import br.com.flavianeris.recrutamento.repositorios.FinalizarVagaRepository;
import br.com.flavianeris.recrutamento.services.exceptions.ResourceNotFoundException;

@Service
public class FinalizarVagaService {

	@Autowired
	private FinalizarVagaRepository repository;
	
	public List<FinalizarVaga> findAll(){
		return repository.findAll();
	}
	
	public FinalizarVaga findById(Long id) {
		Optional<FinalizarVaga> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public FinalizarVaga insert(FinalizarVaga obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
