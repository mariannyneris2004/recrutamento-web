package br.com.flavianeris.recrutamento.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flavianeris.recrutamento.entidades.Cargo;
import br.com.flavianeris.recrutamento.services.CargoService;

@RestController
@RequestMapping(value = "/cargos")
public class CargoResource {
	
	@Autowired
	private CargoService service;
	
	@GetMapping
	public ResponseEntity<List<Cargo>> findAll() {
		List<Cargo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cargo> findById(@PathVariable Long id){
		Cargo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
