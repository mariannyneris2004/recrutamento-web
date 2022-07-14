package br.com.flavianeris.recrutamento.resources;

import java.text.ParseException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flavianeris.recrutamento.entidades.CandidatoInfo;
import br.com.flavianeris.recrutamento.entidades.enums.CandidatoInfoTipo;

@RestController
@RequestMapping(value = "/candidatos/informacoes")
public class CandidatoInfoResource {

	@GetMapping
	public ResponseEntity<CandidatoInfo> findAll() throws ParseException{
		CandidatoInfo ci = new CandidatoInfo(null, 1L, CandidatoInfoTipo.FORMAÇÃO, 
				"2020", "2022", "Ensino médio", null);
		return ResponseEntity.ok().body(ci);
	}
}
