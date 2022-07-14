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
	
	public static CandidatoVagaStatus valorDe(String codigo) {
		for (CandidatoVagaStatus value : CandidatoVagaStatus.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido.");
	}
}
