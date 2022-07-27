package br.com.flavianeris.recrutamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flavianeris.recrutamento.entidades.Candidato;
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
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Cargo update(Long id, Cargo obj) {
		Cargo entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Cargo entity, Cargo obj) {
		entity.setTitulo(obj.getTitulo());
		entity.setDescricao(obj.getDescricao());
		entity.setCursos(obj.getCursos());
		entity.setCbo(obj.getCbo());
		
	}
}
