package br.com.flavianeris.recrutamento.entidades.enums;

public enum CandidatoCNH {

	ACC("ACC"),
	A("Categoria A"),
	B("Categoria B"),
	C("Categoria C"),
	D("Categoria D"),
	E("Categoria E"),
	NÃOPOSSUI("Não possui");
	
	private String codigo;
	
	private CandidatoCNH(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo(){
		return codigo;
	}
	
	public static String toString(CandidatoCNH cnh) {
		return cnh.getCodigo();
	}
	
	public static CandidatoCNH valorDe(String codigo) {
		for (CandidatoCNH value : CandidatoCNH.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido. cnh");
	}
}
