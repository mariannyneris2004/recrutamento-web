package br.com.flavianeris.recrutamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public FinalizarVaga update(Long id, FinalizarVaga obj) {
		FinalizarVaga entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(FinalizarVaga entity, FinalizarVaga obj) {
		entity.setAdmissao(obj.getAdmissao());
		entity.setCandidatoVaga(obj.getCandidatoVaga());
		entity.setModalidade(obj.getModalidade());
		entity.setOutro(obj.getOutro());
		entity.setObservacao(obj.getObservacao());
		entity.setStatus(obj.getStatus());		
	}
}
