package solution.marketdata.ejb;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: Coexchange
 *
 */
@Entity

public class Coexchange implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int idcoexchange;
	private String ticker;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JsonManagedReference
	private Companies company;

	//bi-directional many-to-one association to Exchangemarket
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="exchange_idexchange")
	private Exchangemarkets exchangemarket;

	//bi-directional many-to-one association to Price
	@OneToMany(mappedBy="coexchange")
	@JsonBackReference
	private List<Prices> prices;
	
	public int getIdcoexchange() {
		return idcoexchange;
	}
	public void setIdcoexchange(int idcoexchange) {
		this.idcoexchange = idcoexchange;
	}

	public Coexchange() {
	}

	public String getTicker() {
		return this.ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public Companies getCompany() {
		return this.company;
	}

	public void setCompany(Companies company) {
		this.company = company;
	}

	public Exchangemarkets getExchangemarket() {
		return this.exchangemarket;
	}

	public void setExchangemarket(Exchangemarkets exchangemarket) {
		this.exchangemarket = exchangemarket;
	}

	public List<Prices> getPrices() {
		return this.prices;
	}

	public void setPrices(List<Prices> prices) {
		this.prices = prices;
	}

	public Prices addPrice(Prices price) {
		getPrices().add(price);
		price.setCoexchange(this);

		return price;
	}

	public Prices removePrice(Prices price) {
		getPrices().remove(price);
		price.setCoexchange(null);

		return price;
	}
	
}
