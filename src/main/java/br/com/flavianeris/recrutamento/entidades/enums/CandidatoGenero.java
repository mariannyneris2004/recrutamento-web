package br.com.flavianeris.recrutamento.entidades.enums;

public enum CandidatoGenero {

	FEMININO("Feminino"),
	MASCULINO("Masculino"),
	NÃOBINÁRIO("Não-Binário"),
	NÃODECLARAR("Não declarar");
	
	private String codigo;
	
	private CandidatoGenero(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo(){
		return codigo;
	}
	
	public static CandidatoGenero valorDe(String codigo) {
		for (CandidatoGenero value : CandidatoGenero.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido. genero");
	}
}
