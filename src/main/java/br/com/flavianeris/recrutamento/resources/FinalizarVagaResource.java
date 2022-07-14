package br.com.flavianeris.recrutamento.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flavianeris.recrutamento.entidades.Candidato;
import br.com.flavianeris.recrutamento.entidades.FinalizarVaga;
import br.com.flavianeris.recrutamento.entidades.enums.CandidatoCNH;
import br.com.flavianeris.recrutamento.entidades.enums.CandidatoGenero;
import br.com.flavianeris.recrutamento.entidades.enums.CandidatoStatus;
import br.com.flavianeris.recrutamento.entidades.enums.FinalizarVagaModalidade;
import br.com.flavianeris.recrutamento.entidades.enums.FinalizarVagaStatus;

@RestController
@RequestMapping(value = "/vagas/finalizar")
public class FinalizarVagaResource {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@GetMapping
	public ResponseEntity<FinalizarVaga> findAll() throws ParseException{
		FinalizarVaga fv = new FinalizarVaga(1L, null, null, sdf.parse("14/07/2022"), 
				FinalizarVagaModalidade.QUARENTAECINCO, FinalizarVagaStatus.EFETIVADO,
				"", "teste");
		return ResponseEntity.ok().body(fv);
	}
}
