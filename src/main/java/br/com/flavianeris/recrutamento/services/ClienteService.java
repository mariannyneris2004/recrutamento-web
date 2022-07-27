package br.com.flavianeris.recrutamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flavianeris.recrutamento.entidades.Candidato;
import br.com.flavianeris.recrutamento.entidades.Cliente;
import br.com.flavianeris.recrutamento.repositorios.ClienteRepository;
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
		repository.deleteById(id);
	}
	
	public Cliente update(Long id, Cliente obj) {
		Cliente entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
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
