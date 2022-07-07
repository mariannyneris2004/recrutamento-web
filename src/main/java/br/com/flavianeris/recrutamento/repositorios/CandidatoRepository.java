package br.com.flavianeris.recrutamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.flavianeris.recrutamento.entidades.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long>{

}
