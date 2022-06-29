package br.com.flavianeris.recrutamento.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Candidato implements Serializable {
	private static final long serialVersionUID = 1L;

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

	public Candidato() {
	}

	public Candidato(Long id, String nome, Date dataNascimento, 
			String telefone, String telefoneContato, String endereco, 
			String cnh, String email, String observacao, String status, 
			String genero) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.telefoneContato = telefoneContato;
		this.endereco = endereco;
		this.cnh = cnh;
		this.email = email;
		this.observacao = observacao;
		this.status = status;
		this.genero = genero;
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
	
	public String getCnh() {
		return cnh;
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

	public String getStatus() {
		return status;
	}
	
	public String getGenero() {
		return genero;
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
	
	public static List<String> listStatus() {
		List<String> list = new ArrayList<>();
		list.add("Ativo");
		list.add("Inativo");
		list.add("Não Indicar");
		return list;
	}
	
	public static List<String> listCnh(){
		List<String> list = new ArrayList<>();
		list.add("ACC");
		list.add("Categoria A");
		list.add("Categoria B");
		list.add("Categoria C");
		list.add("Categoria D");
		list.add("Categoria E");
		return list;
	}
	
	public static List<String> listGenero(){
		List<String> list = new ArrayList<>();
		list.add("Feminino");
		list.add("Masculino");
		list.add("Não-Binário");
		list.add("Não declarar");
		return list;
	}
}
