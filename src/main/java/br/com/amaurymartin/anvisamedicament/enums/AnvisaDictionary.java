package br.com.amaurymartin.anvisamedicament.enums;

public enum AnvisaDictionary {
	
	//Forma sólida
	ADESIVO("ADES"),
	ADS("ADS"), //fora do padrão
	ANEL("ANEL"),
	BARRA("BAR"),
	BASTAO("BAST"),
	CAPSULA("CAP"),
	CAPSULAS("CAPS"), //fora do padrão
	MICRO_CAPSULA("MICROCAP"), //fora do padrão
	COMPRIMIDO("COM"),
	COMP("COMP"), //fora do padrão
	MICRO_COMPRIMIDO("MICROCOM"), //fora do padrão
	DIU("DIU"),
	FILME("FIL"),
	GLOBULO("GLOB"),
	GOMA("GOMA"),
	GRANULADO("GRAN"),
	IMPL("IMPL"), //implante
	IMPLANTE("IMPLANTE"),
	PASTILHA("PAST"),
	PAS("PAS"), //fora do padrão
	PO("PO"),
	PO_COM_ACENTO("PÓ"), //fora do padrão
	RASURA("RAS"),
	SABONETE("SAB"),
	SUPOSITORIO("SUP"),
	OVULO("OVL"),
	TABLETE("TABLE"),
	
	//Forma líquida
	EMULSAO("EMU"),
	EMULSAO_L("EMUL"), //fora do padrão
	EMULSAO_A("EMULSÃO"), //fora do padrão
	ESMALTE("ESM"),
	ESMALT("ESMALT"), //fora do padrão
	ESPUMA("ESP"),
	LIQUIDO("LIQ"),
	OLEO("OLE"),
	COLUTORIO("COLUT"),
	ELX("ELX"), //elixir
	ELIXIR("ELIXIR"), //fora do padrão
	ELIX("ELIX"), //fora do padrão
	SOLUCAO("SOL"),
	SOLUCAO_PONTO("SOL."), //fora do padrão
	SUSPENSAO("SUS"),
	SUSP("SUSP"), //fora do padrão
	XAMPU("XAMP"),
	SHAMP("SHAMP"), //fora do padrão
	SHAMPOO("SHAMPOO"), //fora do padrão
	XAROPE("XPE"),
	
	//Forma semi-sólida
	CREM("CREM"), //creme
	CR("CR"), //fora do padrão
	CREME("CREME"), //fora do padrão
	EMPLASTO("EMPL"),
	GEL("GEL"),
	GL("GL"), //fora do padrão
	POMADA("POM"),
	PASTA("PAST"),
	
	//Forma gasosa
	AEROSOL("AER"),
	GAS("GAS"),
	
	//Vias de administração
	BUCAL("BUC"),
	CAPILAR("CAPI"),
	DERMATOLOGICA("DEMA"),
	EPIDURAL("EPI"),
	INALATORIA("INAL"),
	INTRA_ARTERIAL("IAR"),
	INTRA_ARTICULAR("IA"),
	INTRADERMICA("ID"),
	INTRAMUSCULAR("IM"),
	INTRATECAL("IT"),
	INTRAUTERINA("IU"),
	INTRAVENOSA("IVIT"),
	IV("IV"), //fora do padrão
	IRRIGACAO("IRR"),
	NASAL("NAS"),
	OFTALMICA("OFT"),
	OR("OR"), //oral
	ORAL("ORAL"), //fora do padrão
	OTOLOGICA("OTO"),
	RETAL("RET"),
	SUBCUTANEA("SC"),
	SUBLINGUAL("SUBL"),
	TRANSDERMICA("TRANSD"),
	URETRAL("URET"),
	VAGINAL("VAG"),
	INJETAVEL("INJ"),
	
	//Embalagens primárias
	AMPOLA("AMP"),
	APLICADOR("APLIC"),
	BISNAGA("BG"),
	BLISTER("BL"),
	BOLSA("BOLS"),
	BOMBONA("BOMB"),
	CARPULE("CAR"),
	CILINDRO("CIL"),
	ESTOJO("EST"),
	FLACONETE("FLAC"),
	FRASCO("FR"),
	FRASCO_AMPOLA("FA"),
	LAMINA("LAM"),
	POTE("PT"),
	SERINGA("SER"),
	STRIP("STR"),
	TUBO("TB"),
	
	//Embalagens secundárias
	CAIXA("CX"),
	CAIXA_PONTO("CX."), //fora do padrão
	CARTUCHO("CT"),
	ENVELOPE("ENV"),
	
	//Acessórios
	COLHER("COL"),
	
	//Análise da base
	CAPGEL("CAPGEL"), //fora do padrão
	CARTELA("CART"),
	DROGA("DRG"), //fora do padrão
	ENEMA("ENEMA"),
	GELE("GELE"), //geleia
	GELEIA("GELEIA"), //fora do padrão
	LIBERACAO("LIB"),
	LOCAO("LOC"),
	LOC("LOÇ"), //fora do padrão
	OCU("OCU"),
	PUFF("PUFF"),
	REVESTIDO("REV"),
	SPRAY("SPR");
	
	private String initials;
	
	AnvisaDictionary(String initials) {
		this.initials = initials;
	}
	
	public String getInitials() {
		return initials;
	}
	
}
