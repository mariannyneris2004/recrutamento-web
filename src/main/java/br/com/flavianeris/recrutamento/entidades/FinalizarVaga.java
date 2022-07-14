package br.com.flavianeris.recrutamento.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	@OneToOne
	@JoinColumn(name = "vaga_id")
	private Vaga vaga;
	
	@OneToOne
	@JoinColumn(name = "candidato_vaga_id")
	private CandidatoVaga candidatoVaga;

	public FinalizarVaga() {
	}

	public FinalizarVaga(Long id, Vaga vaga, CandidatoVaga candidatoVaga, Date admissao, FinalizarVagaModalidade modalidade,
			FinalizarVagaStatus status, String outro, String observacao) {
		super();
		this.id = id;
		this.vaga = vaga;
		this.candidatoVaga = candidatoVaga;
		this.admissao = admissao;
		setModalidade(modalidade);
		setStatus(status);
		this.outro = outro;
		this.observacao = observacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
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

	public FinalizarVagaModalidade getModalidade() {
		return FinalizarVagaModalidade.valorDe(modalidade);
	}

	public void setModalidade(FinalizarVagaModalidade modalidade) {
		if (modalidade != null) {
			this.modalidade = modalidade.getCodigo();
		}
	}

	public FinalizarVagaStatus getStatus() {
		return FinalizarVagaStatus.valorDe(status);
	}

	public void setStatus(FinalizarVagaStatus status) {
		if (status != null) {
			this.status = status.getCodigo();
		}
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
		return "VagasFinalizadas [vaga=" + vaga + ", candidatoVaga=" + candidatoVaga + ", admissao=" + admissao
				+ ", modalidade=" + modalidade + ", status=" + status + "]";
	}

}
