package br.com.flavianeris.recrutamento.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flavianeris.recrutamento.entidades.Vaga;

@RestController
@RequestMapping(value = "/vagas")
public class VagaResource {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@GetMapping
	public ResponseEntity<Vaga> findAll() throws ParseException{
		Vaga v = new Vaga(1L, "Título vaga", "Requisitos - teste", sdf.parse("01/07/2022"), 
				sdf.parse("30/07/2022"), "2000", "Benefícios - teste", "200H", "8H", 
				"Periculosidade", "Insalubridade", "Descrição - teste", null, null);
		return ResponseEntity.ok().body(v);
	}
}
