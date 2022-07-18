package br.com.flavianeris.recrutamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.flavianeris.recrutamento.entidades.Cliente;
import br.com.flavianeris.recrutamento.repositorios.ClienteRepository;

public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.get();
	}
}
