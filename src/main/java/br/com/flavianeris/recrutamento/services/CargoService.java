package br.com.flavianeris.recrutamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.flavianeris.recrutamento.entidades.Cargo;
import br.com.flavianeris.recrutamento.repositorios.CargoRepository;

public class CargoService {

	@Autowired
	private CargoRepository repository;
	
	public List<Cargo> findAll(){
		return repository.findAll();
	}
	
	public Cargo findById(Long id) {
		Optional<Cargo> obj = repository.findById(id);
		return obj.get();
	}
}