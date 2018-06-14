package br.com.amaurymartin.anvisamedicament.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.amaurymartin.anvisamedicament.domain.Medicament;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Integer> {
	
	@Query(value = "select * from meds m where m.tx_princ_ativo like concat ('%', :tx_princ_ativo, '%')", nativeQuery = true)
    public List<Medicament> findByPrinc(@Param("tx_princ_ativo") String tx_princ_ativo);
	
	@Query(value = "select * from meds m where m.tx_cnpj=:tx_cnpj", nativeQuery = true)
    public List<Medicament> findByCnpj(@Param("tx_cnpj") String tx_cnpj);
	
	@Query(value = "select * from meds m where m.tx_lab like concat ('%', :tx_lab, '%')", nativeQuery = true)
    public List<Medicament> findByLab(@Param("tx_lab") String tx_lab);
	
	@Query(value = "select * from meds m where m.cd_ggrem=:cd_ggrem", nativeQuery = true)
    public List<Medicament> findByGgrem(@Param("cd_ggrem") String cd_ggrem);
	
	@Query(value = "select * from meds m where m.cd_reg=:cd_reg", nativeQuery = true)
    public List<Medicament> findByReg(@Param("cd_reg") String cd_reg);
	
	@Query(value = "select * from meds m where m.cd_ean=:cd_ean", nativeQuery = true)
    public List<Medicament> findByEan(@Param("cd_ean") String cd_ean);
	
	@Query(value = "select * from meds m where m.tx_prod like concat ('%', :tx_prod, '%')", nativeQuery = true)
    public List<Medicament> findByProd(@Param("tx_prod") String tx_prod);
	
	@Query(value = "select * from meds m where m.tx_conc like concat ('%', :tx_conc, '%')", nativeQuery = true)
    public List<Medicament> findByConc(@Param("tx_conc") String tx_conc);
	
	@Query(value = "select * from meds m where m.tx_forma_farma like concat ('%', :tx_forma_farma, '%')", nativeQuery = true)
    public List<Medicament> findByForma(@Param("tx_forma_farma") String tx_forma_farma);
	
	@Query(value = "select * from meds m where m.tx_apres like concat ('%', :tx_apres, '%')", nativeQuery = true)
    public List<Medicament> findByApres(@Param("tx_apres") String tx_apres);
	
	@Query(value = "select * from meds m where m.tx_class_terap like concat ('%', :tx_class_terap, '%')", nativeQuery = true)
    public List<Medicament> findByClassTerap(@Param("tx_class_terap") String tx_class_terap);
	
	@Query(value = "select * from meds m where m.tx_tipo_prod like concat ('%', :tx_tipo_prod, '%')", nativeQuery = true)
    public List<Medicament> findByTipoProd(@Param("tx_tipo_prod") String tx_tipo_prod);
	
	@Query(value = "select * from meds m where m.bl_restr_hosp=:bl_restr_hosp", nativeQuery = true)
    public List<Medicament> findByRestrHosp(@Param("bl_restr_hosp") Boolean bl_restr_hosp);
	
	@Query(value = "select * from meds m where m.bl_comerc=:bl_comerc", nativeQuery = true)
    public List<Medicament> findByComerc(@Param("bl_comerc") Boolean bl_comerc);
	
	@Query(value = "select * from meds m where m.tx_tarja like concat ('%', :tx_tarja, '%')", nativeQuery = true)
    public List<Medicament> findByTarja(@Param("tx_tarja") String tx_tarja);
	
}
