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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.flavianeris.recrutamento.entidades.enums.CandidatoCNH;
import br.com.flavianeris.recrutamento.entidades.enums.CandidatoGenero;
import br.com.flavianeris.recrutamento.entidades.enums.CandidatoStatus;

@Entity
public class Candidato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Date dataNascimento;
	private String telefone;
	private String telefoneContato;
	private String endereco;
	private String cnh;
	private String email;
	private String observacao;
	private String status;
	private String genero;

	@JsonIgnore
	@OneToMany(mappedBy = "candidato")
	private List<CandidatoInfo> infos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidato")
	private List<CandidatoVaga> candidatosVaga = new ArrayList<>();
	
	public Candidato() {
	}

	public Candidato(Long id, String nome, Date dataNascimento, 
			String telefone, String telefoneContato, String endereco, 
			CandidatoCNH cnh, String email, String observacao, CandidatoStatus status, 
			CandidatoGenero genero) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.telefoneContato = telefoneContato;
		this.endereco = endereco;
		setCnh(cnh);
		this.email = email;
		this.observacao = observacao;
		setStatus(status);
		setGenero(genero);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public CandidatoCNH getCnh() {
		return CandidatoCNH.valorDe(cnh);
	}
	
	public void setCnh(CandidatoCNH cnh) {
		if (cnh != null) {
			this.cnh = cnh.getCodigo();
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public CandidatoStatus getStatus() {
		return CandidatoStatus.valorDe(status);
	}
	
	public void setStatus(CandidatoStatus status) {
		if (status != null) {
			this.status = status.getCodigo();
		}
	}
	
	public CandidatoGenero getGenero() {
		return CandidatoGenero.valorDe(genero);
	}
	
	public void setGenero(CandidatoGenero genero) {
		if (genero != null) {
			this.genero = genero.getCodigo();
		}
	}
	
	public void setCandidato(Candidato candidato) {
		this.setCandidato(candidato);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidato other = (Candidato) obj;
		return id == other.id && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Candidato [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", telefone="
				+ telefone + ", telefoneContato=" + telefoneContato + ", endereco=" + endereco + ", cnh=" + cnh
				+ ", email=" + email + ", observacao=" + observacao + ", status=" + status + ", genero=" + genero + "]";
	}
	
}
