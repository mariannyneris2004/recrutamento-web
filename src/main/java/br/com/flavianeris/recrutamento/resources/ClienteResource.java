package br.com.flavianeris.recrutamento.resources;

import java.text.ParseException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flavianeris.recrutamento.entidades.Cliente;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@GetMapping
	public ResponseEntity<Cliente> findAll() throws ParseException{
		Cliente c = new Cliente(1L, "Flávia Neris", "Flávia", "1234567", 
				"RH", "nenhuma", "nenhuma", "985104522", "flavia@gmail.com");
		return ResponseEntity.ok().body(c);
	}
}
