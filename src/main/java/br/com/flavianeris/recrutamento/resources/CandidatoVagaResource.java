package br.com.flavianeris.recrutamento.resources;

import java.text.ParseException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flavianeris.recrutamento.entidades.CandidatoVaga;
import br.com.flavianeris.recrutamento.entidades.enums.CandidatoVagaStatus;

@RestController
@RequestMapping(value = "/vagas/candidatos")
public class CandidatoVagaResource {

	@GetMapping
	public ResponseEntity<CandidatoVaga> findAll() throws ParseException{
		CandidatoVaga cv = new CandidatoVaga(1L, "Observação - teste", 
				CandidatoVagaStatus.ANÁLISE, "Classificação - teste", null, null);
		return ResponseEntity.ok().body(cv);
	}
}
