package solution.marketdata.ejb;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@NamedQuery(name = "Countries.findALL", query="SELECT c from Countries c")
public class Countries implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private int idCountry;

	private String country;

	//bi-directional many-to-one association to Region
	@ManyToOne
	@JsonManagedReference
	private Regions region;

	//bi-directional many-to-one association to Exchangemarket
	@OneToMany(mappedBy="country")
	@JsonBackReference
	private List<Exchangemarkets> exchangemarkets;
    
	public Countries() {
	}

	public int getIdCountry() {
		return this.idCountry;
	}

	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Regions getRegion() {
		return this.region;
	}

	public void setRegion(Regions region) {
		this.region = region;
	}

	public List<Exchangemarkets> getExchangemarkets() {
		return this.exchangemarkets;
	}

	public void setExchangemarkets(List<Exchangemarkets> exchangemarkets) {
		this.exchangemarkets = exchangemarkets;
	}

	public Exchangemarkets addExchangemarket(Exchangemarkets exchangemarket) {
		getExchangemarkets().add(exchangemarket);
		exchangemarket.setCountry(this);

		return exchangemarket;
	}

	public Exchangemarkets removeExchangemarket(Exchangemarkets exchangemarket) {
		getExchangemarkets().remove(exchangemarket);
		exchangemarket.setCountry(null);

		return exchangemarket;
	}

}
