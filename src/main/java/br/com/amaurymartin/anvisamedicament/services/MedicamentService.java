package br.com.amaurymartin.anvisamedicament.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amaurymartin.anvisamedicament.domain.Medicament;
import br.com.amaurymartin.anvisamedicament.filereader.FileReader;
import br.com.amaurymartin.anvisamedicament.repositories.MedicamentRepository;

@Service
public class MedicamentService {
	
	@Autowired
	private MedicamentRepository medicamentRepository;
	
	public Boolean insertAll() throws InvalidFormatException, IOException {
		List<Medicament> medicaments = new FileReader().readExcelFile();
		
		if(medicamentRepository.saveAll(medicaments) != null) return true;
		
		return false;
	}
	
	public Boolean deleteAll() {
		medicamentRepository.deleteAll();
		
		if(medicamentRepository.findAll().isEmpty()) return true;
		
		return false;
	}
	
	public List<Medicament> findAll() {
		List<Medicament> medicaments = medicamentRepository.findAll();
		return medicaments;
	}
	
	public Medicament findById(Integer id) {
		Optional<Medicament> medicament = medicamentRepository.findById(id);
		return medicament.orElse(null);
	}
	
	public List<Medicament> findByPrinc(String tx_princ_ativo) {
		List<Medicament> medicaments = medicamentRepository.findByPrinc(tx_princ_ativo.toUpperCase());
		
		System.out.println(medicaments.size() + " medicamentos encontrados para o filtro Princípio Ativo = " + "\"" + tx_princ_ativo + "\"");
		
		return medicaments;
	}
	
	public List<Medicament> findByCnpj(String tx_cnpj) {
		List<Medicament> medicaments = medicamentRepository.findByCnpj(this.formataCNPJ(tx_cnpj));
		
		System.out.println(medicaments.size() + " medicamentos encontrados para o filtro CNPJ = " + "\"" + tx_cnpj + "\"");
		
		return medicaments;
	}
	
	public List<Medicament> findByLab(String tx_lab) {
		List<Medicament> medicaments = medicamentRepository.findByLab(tx_lab.toUpperCase());
		
		System.out.println(medicaments.size() + " medicamentos encontrados para o filtro Laboratório = " + "\"" + tx_lab + "\"");
		
		return medicaments;
	}
	
	public List<Medicament> findByGgrem(String cd_ggrem) {
		List<Medicament> medicaments = medicamentRepository.findByGgrem(cd_ggrem);
		
		System.out.println(medicaments.size() + " medicamentos encontrados para o filtro Código GGREM = " + "\"" + cd_ggrem + "\"");
		
		return medicaments;
	}
	
	public List<Medicament> findByReg(String cd_reg) {
		List<Medicament> medicaments = medicamentRepository.findByReg(cd_reg);
		
		System.out.println(medicaments.size() + " medicamentos encontrados para o filtro Número do Registro = " + "\"" + cd_reg + "\"");
		
		return medicaments;
	}
	
	public List<Medicament> findByEan(String cd_ean) {
		List<Medicament> medicaments = medicamentRepository.findByEan(cd_ean);
		
		System.out.println(medicaments.size() + " medicamentos encontrados para o filtro Código EAN = " + "\"" + cd_ean + "\"");
		
		return medicaments;
	}
	
	public List<Medicament> findByProd(String tx_prod) {
		List<Medicament> medicaments = medicamentRepository.findByProd(tx_prod.toUpperCase());
		
		System.out.println(medicaments.size() + " medicamentos encontrados para o filtro nome do Produto = " + "\"" + tx_prod + "\"");
		
		return medicaments;
	}
	
	public List<Medicament> findByConc(String tx_conc) {
		List<Medicament> medicaments = medicamentRepository.findByConc(tx_conc.toUpperCase().replace(".", "/"));
		
		System.out.println(medicaments.size() + " medicamentos encontrados para o filtro Concentração = " + "\"" + tx_conc.replace(".", "/") + "\"");
		
		return medicaments;
	}
	
	public List<Medicament> findByForma(String tx_forma_farma) {
		List<Medicament> medicaments = medicamentRepository.findByForma(tx_forma_farma.toUpperCase());
		
		System.out.println(medicaments.size() + " medicamentos encontrados para o filtro Forma Farmacêutica = " + "\"" + tx_forma_farma + "\"");
		
		return medicaments;
	}
	
	public List<Medicament> findByApres(String tx_apres) {
		List<Medicament> medicaments = medicamentRepository.findByApres(tx_apres.toUpperCase());
		
		System.out.println(medicaments.size() + " medicamentos encontrados para o filtro Apresentação = " + "\"" + tx_apres + "\"");
		
		return medicaments;
	}
	
	public List<Medicament> findByClassTerap(String tx_class_terap) {
		List<Medicament> medicaments = medicamentRepository.findByClassTerap(tx_class_terap.toUpperCase());
		
		System.out.println(medicaments.size() + " medicamentos encontrados para o filtro Classe Terapêutica = " + "\"" + tx_class_terap + "\"");
		
		return medicaments;
	}
	
	public List<Medicament> findByTipoProd(String tx_tipo_prod) {
		List<Medicament> medicaments = medicamentRepository.findByTipoProd(tx_tipo_prod.toUpperCase());
		
		System.out.println(medicaments.size() + " medicamentos encontrados para o filtro Tipo de Produto = " + "\"" + tx_tipo_prod + "\"");
		
		return medicaments;
	}
	
	public List<Medicament> findByRestrHosp(Boolean bl_restr_hosp) {
		List<Medicament> medicaments = medicamentRepository.findByRestrHosp(bl_restr_hosp);
		
		System.out.println(medicaments.size() + " medicamentos encontrados para o filtro Restrição Hospitalar = " + "\"" + bl_restr_hosp + "\"");
		
		return medicaments;
	}
	
	public List<Medicament> findByComerc(Boolean bl_comerc) {
		List<Medicament> medicaments = medicamentRepository.findByComerc(bl_comerc);
		
		System.out.println(medicaments.size() + " medicamentos encontrados para o filtro Comercialização = " + "\"" + bl_comerc + "\"");
		
		return medicaments;
	}
	
	public List<Medicament> findByTarja(String tx_tarja) {
		List<Medicament> medicaments = medicamentRepository.findByTarja(tx_tarja.toUpperCase());
		
		System.out.println(medicaments.size() + " medicamentos encontrados para o filtro Tarja = " + "\"" + tx_tarja + "\"");
		
		return medicaments;
	}
	
	private String formataCNPJ(String cnpj) {
		String wwtidfisc = "";
		
		wwtidfisc = cnpj.substring(0, 2) + ".";
		wwtidfisc += cnpj.substring(2, 5) + ".";
		wwtidfisc += cnpj.substring(5, 8) + "/";
		wwtidfisc += cnpj.substring(8, 12) + "-";
		wwtidfisc += cnpj.substring(12, 14);
		
		cnpj = wwtidfisc;
		
		return cnpj;
	}
	
}
