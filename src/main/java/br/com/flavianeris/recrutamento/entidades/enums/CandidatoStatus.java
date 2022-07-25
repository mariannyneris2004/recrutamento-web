package br.com.flavianeris.recrutamento.entidades.enums;

public enum CandidatoStatus {

	ATIVO("Ativo"),
	INATIVO("Inativo"),
	NÃOINDICAR("Não indicar");
	
	private String codigo;
	
	private CandidatoStatus(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo(){
		return codigo;
	}
	
	public static CandidatoStatus valorDe(String codigo) {
		for (CandidatoStatus value : CandidatoStatus.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido. candidatoStatus");
	}
}
