package br.com.flavianeris.recrutamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.flavianeris.recrutamento.entidades.Candidato;
import br.com.flavianeris.recrutamento.repositorios.CandidatoRepository;
import br.com.flavianeris.recrutamento.services.exceptions.DatabaseException;
import br.com.flavianeris.recrutamento.services.exceptions.ResourceNotFoundException;

@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository repository;
	
	public List<Candidato> findAll(){
		return repository.findAll();
	}
	
	public Candidato findById(Long id) {
		Optional<Candidato> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Candidato insert(Candidato obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		} 
	}
	
	public Candidato update(Long id, Candidato obj) {
		Candidato entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Candidato entity, Candidato obj) {
		entity.setNome(obj.getNome());
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setTelefone(obj.getTelefone());
		entity.setTelefoneContato(obj.getTelefoneContato());
		entity.setEndereco(obj.getEndereco());
		entity.setCnh(obj.getCnh());
		entity.setEmail(obj.getEmail());
		entity.setObservacao(obj.getObservacao());
		entity.setStatus(obj.getStatus());
		entity.setGenero(obj.getGenero());
		
	}
}
