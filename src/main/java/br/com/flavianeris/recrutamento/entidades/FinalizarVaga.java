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

import br.com.flavianeris.recrutamento.entidades.enums.CandidatoVagaStatus;
import br.com.flavianeris.recrutamento.entidades.enums.FinalizarVagaModalidade;
import br.com.flavianeris.recrutamento.entidades.enums.FinalizarVagaStatus;

@Entity
public class FinalizarVaga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date admissao;
	private String modalidade;
	private String status;
	private String outro;
	private String observacao;
	
	private Cargo cargo;
	private Cliente cliente;
	private Vaga vaga;
	private CandidatoVaga candidatoVaga;
	
	public FinalizarVaga() {
	}
	
	public FinalizarVaga(Integer id, Vaga vaga, CandidatoVaga candidatoVaga, Date admissao,
			String modalidade, String status, String outro, String observacao) {
		super();
		this.id = id;
		this.vaga = vaga;
		this.candidatoVaga = candidatoVaga;
		this.admissao = admissao;
		this.modalidade = modalidade;
		this.status = status;
		this.outro = outro;
		this.observacao = observacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		return "VagasFinalizadas [vaga=" + vaga + ", candidatoVaga=" + candidatoVaga + ", admissao=" + admissao + ", modalidade=" + modalidade + ", status=" + status + "]";
	}
	
}