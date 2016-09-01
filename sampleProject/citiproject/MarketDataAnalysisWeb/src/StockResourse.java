import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.activemq.artemis.utils.json.JSONException;
import org.apache.activemq.artemis.utils.json.JSONObject;

import solution.marketdata.ejb.Stockdetails;
import solution.marketdata.ejb.Stocksdummy;
import solution.marketdata.ejb.MarketDataBeanLocal;

@RequestScoped
@Path("/stock")
public class StockResourse {
	private MarketDataBeanLocal bean;
	
	public StockResourse() {
		try {
			InitialContext ic = new InitialContext();
			bean = (MarketDataBeanLocal) ic.lookup("java:app/MarketDataAnalysisEJB/MarketDataBean!solution.marketdata.ejb.MarketDataBeanLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	/*@GET
	@Produces("application/json")
	public List<Prices> getAllData() {
			//return bean.test();
			//return bean.test1("AAME", "2011013000000", "2011018000000");
			//return bean.test2("20110103000000", "20110108000000");
		return bean.getSomeData();
		//return bean.getAllData();
	}*/
	
	/*@GET
	@Produces("application/json")
	public List<String> getData() {
		return bean.allCountries();
		//return bean.getAllData();
	}*/
	
	/*@GET
	@Produces("application/json")
	public List<String> getSector() {
		//return bean.allSectors();
		//return bean.getAllData();
		return bean.allExchangeMarket();
	}*/
	
	@GET
	@Produces("application/json")
	//@Path("/details")
	public List<Stockdetails> getStockDetails() {
		return bean.getAllDataa();
	}
	
	//StockResource
//by sand
	@Path("/stockhistoryver/{v1}/{v2}/{v3}/{v4}")
	@GET
	@Produces("application/json")
	public List<Stocksdummy> getHistroy_ver(@PathParam("v1") String ti, @PathParam("v2") String exm, @PathParam("v3") String d1, @PathParam("v4") String d2) {
		SimpleDateFormat x=new SimpleDateFormat("yyyyMMdd");
	   	java.util.Date s1 = null;
	   	java.util.Date s2 = null;
		try {
			s1 = x.parse(d1);
			s2 = x.parse(d2);			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean.history_ver(ti,exm,s1,s2);
	}
	
	@Path("/stockbasket/{p1}/{p2}/{q1}/{q2}/{r1}/{r2}/{s1}/{s2}/{t1}/{t2}/{v1}/{v2}/{w1}/{w2}/{w3}/{w4}/{w5}")
	@GET
	@Produces("application/json")
	public List<Stocksdummy> getBasket( @PathParam("p1") String t1, @PathParam("p2") String exm1,  
										@PathParam("q1") String t2, @PathParam("q2") String exm2,
										@PathParam("r1") String t3, @PathParam("r2") String exm3,  
										@PathParam("s1") String t4, @PathParam("s2") String exm4, 
										@PathParam("t1") String t5, @PathParam("t2") String exm5, 
										@PathParam("v1") String d1, @PathParam("v2") String d2,
										@PathParam("w1") String w1,@PathParam("w2") String w2,@PathParam("w3") String w3,@PathParam("w4") String w4,@PathParam("w5") String w5) {
		
		SimpleDateFormat x=new SimpleDateFormat("yyyyMMdd");
    	java.util.Date s1 = null;
    	java.util.Date s2 = null;
		try {
			s1 = x.parse(d1);
			s2 = x.parse(d2);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BigDecimal x1=new BigDecimal(w1);
		BigDecimal x2=new BigDecimal(w2);
		BigDecimal x3=new BigDecimal(w3);
		BigDecimal x4=new BigDecimal(w4);
		BigDecimal x5=new BigDecimal(w5);
	
		
		
		List<Stocksdummy> st1 = (List<Stocksdummy>)bean.history_ver(t1,exm1,s1,s2);
		List<Stocksdummy> st2 = (List<Stocksdummy>)bean.history_ver(t2,exm2,s1,s2);
		List<Stocksdummy> st3 = (List<Stocksdummy>)bean.history_ver(t3,exm3,s1,s2);
		List<Stocksdummy> st4 = (List<Stocksdummy>)bean.history_ver(t4,exm4,s1,s2);
		List<Stocksdummy> st5 = (List<Stocksdummy>)bean.history_ver(t5,exm5,s1,s2);
		
		List<Stocksdummy> basket = new ArrayList<Stocksdummy>();
		for (int i=0;i<st1.size();i++) {
			 
			Stocksdummy s=new Stocksdummy();
			s.setDate(st1.get(i).getDate());
			s.setIdStocks(0);
			s.setIdcoexchange(0);
			s.setTicker("basket");
			s.setCompany(null);
			s.setCountry(null);
			s.setRegion(null);
			s.setSector(null);
			s.setExchangemarket(null);
			BigDecimal j,k,l,m,n;
			j = st1.get(i).getClose();
		    k = st2.get(i).getClose();
			l = st3.get(i).getClose();
		    m = st4.get(i).getClose();
			n = st5.get(i).getClose();
			
			BigDecimal close=j.multiply(x1).add(k.multiply(x2).add(l.multiply(x3).add(m.multiply(x4).add(n.multiply(x5)))));
			s.setClose(close);

			j = st1.get(i).getOpen();
			k = st2.get(i).getOpen();
			l = st3.get(i).getOpen();
			m = st4.get(i).getOpen();
			n = st5.get(i).getOpen();
			
			BigDecimal open=j.multiply(x1).add(k.multiply(x2).add(l.multiply(x3).add(m.multiply(x4).add(n.multiply(x5)))));
			s.setOpen(open);
			
			j = st1.get(i).getLow();
			k = st1.get(i).getLow();
			l = st1.get(i).getLow();
			m = st1.get(i).getLow();
			n = st1.get(i).getLow();
			
			BigDecimal low=j.multiply(x1).add(k.multiply(x2).add(l.multiply(x3).add(m.multiply(x4).add(n.multiply(x5)))));
			s.setLow(low);
			
			j = st1.get(i).getHigh();
			k = st1.get(i).getHigh();
			l = st1.get(i).getHigh();
			m = st1.get(i).getHigh();
			n = st1.get(i).getHigh();
			
			BigDecimal high=j.multiply(x1).add(k.multiply(x2).add(l.multiply(x3).add(m.multiply(x4).add(n.multiply(x5)))));
			s.setHigh(high);
			
		    int a,b,c,d,e;
		   
			a=st1.get(i).getVol();
			b=st1.get(i).getVol();
			c=st1.get(i).getVol();
			d=st1.get(i).getVol();
			e=st1.get(i).getVol();
			
			int vol=a+b+c+d+e;
			s.setVol(vol);
			
			basket.add(s);
		}
		return basket;
	}
	
	@Path("/stocktrendingCountry/{value}/{v2}")
	@GET
	@Produces("application/json")
	public List<Stocksdummy> getmostTrending(@PathParam("value") String d, @PathParam("v2") String c) {
		System.out.println(d);
		SimpleDateFormat x=new SimpleDateFormat("yyyyMMdd");
    	java.util.Date s = null;
		try {
			s = x.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean.mostTrending(s, c);
		//return bean.mostTrending(s);
	}
	

	@Path("/stocktrendingSector/{value}/{v2}")
	@GET
	@Produces("application/json")
	public List<Stocksdummy> getmostTrendings(@PathParam("value") String d, @PathParam("v2") String c) {
		System.out.println(d);
		SimpleDateFormat x=new SimpleDateFormat("yyyyMMdd");
    	java.util.Date s = null;
		try {
			s = x.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean.mostTrendingSector(s, c);
		//return bean.mostTrending(s);
	}
	
	@Path("/stockvolatileCountry/{value}/{v}")
	@GET
	@Produces("application/json")
	public List<Stocksdummy> getVolatile(@PathParam("value") String d, @PathParam("v") String c) {
		SimpleDateFormat x=new SimpleDateFormat("yyyyMMdd");
    	java.util.Date s = null;
			try {
				s = x.parse(d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return bean.mostVolatile(s, c);
	}
	
	@Path("/stockvolatileSector/{value}/{v}")
	@GET
	@Produces("application/json")
	public List<Stocksdummy> getVolatileS(@PathParam("value") String d, @PathParam("v") String c) {
		SimpleDateFormat x=new SimpleDateFormat("yyyyMMdd");
    	java.util.Date s = null;
			try {
				s = x.parse(d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return bean.mostVolatileSector(s, c);
	}
	
	@Path("/stockgainerCountry/{value}/{v}")
	@GET
	@Produces("application/json")
	public List<Stocksdummy> getGainer(@PathParam("value") String d, @PathParam("v") String c) {
		SimpleDateFormat x=new SimpleDateFormat("yyyyMMdd");
    	java.util.Date s = null;
		try {
			s = x.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean.gainer(s, c);
	}
	
	@Path("/stockgainerSector/{value}/{v}")
	@GET
	@Produces("application/json")
	public List<Stocksdummy> getGainerSector(@PathParam("value") String d, @PathParam("v") String c) {
		SimpleDateFormat x=new SimpleDateFormat("yyyyMMdd");
    	java.util.Date s = null;
		try {
			s = x.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean.gainerSector(s, c);
	}
	
	@Path("/stockloserCountry/{value}/{v}")
	@GET
	@Produces("application/json")
	public List<Stocksdummy> getLoser(@PathParam("value") String d, @PathParam("v") String c) {
		SimpleDateFormat x=new SimpleDateFormat("yyyyMMdd");
    	java.util.Date s = null;
		try {
			s = x.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean.loser(s, c);
	}
	
	@Path("/stockloserSector/{value}/{v}")
	@GET
	@Produces("application/json")
	public List<Stocksdummy> getLoserS(@PathParam("value") String d, @PathParam("v") String c) {
		SimpleDateFormat x=new SimpleDateFormat("yyyyMMdd");
    	java.util.Date s = null;
		try {
			s = x.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean.loserSector(s, c);
	}
	
	@Path("/stockhistoryX/{v1}/{v2}/{v3}")
	@GET
	@Produces("application/json")
	public List<Stocksdummy> getHistoryX(@PathParam("v1") String ti, @PathParam("v2") String exm,@PathParam("v3") String inv) {
		return bean.historyX(ti,exm,inv);
	}
	
	@Path("/stockperformance/highest/{v1}/{v2}/{v3}/{v4}")
	@GET
	@Produces("application/json")
	public List<Stocksdummy> getPerformance_h(@PathParam("v1") String ti, @PathParam("v2") String exm, @PathParam("v3") String sdate, @PathParam("v4") String edate) {
		SimpleDateFormat x=new SimpleDateFormat("yyyyMMdd");
    	java.util.Date s1 = null;
    	java.util.Date s2 = null;
		try {
			s1 = x.parse(sdate);
			s2 = x.parse(edate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean.stockperformance_h(ti,exm, s1, s2);
	}
	
	@Path("/stockperformance/lowest/{v1}/{v2}/{v3}/{v4}")
	@GET
	@Produces("application/json")
	public List<Stocksdummy> getPerformance_l(@PathParam("v1") String ti, @PathParam("v2") String exm, @PathParam("v3") String sdate, @PathParam("v4") String edate) {
		SimpleDateFormat x=new SimpleDateFormat("yyyyMMdd");
    	java.util.Date s1 = null;
    	java.util.Date s2 = null;
		try {
			s1 = x.parse(sdate);
			s2 = x.parse(edate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean.stockperformance_l(ti,exm, s1, s2);
	}
	
	@GET
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	@Path("/search/{value}")
	public List<Stocksdummy> getSearchMarket(@PathParam("value") String ti) {
		return bean.searchMarket(ti);
	}
	
	/*@GET
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	@Path("/history/{param1}/{param2}/{param3}/{param4}")
	public Response history(@PathParam("param1") String exchangemarket, @PathParam("param2") String ticker, @PathParam("param3") String startdate, @PathParam("param4") String enddate) {
		//System.out.println(s);
		//bean.getDetails(s);
		try{
			//System.out.println(exchangemarket+ticker+startdate+enddate);
			//String s =value1+value2;
			
			List<Stocksdummy> st = (List<Stocksdummy>)bean.history(exchangemarket, ticker, startdate, enddate) ;
			System.out.println("here!!!!!");
			List<stockdump> list = new ArrayList<stockdump>();
			System.out.println(st);
			//getStockFullDetails obj = new getStockFullDetails();
			for (Stocksdummy stock:st) {
				//System.out.println("here");
				stockdump obj = new stockdump();
				obj.idStocks= stock.getIdStocks();
				obj.close = stock.getClose();
				obj.date = stock.getDate();
				obj.exchangemarket = stock.getExchangemarket();
				obj.high = stock.getClose();
				obj.low = stock.getLow();
				obj.open = stock.getOpen();
				obj.ticker = stock.getTicker();
				obj.vol = stock.getVol();
				obj.company = stock.getCompany();
				obj.country = stock.getCountry();
				obj.idcoexchange = stock.getIdcoexchange();
				obj.region = stock.getRegion();
				obj.sector = stock.getSector();
				System.out.println(obj.getExchangemarket());
				list.add(obj);
				System.out.println(obj.getCompany());
			}
			//System.out.println(list);
			return Response.status(200).entity(list).build();
		}
		catch (Exception e)
		{
			return Response.ok(false).entity("API Error!").build();
		}
	}*/

	
	@GET
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	@Path("/test/{param1}/{param2}")
	public Response test(@PathParam("param1") String value1, @PathParam("param2") String value2) {
		//System.out.println(s);
		//bean.getDetails(s);
		try{
			System.out.println(value1+value2);
			String s =value1+value2;
			List<Stockdetails> st = bean.detailsForStock(value1, value2);
			List<getStockFullDetails> list = new ArrayList<getStockFullDetails>();
			//System.out.println(list);
			//getStockFullDetails obj = new getStockFullDetails();
			for (Stockdetails stock:st) {
				//System.out.println("here");
				getStockFullDetails obj = new getStockFullDetails();
				obj.idprices= stock.getIdprices();
				obj.close = stock.getClose();
				obj.date = stock.getDate();
				obj.exchangemarket = stock.getExchangemarket();
				obj.high = stock.getClose();
				obj.low = stock.getLow();
				obj.open = stock.getOpen();
				obj.ticker = stock.getTicker();
				obj.vol = stock.getVol();
				//System.out.println(obj.getExchangemarket());
				list.add(obj);;
				//System.out.println(obj.getIdprices());
			}
			//System.out.println(list);
			return Response.status(200).entity(list).build();
		}
		catch (Exception e)
		{
			return Response.ok(false).entity("API Error!").build();
		}
	}
	
	class getStockFullDetails {
		private int idprices;
		private BigDecimal close;
		private Date date;
		private String exchangemarket;
		private BigDecimal high;
		private BigDecimal low;
		private BigDecimal open;
		private String ticker;
		private int vol;
		
		public getStockFullDetails() {
			
		}
		public getStockFullDetails(int idprices, BigDecimal close, Date date, String exchangemarket, BigDecimal high,
				BigDecimal low, BigDecimal open, String ticker, int vol) {
			super();
			this.idprices = idprices;
			this.close = close;
			this.date = date;
			this.exchangemarket = exchangemarket;
			this.high = high;
			this.low = low;
			this.open = open;
			this.ticker = ticker;
			this.vol = vol;
		}
		public int getIdprices() {
			return idprices;
		}
		public void setIdprices(int idprices) {
			this.idprices = idprices;
		}
		public BigDecimal getClose() {
			return close;
		}
		public void setClose(BigDecimal close) {
			this.close = close;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getExchangemarket() {
			return exchangemarket;
		}
		public void setExchangemarket(String exchangemarket) {
			this.exchangemarket = exchangemarket;
		}
		public BigDecimal getHigh() {
			return high;
		}
		public void setHigh(BigDecimal high) {
			this.high = high;
		}
		public BigDecimal getLow() {
			return low;
		}
		public void setLow(BigDecimal low) {
			this.low = low;
		}
		public BigDecimal getOpen() {
			return open;
		}
		public void setOpen(BigDecimal open) {
			this.open = open;
		}
		public String getTicker() {
			return ticker;
		}
		public void setTicker(String ticker) {
			this.ticker = ticker;
		}
		public int getVol() {
			return vol;
		}
		public void setVol(int vol) {
			this.vol = vol;
		}

	}
	
	class stockdump{
		private int idStocks;

		private BigDecimal close;

		private String company;

		private String country;

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

		public stockdump() {
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
	
}



