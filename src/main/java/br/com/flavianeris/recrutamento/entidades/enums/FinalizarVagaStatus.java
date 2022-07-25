package br.com.flavianeris.recrutamento.entidades.enums;

public enum FinalizarVagaStatus {

	DESLIGADO1("Desligado no primeiro contrato"),
	DESLIGADOFIM("Desligado no fim do período de experiência"),
	EFETIVADO("Efetivado");
	
	private String codigo;
	
	private FinalizarVagaStatus(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo(){
		return codigo;
	}
	
	public static FinalizarVagaStatus valorDe(String codigo) {
		for (FinalizarVagaStatus value : FinalizarVagaStatus.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido. finalizarVagaStatus");
	}
}
