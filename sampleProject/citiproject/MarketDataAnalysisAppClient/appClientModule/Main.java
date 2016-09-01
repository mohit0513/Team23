import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import solution.marketdata.ejb.Countries;
import solution.marketdata.ejb.MarketDataBeanRemote;
import solution.marketdata.ejb.Prices;
//import solution.marketdata.ejb.StockDetails;
import solution.marketdata.ejb.Stockdetails;


public class Main {
	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName()); 
		prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		prop.put("jboss.naming.client.ejb.context", true);
		
		// Create the JNDI InitialContext.
		Context context = new InitialContext(prop);
		
		// Formulate the full JNDI name for the Diary session bean.
		
		// Lookup the bean using the full JNDI name.
		String fullJndiName = String.format("MarketDataAnalysis/MarketDataAnalysisEJB/MarketDataBean!solution.marketdata.ejb.MarketDataBeanRemote");
		MarketDataBeanRemote bean = (MarketDataBeanRemote) context.lookup(fullJndiName);
		//call functions using bean.blahblah
		System.out.println("here");
		
		//List<stockprice> products = bean.test();
		//List<stockprice> products = bean.test1("AAME","20110103000000", "20110108000000");
		//List<stockprice> products = bean.test2("2011013000000", "2011018000000");
		//List<Price> products = bean.tickerDateChange("AAME",2011, 2013, 1, 3, 1, 2);
		//List<Prices> prices = bean.getAllData();
		//List<String> exm = bean.allExchangeMarket();
		List<Stockdetails> st = bean.detailsForStock("NASDAQ","AAME");
		displayProductsss("All products", st);
	}
private static void displayProducts(String message, List<Prices> products) {
		
		System.out.printf("\n%s\n", message);
		for (Prices product: products) {
			System.out.println(product);
		}
	}

private static void displayProductss(String message, List<String> products) {
	
	System.out.printf("\n%s\n", message);
	for (String product: products) {
		System.out.println(product);
	}
}

private static void displayProductsss(String message, List<Stockdetails> products) {
	
	System.out.printf("\n%s\n", message);
	for (Stockdetails product: products) {
		System.out.println(product);
	}
}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}