package br.com.flavianeris.recrutamento.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.flavianeris.recrutamento.entidades.enums.CandidatoStatus;
import br.com.flavianeris.recrutamento.entidades.enums.CandidatoVagaStatus;

@Entity
public class CandidatoVaga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String observacao;
	private String status;
	private String classificacao;
	
	@ManyToOne
	@JoinColumn(name = "vaga_id")
	private Vaga vaga;
	
	@ManyToOne
	@JoinColumn(name = "candidato_id")
	private Candidato candidato;
	
	@OneToOne
	private FinalizarVaga finalizarVaga;
	
	public CandidatoVaga() {
	}

	public CandidatoVaga(Long id, String observacao, CandidatoVagaStatus status, 
			String classificacao, Vaga vaga, Candidato candidato) {
		super();
		this.id = id;
		this.observacao = observacao;
		setStatus(status);
		this.classificacao = classificacao;
		this.vaga = vaga;
		this.candidato = candidato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public CandidatoVagaStatus getStatus() {
		return CandidatoVagaStatus.valorDe(status);
	}
	
	public void setStatus(CandidatoVagaStatus status) {
		if (status != null) {
			this.status = status.getCodigo();
		}
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, candidato, vaga, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidatoVaga other = (CandidatoVaga) obj;
		return Objects.equals(id, other.id) && Objects.equals(candidato, other.candidato)
				&& Objects.equals(vaga, other.vaga) && Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return candidato.getNome();
	}
	
}
