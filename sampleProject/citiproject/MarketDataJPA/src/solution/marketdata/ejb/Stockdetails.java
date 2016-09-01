package solution.marketdata.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the stockdetails database table.
 * 
 */
@Entity
@NamedQuery(name="Stockdetails.findAll", query="SELECT s FROM Stockdetails s")
public class Stockdetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idprices;

	private BigDecimal close;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String exchangemarket;

	private BigDecimal high;

	private BigDecimal low;

	private BigDecimal open;

	private String ticker;

	private int vol;

	public Stockdetails() {
	}

	public int getIdprices() {
		return this.idprices;
	}

	public void setIdprices(int idprices) {
		this.idprices = idprices;
	}

	public BigDecimal getClose() {
		return this.close;
	}

	public void setClose(BigDecimal close) {
		this.close = close;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.exchangemarket+this.idprices+this.ticker+this.vol+this.close+this.date+this.high+this.low+this.open;
	}

}