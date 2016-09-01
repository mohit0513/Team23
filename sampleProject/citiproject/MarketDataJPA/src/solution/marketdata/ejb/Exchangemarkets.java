package solution.marketdata.ejb;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: Exchangemarkets
 *
 */
@Entity

public class Exchangemarkets implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int idexchange;

	private String exchangemarket;

	//bi-directional many-to-one association to Coexchange
	
	@OneToMany(mappedBy="exchangemarket")
	@JsonBackReference
	private List<Coexchange> coexchanges;
	

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JsonManagedReference
	private Countries country;

	public Exchangemarkets() {
	}

	public int getIdexchange() {
		return this.idexchange;
	}

	public void setIdexchange(int idexchange) {
		this.idexchange = idexchange;
	}

	public String getExchangemarket() {
		return this.exchangemarket;
	}

	public void setExchangemarket(String exchangemarket) {
		this.exchangemarket = exchangemarket;
	}

	public List<Coexchange> getCoexchanges() {
		return this.coexchanges;
	}

	public void setCoexchanges(List<Coexchange> coexchanges) {
		this.coexchanges = coexchanges;
	}

	public Coexchange addCoexchange(Coexchange coexchange) {
		getCoexchanges().add(coexchange);
		coexchange.setExchangemarket(this);

		return coexchange;
	}

	public Coexchange removeCoexchange(Coexchange coexchange) {
		getCoexchanges().remove(coexchange);
		coexchange.setExchangemarket(null);

		return coexchange;
	}

	public Countries getCountry() {
		return this.country;
	}

	public void setCountry(Countries country) {
		this.country = country;
	}
   
}
