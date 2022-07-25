package br.com.flavianeris.recrutamento.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.flavianeris.recrutamento.entidades.CandidatoVaga;
import br.com.flavianeris.recrutamento.services.CandidatoVagaService;

@RestController
@RequestMapping(value = "/vagas/candidatos")
public class CandidatoVagaResource {

	@Autowired
	private CandidatoVagaService service;
	
	@GetMapping
	public ResponseEntity<List<CandidatoVaga>> findAll() {
		List<CandidatoVaga> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CandidatoVaga> findById(@PathVariable Long id){
		CandidatoVaga obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<CandidatoVaga> insert(@RequestBody CandidatoVaga obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
