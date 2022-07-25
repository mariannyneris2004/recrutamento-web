package br.com.flavianeris.recrutamento.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import br.com.flavianeris.recrutamento.entidades.enums.CandidatoVagaStatus;
import br.com.flavianeris.recrutamento.entidades.enums.FinalizarVagaModalidade;
import br.com.flavianeris.recrutamento.entidades.enums.FinalizarVagaStatus;

@Entity
public class FinalizarVaga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date admissao;
	private String modalidade;
	private String status;
	private String outro;
	private String observacao;

	@OneToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name = "candidato_vaga_id")
	private CandidatoVaga candidatoVaga;

	public FinalizarVaga() {
	}

	public FinalizarVaga(Long id, CandidatoVaga candidatoVaga, Date admissao, 
			String modalidade,String status, String outro, 
			String observacao) {
		super();
		this.id = id;
		this.candidatoVaga = candidatoVaga;
		this.admissao = admissao;
		this.modalidade = modalidade;
		this.status = status;
		this.outro = outro;
		this.observacao = observacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CandidatoVaga getCandidatoVaga() {
		return candidatoVaga;
	}

	public void setCandidatoVaga(CandidatoVaga candidatoVaga) {
		this.candidatoVaga = candidatoVaga;
	}

	public Date getAdmissao() {
		return admissao;
	}

	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOutro() {
		return outro;
	}

	public void setOutro(String outro) {
		this.outro = outro;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(candidatoVaga);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FinalizarVaga other = (FinalizarVaga) obj;
		return Objects.equals(candidatoVaga, other.candidatoVaga);
	}

	@Override
	public String toString() {
		return "VagasFinalizadas [vaga=" + candidatoVaga.getId() + ", candidatoVaga=" + candidatoVaga + ", admissao=" + admissao
				+ ", modalidade=" + modalidade + ", status=" + status + "]";
	}

}
