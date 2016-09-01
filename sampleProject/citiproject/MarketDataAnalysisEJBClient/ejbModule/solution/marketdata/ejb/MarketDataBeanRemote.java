package solution.marketdata.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface MarketDataBeanRemote {
	public List<Prices> getAllData();
	public List<String> allCountries();
	public List<Sectors> tickerDateChange(String ticker, int lowYear, int highYear, int lowMonth, int highMonth, int lowDay, int highDay);
	//public List<Prices> getSomeData();
	public List<Prices> getSomeData();
	public List<String> allExchangeMarket();
	public List<Stockdetails> getAllDataa();
	//public void getDetails(String s);
	public List<Stockdetails> detailsForStock(String value1,String value2);
	public List<String> detailsForStockExchange(String value1);
	public List<Stocksdummy> loser(java.util.Date d, String c);
	public List<Stocksdummy> loserSector(java.util.Date d, String c);
	public List<Stocksdummy> gainer(java.util.Date d, String c);
	public List<Stocksdummy> gainerSector(java.util.Date d, String c);
	public List<Stocksdummy> mostVolatile(java.util.Date d, String c);
	public List<Stocksdummy> mostVolatileSector(java.util.Date d, String c);
	public List<Stocksdummy> mostTrendingSector(java.util.Date d, String c);
	public List<Stocksdummy> historyX(String s1,String s2,String s4);
	public List<Stocksdummy> mostTrending(java.util.Date d, String c);
	public List<Stocksdummy> searchMarket(String s1);
	//public String stockperformance(String ti, String exm, Date d1, Date d2);
	public List<Stocksdummy> stockperformance_h(String ti, String exm, Date d1, Date d2);
	public List<Stocksdummy> stockperformance_l(String ti, String exm, Date d1, Date d2);
	 public List<Stocksdummy> history_ver(String s1,String s2,Date d1,Date d2);
}
