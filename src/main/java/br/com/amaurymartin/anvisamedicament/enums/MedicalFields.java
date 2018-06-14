package br.com.amaurymartin.anvisamedicament.enums;

public enum MedicalFields {
	
	PRINCIPIO_ATIVO("PRINCÍPIO ATIVO", 0),
	CNPJ("CNPJ", 1),
	LABORATORIO("LABORATÓRIO", 2),
	CODIGO_GGREM("CÓDIGO GGREM", 3),
	REGISTRO("REGISTRO", 4),
	EAN("EAN", 5),
	PRODUTO("PRODUTO", 6),
	APRESENTACAO("APRESENTAÇÃO", 7),
	CLASSE_TERAPEUTICA("CLASSE TERAPÊUTICA", 8),
	TIPO_DE_PRODUTO("TIPO DE PRODUTO (STATUS DO PRODUTO)", 9),
	RESTRICAO_HOSPITALAR("RESTRIÇÃO HOSPITALAR", 28),
	COMERCIALIZACAO("COMERCIALIZAÇÃO", 33),
	TARJA("TARJA", 34);
	
	private String field;
	private Integer index;
	
	MedicalFields(String field, Integer index) {
		this.field = field;
		this.index = index;
	}
	
	public String getField() {
		return field;
	}
	
	public Integer getIndex() {
		return index;
	}
	
}
