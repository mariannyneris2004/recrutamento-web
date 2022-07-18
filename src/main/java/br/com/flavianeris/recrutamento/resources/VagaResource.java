package br.com.flavianeris.recrutamento.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flavianeris.recrutamento.entidades.Vaga;
import br.com.flavianeris.recrutamento.services.VagaService;

@RestController
@RequestMapping(value = "/vagas")
public class VagaResource {
	
	@Autowired
	private VagaService service;
	
	@GetMapping
	public ResponseEntity<List<Vaga>> findAll() {
		List<Vaga> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Vaga> findById(@PathVariable Long id){
		Vaga obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
