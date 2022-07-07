package br.com.flavianeris.recrutamento.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flavianeris.recrutamento.entidades.Candidato;

@RestController
@RequestMapping(value = "/candidatos")
public class CandidatoResource {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@GetMapping
	public ResponseEntity<Candidato> findAll() throws ParseException{
		Candidato c = new Candidato(null, "Mary", sdf.parse("16/08/2004"), "984562004",
				"985104522", "rua 14, n273A, st Luzia", "Não possui",
				"mary@gmail.com", "teste", "ativo", "não declarar");
		return ResponseEntity.ok().body(c);
	}
}
