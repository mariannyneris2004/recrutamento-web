package br.com.flavianeris.recrutamento.entidades.enums;

public enum CandidatoInfoTipo {

	CURSOTREINAMENTO("Curso/Treinamento"),
	FORMAÇÃO("Formação"),
	EXPERIÊNCIA("Experiência"),
	OBJETIVO("Objetivo"),
	RESTRIÇÕES("Restrições");
	
	private String codigo;
	
	private CandidatoInfoTipo(String codigo) {
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
		throw new IllegalArgumentException("Código inválido. tipo");
	}
}
