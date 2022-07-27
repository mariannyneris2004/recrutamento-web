package br.com.flavianeris.recrutamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flavianeris.recrutamento.entidades.Vaga;
import br.com.flavianeris.recrutamento.repositorios.VagaRepository;
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
		repository.deleteById(id);
	}
	
	public Vaga update(Long id, Vaga obj) {
		Vaga entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
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
