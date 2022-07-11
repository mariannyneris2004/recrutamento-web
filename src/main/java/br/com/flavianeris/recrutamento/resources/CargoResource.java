package br.com.flavianeris.recrutamento.resources;

import java.text.ParseException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flavianeris.recrutamento.entidades.Cargo;

@RestController
@RequestMapping(value = "/cargos")
public class CargoResource {
	
	@GetMapping
	public ResponseEntity<Cargo> findAll() throws ParseException{
		Cargo c = new Cargo(1L, "teste", "Teste", "curso 1, curso 2", "1234567");
		return ResponseEntity.ok().body(c);
	}
}
