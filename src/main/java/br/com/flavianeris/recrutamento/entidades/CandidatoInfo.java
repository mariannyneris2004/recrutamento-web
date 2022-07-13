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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.flavianeris.recrutamento.entidades.enums.CandidatoInfoTipo;

@Entity
public class CandidatoInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	private String anoInicial = "";
	private String anoFinal = "";
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "candidato_id")
	private Candidato candidato;
	
	@ManyToOne
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;
	
	public CandidatoInfo() {
	}

	public CandidatoInfo(Candidato candidato,Long id, CandidatoInfoTipo tipo, String anoInicial, 
			String anoFinal, String descricao, Cargo cargo) {
		this.candidato = candidato;
		this.id = id;
		setTipo(tipo);
		this.anoInicial = anoInicial;
		this.anoFinal = anoFinal;
		this.descricao = descricao;
		this.cargo = cargo;
	}

	public CandidatoInfoTipo getTipo() {
		return CandidatoInfoTipo.valorDe(tipo);
	}
	
	public void setTipo(CandidatoInfoTipo tipo) {
		if (tipo != null) {
			this.tipo = tipo.getCodigo();
		}
	}
	
	public String getAnoInicial() {
		return anoInicial;
	}
	
	public void setAnoInicial(String anoInicial) {
		this.anoInicial = anoInicial;
	}
	
	public String getAnoFinal() {
		return anoFinal;
	}
	
	public void setAnoFinal(String anoFinal) {
		this.anoFinal = anoFinal;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Candidato getCandidato() {
		return candidato;
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidatoInfo other = (CandidatoInfo) obj;
		return Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return "CandidatoInfo [tipo=" + tipo + ", anoInicial=" + anoInicial + ", anoFinal=" + anoFinal + ", descricao="
				+ descricao + ", candidato=" + candidato.getNome() + ", cargo=" + cargo.getTitulo() + "]";
	}
	
}

