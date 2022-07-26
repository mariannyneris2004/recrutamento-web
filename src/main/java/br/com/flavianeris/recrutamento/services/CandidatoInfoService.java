package br.com.flavianeris.recrutamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flavianeris.recrutamento.entidades.Candidato;
import br.com.flavianeris.recrutamento.entidades.CandidatoInfo;
import br.com.flavianeris.recrutamento.repositorios.CandidatoInfoRepository;
import br.com.flavianeris.recrutamento.repositorios.CandidatoRepository;
import br.com.flavianeris.recrutamento.services.exceptions.ResourceNotFoundException;

@Service
public class CandidatoInfoService {

	@Autowired
	private CandidatoInfoRepository repository;
	
	public List<CandidatoInfo> findAll(){
		return repository.findAll();
	}
	
	public CandidatoInfo findById(Long id) {
		Optional<CandidatoInfo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public CandidatoInfo insert(CandidatoInfo info) {
		return repository.save(info);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
