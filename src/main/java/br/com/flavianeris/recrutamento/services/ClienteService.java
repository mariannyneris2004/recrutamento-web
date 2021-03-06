package br.com.flavianeris.recrutamento.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.flavianeris.recrutamento.entidades.Candidato;
import br.com.flavianeris.recrutamento.entidades.Cargo;
import br.com.flavianeris.recrutamento.entidades.Cliente;
import br.com.flavianeris.recrutamento.repositorios.ClienteRepository;
import br.com.flavianeris.recrutamento.services.exceptions.DatabaseException;
import br.com.flavianeris.recrutamento.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Cliente insert(Cliente obj) {
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
	
	public Cliente update(Long id, Cliente obj) {
		try {
			Cliente entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} 
	}
	
	private void updateData(Cliente entity, Cliente obj) {
		entity.setNomeCliente(obj.getNomeCliente());
		entity.setCnpj(obj.getCnpj());
		entity.setEmail(obj.getEmail());
		entity.setPreferencias(obj.getPreferencias());
		entity.setRazaoSocial(obj.getRazaoSocial());
		entity.setRestricoes(obj.getRestricoes());
		entity.setSegmentoAtuacao(obj.getSegmentoAtuacao());
		entity.setTelefone(obj.getTelefone());		
	}
}
