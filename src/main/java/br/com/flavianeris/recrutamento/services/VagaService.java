package br.com.flavianeris.recrutamento.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.flavianeris.recrutamento.entidades.FinalizarVaga;
import br.com.flavianeris.recrutamento.entidades.Vaga;
import br.com.flavianeris.recrutamento.repositorios.VagaRepository;
import br.com.flavianeris.recrutamento.services.exceptions.DatabaseException;
import br.com.flavianeris.recrutamento.services.exceptions.ResourceNotFoundException;

@Service
public class VagaService {

	@Autowired
	private VagaRepository repository;
	
	public List<Vaga> findAll(){
		return repository.findAll();
	}
	
	public Vaga findById(Long id) {
		Optional<Vaga> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Vaga insert(Vaga obj) {
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
	
	public Vaga update(Long id, Vaga obj) {
		try {
			Vaga entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Vaga entity, Vaga obj) {
		entity.setTitulo(obj.getTitulo());
		entity.setBeneficios(obj.getBeneficios());
		entity.setCargaHoraria(obj.getCargaHoraria());
		entity.setCargo(obj.getCargo());
		entity.setCliente(obj.getCliente());
		entity.setDataFinal(obj.getDataFinal());
		entity.setDataInicial(obj.getDataInicial());
		entity.setDescricao(obj.getDescricao());
		entity.setInsalubridade(obj.getInsalubridade());
		entity.setJornadaTrabalho(obj.getJornadaTrabalho());
		entity.setPericulosidade(obj.getPericulosidade());
		entity.setRequisitos(obj.getRequisitos());
		entity.setSalario(obj.getSalario());
	}
}
