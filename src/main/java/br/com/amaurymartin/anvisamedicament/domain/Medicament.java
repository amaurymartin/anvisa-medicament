package br.com.amaurymartin.anvisamedicament.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;;

@Entity
@Table(name = "meds")
public class Medicament implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_med")
	private Integer id;
	
	@Column(name = "tx_princ_ativo", columnDefinition = "text", nullable = false)
	private String tx_princ_ativo;
	
	@Column(name = "tx_cnpj", columnDefinition = "text", nullable = false)
	private String tx_cnpj;
	
	@Column(name = "tx_lab", columnDefinition = "text", nullable = false)
	private String tx_lab;
	
	@Column(name = "cd_ggrem", columnDefinition = "text", nullable = false)
	private String cd_ggrem;
	
	@Column(name = "cd_reg", columnDefinition = "text", nullable = false)
	private String cd_reg;
	
	@Column(name = "cd_ean", columnDefinition = "text", nullable = false)
	private String cd_ean;
	
	@Column(name = "tx_prod", columnDefinition = "text", nullable = false)
	private String tx_prod;
	
	@Column(name = "tx_conc", columnDefinition = "text", nullable = false)
	private String tx_conc;
	
	@Column(name = "tx_forma_farma", columnDefinition = "text", nullable = false)
	private String tx_forma_farma;
	
	@Column(name = "tx_apres", columnDefinition = "text", nullable = false)
	private String tx_apres;
	
	@Column(name = "tx_class_terap", columnDefinition = "text", nullable = false)
	private String tx_class_terap;
	
	@Column(name = "tx_tipo_prod", columnDefinition = "text", nullable = false)
	private String tx_tipo_prod;
	
	@Column(name = "bl_restr_hosp", nullable = false)
	private Boolean bl_restr_hosp;
	
	@Column(name = "bl_comerc", nullable = true)
	private Boolean bl_comerc;
	
	@Column(name = "tx_tarja", columnDefinition = "text", nullable = false)
	private String tx_tarja;
	
	public Medicament() {
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public Medicament setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getTx_princ_ativo() {
		return tx_princ_ativo;
	}
	
	public Medicament setTx_princ_ativo(String tx_princ_ativo) {
		this.tx_princ_ativo = tx_princ_ativo;
		return this;
	}
	
	public String getTx_cnpj() {
		return tx_cnpj;
	}
	
	public Medicament setTx_cnpj(String tx_cnpj) {
		this.tx_cnpj = tx_cnpj;
		return this;
	}
	
	public String getTx_lab() {
		return tx_lab;
	}
	
	public Medicament setTx_lab(String tx_lab) {
		this.tx_lab = tx_lab;
		return this;
	}
	
	public String getCd_ggrem() {
		return cd_ggrem;
	}
	
	public Medicament setCd_ggrem(String cd_ggrem) {
		this.cd_ggrem = cd_ggrem;
		return this;
	}
	
	public String getCd_reg() {
		return cd_reg;
	}
	
	public Medicament setCd_reg(String cd_reg) {
		this.cd_reg = cd_reg;
		return this;
	}
	
	public String getCd_ean() {
		return cd_ean;
	}
	
	public Medicament setCd_ean(String cd_ean) {
		this.cd_ean = cd_ean;
		return this;
	}
	
	public String getTx_prod() {
		return tx_prod;
	}
	
	public Medicament setTx_prod(String tx_prod) {
		this.tx_prod = tx_prod;
		return this;
	}
	
	public String getTx_conc() {
		return tx_conc;
	}
	
	public Medicament setTx_conc(String tx_conc) {
		this.tx_conc = tx_conc;
		return this;
	}
	
	public String getTx_forma_farma() {
		return tx_forma_farma;
	}
	
	public Medicament setTx_forma_farma(String tx_forma_farma) {
		this.tx_forma_farma = tx_forma_farma;
		return this;
	}
	
	public String getTx_apres() {
		return tx_apres;
	}
	
	public Medicament setTx_apres(String tx_apres) {
		this.tx_apres = tx_apres;
		return this;
	}
	
	public String getTx_class_terap() {
		return tx_class_terap;
	}
	
	public Medicament setTx_class_terap(String tx_class_terap) {
		this.tx_class_terap = tx_class_terap;
		return this;
	}
	
	public String getTx_tipo_prod() {
		return tx_tipo_prod;
	}
	
	public Medicament setTx_tipo_prod(String tx_tipo_prod) {
		this.tx_tipo_prod = tx_tipo_prod;
		return this;
	}
	
	public Boolean getBl_restr_hosp() {
		return bl_restr_hosp;
	}
	
	public Medicament setBl_restr_hosp(Boolean bl_restr_hosp) {
		this.bl_restr_hosp = bl_restr_hosp;
		return this;
	}
	
	public Boolean getBl_comerc() {
		return bl_comerc;
	}
	
	public void setBl_comerc(Boolean bl_comerc) {
		this.bl_comerc = bl_comerc;
	}
	
	public String getTx_tarja() {
		return tx_tarja;
	}
	
	public Medicament setTx_tarja(String tx_tarja) {
		this.tx_tarja = tx_tarja;
		return this;
	}
	
	public String getProdWithConc() {
		return getTx_prod() != null && getTx_conc() != null ? getTx_prod() + " - " + getTx_conc() : "";
	}
	
	@Override
	public String toString() {
		return "Medicament [id=" + id + ", tx_princ_ativo=" + tx_princ_ativo + ", tx_cnpj=" + tx_cnpj + ", tx_lab="
				+ tx_lab + ", cd_ggrem=" + cd_ggrem + ", cd_reg=" + cd_reg + ", cd_ean=" + cd_ean + ", tx_prod="
				+ tx_prod + ", tx_conc=" + tx_conc + ", tx_forma_farma=" + tx_forma_farma + ", tx_apres=" + tx_apres
				+ ", tx_class_terap=" + tx_class_terap + ", tx_tipo_prod=" + tx_tipo_prod + ", bl_restr_hosp="
				+ bl_restr_hosp + ", bl_comerc=" + bl_comerc + ", tx_tarja=" + tx_tarja + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bl_comerc == null) ? 0 : bl_comerc.hashCode());
		result = prime * result + ((bl_restr_hosp == null) ? 0 : bl_restr_hosp.hashCode());
		result = prime * result + ((cd_ean == null) ? 0 : cd_ean.hashCode());
		result = prime * result + ((cd_ggrem == null) ? 0 : cd_ggrem.hashCode());
		result = prime * result + ((cd_reg == null) ? 0 : cd_reg.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tx_apres == null) ? 0 : tx_apres.hashCode());
		result = prime * result + ((tx_class_terap == null) ? 0 : tx_class_terap.hashCode());
		result = prime * result + ((tx_cnpj == null) ? 0 : tx_cnpj.hashCode());
		result = prime * result + ((tx_conc == null) ? 0 : tx_conc.hashCode());
		result = prime * result + ((tx_forma_farma == null) ? 0 : tx_forma_farma.hashCode());
		result = prime * result + ((tx_lab == null) ? 0 : tx_lab.hashCode());
		result = prime * result + ((tx_princ_ativo == null) ? 0 : tx_princ_ativo.hashCode());
		result = prime * result + ((tx_prod == null) ? 0 : tx_prod.hashCode());
		result = prime * result + ((tx_tarja == null) ? 0 : tx_tarja.hashCode());
		result = prime * result + ((tx_tipo_prod == null) ? 0 : tx_tipo_prod.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicament other = (Medicament) obj;
		if (bl_comerc == null) {
			if (other.bl_comerc != null)
				return false;
		} else if (!bl_comerc.equals(other.bl_comerc))
			return false;
		if (bl_restr_hosp == null) {
			if (other.bl_restr_hosp != null)
				return false;
		} else if (!bl_restr_hosp.equals(other.bl_restr_hosp))
			return false;
		if (cd_ean == null) {
			if (other.cd_ean != null)
				return false;
		} else if (!cd_ean.equals(other.cd_ean))
			return false;
		if (cd_ggrem == null) {
			if (other.cd_ggrem != null)
				return false;
		} else if (!cd_ggrem.equals(other.cd_ggrem))
			return false;
		if (cd_reg == null) {
			if (other.cd_reg != null)
				return false;
		} else if (!cd_reg.equals(other.cd_reg))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tx_apres == null) {
			if (other.tx_apres != null)
				return false;
		} else if (!tx_apres.equals(other.tx_apres))
			return false;
		if (tx_class_terap == null) {
			if (other.tx_class_terap != null)
				return false;
		} else if (!tx_class_terap.equals(other.tx_class_terap))
			return false;
		if (tx_cnpj == null) {
			if (other.tx_cnpj != null)
				return false;
		} else if (!tx_cnpj.equals(other.tx_cnpj))
			return false;
		if (tx_conc == null) {
			if (other.tx_conc != null)
				return false;
		} else if (!tx_conc.equals(other.tx_conc))
			return false;
		if (tx_forma_farma == null) {
			if (other.tx_forma_farma != null)
				return false;
		} else if (!tx_forma_farma.equals(other.tx_forma_farma))
			return false;
		if (tx_lab == null) {
			if (other.tx_lab != null)
				return false;
		} else if (!tx_lab.equals(other.tx_lab))
			return false;
		if (tx_princ_ativo == null) {
			if (other.tx_princ_ativo != null)
				return false;
		} else if (!tx_princ_ativo.equals(other.tx_princ_ativo))
			return false;
		if (tx_prod == null) {
			if (other.tx_prod != null)
				return false;
		} else if (!tx_prod.equals(other.tx_prod))
			return false;
		if (tx_tarja == null) {
			if (other.tx_tarja != null)
				return false;
		} else if (!tx_tarja.equals(other.tx_tarja))
			return false;
		if (tx_tipo_prod == null) {
			if (other.tx_tipo_prod != null)
				return false;
		} else if (!tx_tipo_prod.equals(other.tx_tipo_prod))
			return false;
		return true;
	}
	
}
