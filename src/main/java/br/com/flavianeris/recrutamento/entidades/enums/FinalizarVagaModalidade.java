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
	
	public static FinalizarVagaModalidade valorDe(String codigo) {
		for (FinalizarVagaModalidade value : FinalizarVagaModalidade.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido.");
	}
}
