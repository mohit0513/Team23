package solution.marketdata.ejb;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Entity implementation class for Entity: Sector
 *
 */
@Entity

public class Sectors implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int idSector;

	private String sector;

	//bi-directional many-to-one association to Company
	@OneToMany(mappedBy="sector")
	@JsonBackReference
	private List<Companies> companies;

	public Sectors() {
	}

	public int getIdSector() {
		return this.idSector;
	}

	public void setIdSector(int idSector) {
		this.idSector = idSector;
	}

	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public List<Companies> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Companies> companies) {
		this.companies = companies;
	}

	public Companies addCompany(Companies company) {
		getCompanies().add(company);
		company.setSector(this);

		return company;
	}

	public Companies removeCompany(Companies company) {
		getCompanies().remove(company);
		company.setSector(null);

		return company;
	}
   
}
