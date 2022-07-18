package br.com.flavianeris.recrutamento.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flavianeris.recrutamento.entidades.CandidatoInfo;
import br.com.flavianeris.recrutamento.services.CandidatoInfoService;

@RestController
@RequestMapping(value = "/candidatos/informacoes")
public class CandidatoInfoResource {

	@Autowired
	private CandidatoInfoService service;
	
	@GetMapping
	public ResponseEntity<List<CandidatoInfo>> findAll() {
		List<CandidatoInfo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CandidatoInfo> findById(@PathVariable Long id){
		CandidatoInfo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
