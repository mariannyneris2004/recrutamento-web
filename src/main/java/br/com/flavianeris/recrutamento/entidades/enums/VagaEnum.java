package br.com.flavianeris.recrutamento.entidades.enums;

public enum VagaEnum {

	SIM("Sim"),
	NÃO("Não");
	
	private String codigo;
	
	private VagaEnum(String codigo) {
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
