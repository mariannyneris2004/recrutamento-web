package br.com.flavianeris.recrutamento.entidades.enums;

public enum CandidatoVagaStatus {

	SELECIONADO("Selecionado"),
	ANÁLISE("Em análise"),
	TESTE("Em teste"),
	DESCARTADO("Descartado"),
	REENCAMINHAR("Reencaminhar");
	
	private String codigo;
	
	private CandidatoVagaStatus(String codigo) {
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
