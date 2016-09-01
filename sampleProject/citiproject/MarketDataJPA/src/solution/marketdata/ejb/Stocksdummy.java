package solution.marketdata.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the stocksdummy database table.
 * 
 */
@Entity
@NamedQuery(name="Stocksdummy.findAll", query="SELECT s FROM Stocksdummy s")
public class Stocksdummy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idStocks;

	private BigDecimal close;

	private String company;

	private String country;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String exchangemarket;

	private BigDecimal high;

	private int idcoexchange;

	private BigDecimal low;

	private BigDecimal open;

	private String region;

	private String sector;

	private String ticker;

	private int vol;

	public Stocksdummy() {
	}

	public int getIdStocks() {
		return this.idStocks;
	}

	public void setIdStocks(int idStocks) {
		this.idStocks = idStocks;
	}

	public BigDecimal getClose() {
		return this.close;
	}

	public void setClose(BigDecimal close) {
		this.close = close;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getExchangemarket() {
		return this.exchangemarket;
	}

	public void setExchangemarket(String exchangemarket) {
		this.exchangemarket = exchangemarket;
	}

	public BigDecimal getHigh() {
		return this.high;
	}

	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	public int getIdcoexchange() {
		return this.idcoexchange;
	}

	public void setIdcoexchange(int idcoexchange) {
		this.idcoexchange = idcoexchange;
	}

	public BigDecimal getLow() {
		return this.low;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}

	public BigDecimal getOpen() {
		return this.open;
	}

	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getTicker() {
		return this.ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public int getVol() {
		return this.vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}

}