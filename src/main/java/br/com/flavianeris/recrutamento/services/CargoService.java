package br.com.flavianeris.recrutamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flavianeris.recrutamento.entidades.Cargo;
import br.com.flavianeris.recrutamento.repositorios.CargoRepository;
import br.com.flavianeris.recrutamento.services.exceptions.ResourceNotFoundException;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;
	
	public List<Cargo> findAll(){
		return repository.findAll();
	}
	
	public Cargo findById(Long id) {
		Optional<Cargo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Cargo insert(Cargo obj) {
		return repository.save(obj);
	}
}
