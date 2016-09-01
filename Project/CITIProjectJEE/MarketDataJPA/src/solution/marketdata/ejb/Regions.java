package solution.marketdata.ejb;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: Region
 *
 */
@Entity
@NamedQuery(name="Regions.findAll", query="SELECT r FROM Regions r")
public class Regions implements Serializable {

	@Id
	private int idregion;
	private String regions;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="region")
	@JsonBackReference
	private List<Countries> countries;
	
	public Regions() {
	}

	public int getIdregion() {
		return this.idregion;
	}

	public void setIdregion(int idregion) {
		this.idregion = idregion;
	}

	public String getRegion() {
		return this.regions;
	}

	public void setRegion(String region) {
		this.regions = region;
	}

	public List<Countries> getCountries() {
		return this.countries;
	}

	public void setCountries(List<Countries> countries) {
		this.countries = countries;
	}

	public Countries addCountry(Countries country) {
		getCountries().add(country);
		country.setRegion(this);

		return country;
	}

	public Countries removeCountry(Countries country) {
		getCountries().remove(country);
		country.setRegion(null);

		return country;
	}
}
