package br.com.amaurymartin.anvisamedicament.filereader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import br.com.amaurymartin.anvisamedicament.domain.Medicament;
import br.com.amaurymartin.anvisamedicament.enums.AnvisaDictionary;
import br.com.amaurymartin.anvisamedicament.enums.MedicalFields;

public class FileReader {
	
	//TODO: Procurar por uma nova versão da base de dados em: http://portal.anvisa.gov.br/listas-de-precos
	public static final String XLS_FILE_NAME = "/xls_conformidade_2018_05_15.xls";
	
	private List<MedicalFields> medicalFields = Arrays.asList(MedicalFields.values());
	private List<Integer> columnsIndex = new ArrayList<>();
	
	private Medicament currentMedicament;
	private List<Medicament> medicaments = new ArrayList<>();
	
	private Boolean isValidIndex = false;
	
	private Integer count = 0;
	
	public List<Medicament> readExcelFile() throws IOException, InvalidFormatException {
		this.medicalFields.forEach(field -> this.columnsIndex.add(field.getIndex()));
		
		InputStream inputStream = getClass().getResourceAsStream(XLS_FILE_NAME);
		
		Workbook workbook = WorkbookFactory.create(inputStream);
		
		Sheet sheet = workbook.getSheetAt(0);
		
		DataFormatter dataFormatter = new DataFormatter();
		
		for (Row row: sheet) {
			this.currentMedicament = null; //preparando a variável para o próximo laço
			
			if(this.isValidRow(row)) {
				this.currentMedicament = new Medicament();
				
				for(Cell cell: row) {
					Integer columnIndex = cell.getColumnIndex();
					
					if(columnsIndex.contains(columnIndex)) { //captura-se o valor da coluna caso esta seja uma das colunas de interesse
						String columnValue = dataFormatter.formatCellValue(cell);
						this.setObject(columnIndex, columnValue);
					}
				}
				
				if(currentMedicament != null) this.addObjectToList();
			}
		}
		
		System.out.println(medicaments.size() + " medicamentos foram encontrados no arquivo.");
		
		return this.medicaments;
	}
	
	public void setObject(Integer columnIndex, String columnValue) {
		switch (columnIndex) { //set dos atributos do objeto baseado no index da coluna
		case 0:
			this.currentMedicament.setTx_princ_ativo(columnValue);
			break;
		case 1:
			this.currentMedicament.setTx_cnpj(columnValue);
			break;
		case 2:
			this.currentMedicament.setTx_lab(columnValue);
			break;
		case 3:
			this.currentMedicament.setCd_ggrem(columnValue);
			break;
		case 4:
			this.currentMedicament.setCd_reg(columnValue);
			break;
		case 5:
			this.currentMedicament.setCd_ean(columnValue);
			break;
		case 6:
			this.currentMedicament.setTx_prod(columnValue);
			break;
		case 7:
			this.setApresentacao(columnValue);
			break;
		case 8:
			this.currentMedicament.setTx_class_terap(columnValue);
			break;
		case 9:
			this.currentMedicament.setTx_tipo_prod(columnValue.toUpperCase()); //padronização de todos os dados serem inseridos em CAPSLOCK no banco de dados
			break;
		case 28:
			Boolean bl_restr_hosp = this.generateBoolean(columnValue); //método criado para converter SIM e NÃO em valores booleanos
			this.currentMedicament.setBl_restr_hosp(bl_restr_hosp);
			break;
		case 33:
			Boolean bl_comerc = this.generateBoolean(columnValue);
			this.currentMedicament.setBl_comerc(bl_comerc);
			break;
		case 34:
			this.currentMedicament.setTx_tarja(columnValue.toUpperCase().replace("TARJA ", "")); //padronização de todos os dados serem inseridos em CAPSLOCK no banco de dados
			break;																				//inserir no banco apenas a cor da tarja (ou "venda livre")
		default:
			System.out.println("Abributo inválido: " + columnIndex + " : " + columnValue);
			break;
		}	
	}
	
	public void addObjectToList() {
		this.medicaments.add(this.currentMedicament);
	}
	
