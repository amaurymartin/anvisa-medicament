package br.com.amaurymartin.anvisamedicament.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.amaurymartin.anvisamedicament.domain.Medicament;
import br.com.amaurymartin.anvisamedicament.services.MedicamentService;

@RestController
@RequestMapping(value = "/meds")
public class MedicamentResource {
	
	@Autowired
	private MedicamentService medicamentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Medicament> listAll() {
		return medicamentService.findAll();
	}
	
	@RequestMapping(value = "/princ/{tx_princ_ativo}", method = RequestMethod.GET)
	public List<Medicament> findfindByPrinc(@PathVariable String tx_princ_ativo) {
		List<Medicament> medicaments = medicamentService.findByPrinc(tx_princ_ativo);
		
		return medicaments;
	}
	
	@RequestMapping(value = "/cnpj/{tx_cnpj}", method = RequestMethod.GET)
	public List<Medicament> findByCnpj(@PathVariable String tx_cnpj) {
		List<Medicament> medicaments = medicamentService.findByCnpj(tx_cnpj);
		
		return medicaments;
	}
	
	@RequestMapping(value = "/lab/{tx_lab}", method = RequestMethod.GET)
	public List<Medicament> findByLab(@PathVariable String tx_lab) {
		List<Medicament> medicaments = medicamentService.findByLab(tx_lab);
		
		return medicaments;
	}
	
	@RequestMapping(value = "/ggrem/{cd_ggrem}", method = RequestMethod.GET)
	public List<Medicament> findByGgrem(@PathVariable String cd_ggrem) {
		List<Medicament> medicaments = medicamentService.findByGgrem(cd_ggrem);
		
		return medicaments;
	}
	
	@RequestMapping(value = "/reg/{cd_reg}", method = RequestMethod.GET)
	public List<Medicament> findByReg(@PathVariable String cd_reg) {
		List<Medicament> medicaments = medicamentService.findByReg(cd_reg);
		
		return medicaments;
	}
	
	@RequestMapping(value = "/ean/{cd_ean}", method = RequestMethod.GET)
	public List<Medicament> findByEan(@PathVariable String cd_ean) {
		List<Medicament> medicaments = medicamentService.findByEan(cd_ean);
		
		return medicaments;
	}
	
	@RequestMapping(value = "/prod/{tx_prod}", method = RequestMethod.GET)
	public List<Medicament> findByProd(@PathVariable String tx_prod) {
		List<Medicament> medicaments = medicamentService.findByProd(tx_prod);
		
		return medicaments;
	}
	
	@RequestMapping(value = "/conc/{tx_conc}", method = RequestMethod.GET)
	public List<Medicament> findByConc(@PathVariable String tx_conc) {
		List<Medicament> medicaments = medicamentService.findByConc(tx_conc);
		
		return medicaments;
	}
	
	@RequestMapping(value = "/forma/{tx_forma_farma}", method = RequestMethod.GET)
	public List<Medicament> findByForma(@PathVariable String tx_forma_farma) {
		List<Medicament> medicaments = medicamentService.findByForma(tx_forma_farma);
		
		return medicaments;
	}
	
	@RequestMapping(value = "/apres/{tx_apres}", method = RequestMethod.GET)
	public List<Medicament> findByApres(@PathVariable String tx_apres) {
		List<Medicament> medicaments = medicamentService.findByApres(tx_apres);
		
		return medicaments;
	}
	
	@RequestMapping(value = "/class/{tx_class_terap}", method = RequestMethod.GET)
	public List<Medicament> findByClassTerap(@PathVariable String tx_class_terap) {
		List<Medicament> medicaments = medicamentService.findByClassTerap(tx_class_terap);
		
		return medicaments;
	}
	
	@RequestMapping(value = "/tipo/{tx_tipo_prod}", method = RequestMethod.GET)
	public List<Medicament> findByTipoProd(@PathVariable String tx_tipo_prod) {
		List<Medicament> medicaments = medicamentService.findByTipoProd(tx_tipo_prod);
		
		return medicaments;
	}
	
	@RequestMapping(value = "/rest/{bl_restr_hosp}", method = RequestMethod.GET)
	public List<Medicament> findByRestrHosp(@PathVariable Boolean bl_restr_hosp) {
		List<Medicament> medicaments = medicamentService.findByRestrHosp(bl_restr_hosp);
		
		return medicaments;
	}
	
	@RequestMapping(value = "/	/{bl_comerc}", method = RequestMethod.GET)
	public List<Medicament> findByTipoProd(@PathVariable Boolean bl_comerc) {
		List<Medicament> medicaments = medicamentService.findByComerc(bl_comerc);
		
		return medicaments;
	}
	
	@RequestMapping(value = "/tarja/{tx_tarja}", method = RequestMethod.GET)
	public List<Medicament> findByTarja(@PathVariable String tx_tarja) {
		List<Medicament> medicaments = medicamentService.findByTarja(tx_tarja);
		
		return medicaments;
	}
	
}
