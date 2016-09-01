package solution.marketdata.ejb;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: Company
 *
 */
@Entity
public class Companies implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int idcompany;
	private String company;
	@OneToMany(mappedBy = "company")
	@JsonBackReference
	private List<Coexchange> coexchanges;
	
	@ManyToOne
	@JsonManagedReference
	private Sectors sector;
	
	public Companies(){
	}

	public int getIdcompany() {
		return idcompany;
	}

	public void setIdcompany(int idcompany) {
		this.idcompany = idcompany;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<Coexchange> getCoexchanges() {
		return coexchanges;
	}

	public void setCoexchanges(List<Coexchange> coexchanges) {
		this.coexchanges = coexchanges;
	}

	public Coexchange addCoexchange(Coexchange coexchange) {
		getCoexchanges().add(coexchange);
		coexchange.setCompany(this);

		return coexchange;
	}

	public Coexchange removeCoexchange(Coexchange coexchange) {
		getCoexchanges().remove(coexchange);
		coexchange.setCompany(null);

		return coexchange;
	}

	public Sectors getSector() {
		return this.sector;
	}

	public void setSector(Sectors sector) {
		this.sector = sector;
	}
	
}
