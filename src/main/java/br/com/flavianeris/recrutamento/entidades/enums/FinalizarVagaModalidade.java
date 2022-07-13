package br.com.flavianeris.recrutamento.entidades.enums;

public enum FinalizarVagaModalidade {

	TRINTASESSENTA("30+60"),
	QUARENTAECINCO("45+45"),
	NOVENTA("90"),
	OUTRO("Outro");
	
	private String codigo;
	
	private FinalizarVagaModalidade(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo(){
		return codigo;
	}
	
	public static CandidatoInfoTipo valorDe(String codigo) {
		for (CandidatoInfoTipo value : CandidatoInfoTipo.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido.");
	}
}