	public Boolean isValidRow (Row row) {
		DataFormatter dataFormatter = new DataFormatter();
		
		String regex = "(^\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}$)"; //a linha só será válida se a segunda coluna da planilha conter um CNPJ
		String cnpj = dataFormatter.formatCellValue(row.getCell(1));
		
		if(cnpj.matches(regex)) return true;
		
		return false;
	}
	
	public Boolean generateBoolean(String status) {
		List<String> yes = new ArrayList<>(Arrays.asList("SIM", "Sim", "sim"));
		List<String> no = new ArrayList<>(Arrays.asList("NÃO", "NAO", "Não", "Nao", "não", "nao"));
		
		if(yes.contains(status)) return true;
		else if(no.contains(status)) return false;
		
		return null;
	}
	
	public void setApresentacao(String txApres) {
		String tx_conc = "";
		String tx_forma_farma = "";
		
		this.currentMedicament.setTx_apres(txApres);
		this.currentMedicament.setTx_conc(tx_conc);
		this.currentMedicament.setTx_forma_farma(tx_forma_farma);
		
		Integer index = -1;
		this.isValidIndex = false; //prepara a variável para o próximo laço
		
		while(!this.isValidIndex) {
			if(!String.valueOf(txApres.charAt(0)).matches("\\d")) {
				this.isValidIndex = true; //verifica se o primeiro digito da coluna é um número. Esta versão da API só irá tratar as colunas que comecem com a concentração
				count++;
			}
			else index = this.getValidIndex(txApres); //caso a coluna de apresentação não comece com a concentração, as colunas de concentração e forma farmacêutica serão vazias no banco de dados
		}
		
		if(index > 0) {
			tx_conc = txApres.substring(0, index-1).trim(); //divisão da coluna de apresentação em concentração e forma farmacêutica
			tx_forma_farma = txApres.substring(index);
			
			this.currentMedicament.setTx_conc(tx_conc);
			this.currentMedicament.setTx_forma_farma(tx_forma_farma);
		}
	}
	
	private Integer getValidIndex(String txApres) {
		Integer index = 0;
		
		List<AnvisaDictionary> dictionaryEnum = Arrays.asList(AnvisaDictionary.values());
		List<String> dictionary = new ArrayList<>();
		dictionaryEnum.forEach(word -> dictionary.add(word.getInitials())); //cria um dicionário com formas farmacêuticas e outros padrões da Anvisa. Isso será utilizado para separar a concentração das demais informações na coluna de apresentação
		
		for(String word : dictionary) { //percorrendo todo o dicionário
			Integer i = txApres.indexOf(word); //index candidato a ser o ponto de separação
			
			if(i + word.length() == txApres.length()) txApres += " "; //tratamento para caso uma palavra do dicionário seja também a palavra final da coluna de apresentação
			if(i != -1) { 
				if(isAValidIndex(i, txApres.substring(0, i + word.length() + 1), word.length())) { //verifica se é um index válido
					if(index == 0 || i < index) index = i;
				}
			}
		}
		
		this.isValidIndex = true; //caso não seja encontrada nenhuma palavra do dicionário na coluna de apresentação, o index -1, a concentração e a forma farmacêutica ficarão vazias no banco de dados
		return index;
	}
	
	private Boolean isAValidIndex(Integer index, String txApres, Integer length) {
		if(index > 0 && 
				String.valueOf(txApres.charAt(index-1)).equals(" ") &&
				String.valueOf(txApres.charAt(index + length)).equals(" ")) { //algumas palavras do dicionário podem ser encontradas como substrings em outras, o que compromete a validação. Neste sentido, cria-se um filtro onde a forma farmacêutica deve está separada da concentração por espaços.
			this.isValidIndex = true;
			return true;
		} else if(index == 0) { //em alguns casos, uma palavra do dicionário pode ser a primeira palavra da coluna de apresentação, sendo assim, não haverá espaço antes dela
			this.isValidIndex = true;
			return true;
		}
		
		return false;
	}
	
}
