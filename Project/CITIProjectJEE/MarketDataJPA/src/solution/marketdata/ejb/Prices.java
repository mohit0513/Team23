package solution.marketdata.ejb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: Price
 *
 */
@Entity

public class Prices implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int idprices;

	private BigDecimal close;

	@Temporal(TemporalType.DATE)
	private Date date;

	private BigDecimal high;

	private BigDecimal low;

	private BigDecimal open;

	private BigInteger vol;

	//bi-directional many-to-one association to Coexchange
	@ManyToOne
	@JsonManagedReference
	@JoinColumns({
		//@JoinColumn(name="coexchange_company_idcompany", referencedColumnName="company_idcompany"),
		@JoinColumn(name="coexchange_exchange_idexchange", referencedColumnName="exchange_idexchange"),
		@JoinColumn(name="coexchange_idcoexchange", referencedColumnName="idcoexchange")
		})
	private Coexchange coexchange;

	public Prices() {
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

	public BigInteger getVol() {
		return this.vol;
	}

	public void setVol(BigInteger vol) {
		this.vol = vol;
	}

	public Coexchange getCoexchange() {
		return this.coexchange;
	}

	public void setCoexchange(Coexchange coexchange) {
		this.coexchange = coexchange;
	}

   
}
