package br.com.flavianeris.recrutamento.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeCliente = "";
	private String razaoSocial = "";
	private String cnpj = "";
	private String segmentoAtuacao = "";
	private String restricoes = "";
	private String preferencias = "";
	private String telefone = "";
	private String email = "";
	
	@OneToMany(mappedBy = "cliente")
	private List<Vaga> vagas = new ArrayList<>();
	
	public Cliente() {
	}

	public Cliente(Long id, String nomeCliente, String razaoSocial, String cnpj, String segmentoAtuacao,
			String restricoes, String preferencias, String telefone, String email) {
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.segmentoAtuacao = segmentoAtuacao;
		this.restricoes = restricoes;
		this.preferencias = preferencias;
		this.telefone = telefone;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSegmentoAtuacao() {
		return segmentoAtuacao;
	}

	public void setSegmentoAtuacao(String segmentoAtuacao) {
		this.segmentoAtuacao = segmentoAtuacao;
	}

	public String getRestricoes() {
		return restricoes;
	}

	public void setRestricoes(String restricoes) {
		this.restricoes = restricoes;
	}

	public String getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(String preferencias) {
		this.preferencias = preferencias;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nomeCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(nomeCliente, other.nomeCliente) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return nomeCliente;
	}
}