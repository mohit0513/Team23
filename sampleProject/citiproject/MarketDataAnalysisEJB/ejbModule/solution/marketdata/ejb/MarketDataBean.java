package solution.marketdata.ejb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.io.StringReader;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



//import student.onlineretailer.jpa.product;

@Stateful
@Remote(MarketDataBeanRemote.class)
@Local(MarketDataBeanLocal.class)
public class MarketDataBean implements MarketDataBeanRemote, MarketDataBeanLocal {

	@PersistenceContext(name="MarketDataJPA") 
    private EntityManager em;
	
	//Enter all the functions
	//Add functions to remote and local
	
	//get all countries from database
	public List<String> allCountries() {
		TypedQuery<String> query = em.createQuery("SELECT p.country FROM Countries AS p", String.class);

        // Execute the query, and get a collection of entities back.
        List<String> countries = query.getResultList();

        for (String country: countries) {
            displayProductOnServerConsole("Got product in getAllProducts()", country);
        }

        return countries;
	}
	
	//get all sectors from database
	public List<String> allExchangeMarket() {
		TypedQuery<String> query = em.createQuery("SELECT p.exchangemarket FROM Exchangemarkets AS p", String.class);

        // Execute the query, and get a collection of entities back.
        List<String> exchangemarket = query.getResultList();

        for (String exchangemarket1: exchangemarket) {
            displayProductOnServerConsole("Got product in getAllProducts()", exchangemarket1);
        }

        return exchangemarket;
	}
	
	/*public List<StockDetails> allStockDetails() {
		String s = "select p.date, p.open, p.high, p.low, p.close, p.vol, e.exchangemarket, c.ticker from Prices p inner join coexchange c on p.coexchange_idcoexchange = c.idcoexchange inner join exchangemarkets e on c.exchange_idexchange = e.idexchange";
		Query query = em.createNativeQuery(s, StockDetails.class);
		List<StockDetails> st = query.setMaxResults(1000).getResultList();
		for (StockDetails stockdetails : st) {
			displayProductOnServerConsole("Got stockdetails in allStockDetails()", stockdetails);
		}
		return st;
	}*/
	
	
	/*public List<Price> test1(String tname, String d1, String d2) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
		Date date1 = null, date2 = null;
			try {
				date1 = formatter.parse(d1);
				date2 = formatter.parse(d2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		TypedQuery<Price> query = em.createQuery("SELECT p FROM Price AS p WHERE p.ticker='"+tname+"' OR (p.date BETWEEN :"+date1+" AND :"+date2+")", Price.class);

        // Execute the query, and get a collection of entities back.
        List<Price> products = query.getResultList();

        for (Price product: products) {
            displayProductOnServerConsole("Got product in getAllProducts()", product);
        }

        return products;
	}*/
	
	
	public List<Prices> getSomeData() {
		String d = "20110103";
		SimpleDateFormat x=new SimpleDateFormat("yyyyMMdd");
    	java.util.Date s = null;
		try {
			s = x.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Query query = em.createQuery("SELECT p FROM Prices p where p.date=:a");
	    query.setParameter("a",s);
		List<Prices> products = query.setMaxResults(400).getResultList();
		for (Prices product: products) {
			displayProductOnServerConsole("Got product in getAllProducts()", product);
		}
		return products;
	}
	
	public List<Stockdetails> getAllDataa() {
	    Query query = em.createQuery("SELECT p FROM Stockdetails AS p", Stockdetails.class);
		List<Stockdetails> products = query.setMaxResults(100).getResultList();
		for (Stockdetails product: products) {
			displayProductOnServerConsole("Got product in getAllProducts()", product);
		}
		return products;
	}
	
	
	
	public List<Prices> getAllData() {
	    Query query = em.createQuery("SELECT p FROM Prices AS p", Prices.class);
		List<Prices> products = query.setMaxResults(100).getResultList();
		for (Prices product: products) {
			displayProductOnServerConsole("Got product in getAllProducts()", product);
		}
		return products;
	}
	
//	public List<String> allCountries() {
//		//List<String> 
//	}
//	
	
//by sand
	 public List<Stocksdummy> history_ver(String s1,String s2,Date d1,Date d2) {
			
			Query query = em.createNativeQuery("select * from stocksdummy where ((ticker=:a and exchangemarket=:b) and (date between :c and :d))", Stocksdummy.class);
		    query.setParameter("a",s1);
		    query.setParameter("b",s2);
		    query.setParameter("c",d1);
		    query.setParameter("d",d2);
		    List<Stocksdummy> products = (List<Stocksdummy>)query.setMaxResults(400).getResultList();
		    for (Stocksdummy product: products) {
				displayProductOnServerConsole("Got product in getAllProducts()", product);
			}
			return products;
			
		}
	 
	public List<Sectors> tickerDateChange(String ticker, int lowYear, int highYear, int lowMonth, int highMonth, int lowDay, int highDay) {
		
		/*TypedQuery<Price> query = em.createQuery("SELECT p FROM Price AS p WHERE p.Year BETWEEN :ylo AND :yhigh and p.Month Between :mlo and :mhigh and p.Day between :dlo and :dhigh AND p.Ticker =:t", Price.class);
		query.setParameter("t", ticker);
		query.setParameter("ylo",lowYear);
        query.setParameter("yhigh", highYear);
        query.setParameter("mlo", lowMonth);
        query.setParameter("mhigh", highMonth);
        query.setParameter("dlo",lowDay);
        query.setParameter("dhigh", highDay);
        List<Price> products = query.getResultList();

        for (Price product: products) {
           displayProductOnServerConsole("Got product in getAllProducts()", product);
        }
*/
        return null;
	}
	
	public List<Stockdetails> detailsForStock(String value1,String value2) {
		TypedQuery<Stockdetails> query = (TypedQuery<Stockdetails>) em.createQuery("SELECT p from Stockdetails AS p WHERE p.exchangemarket =:a AND p.ticker =:b");
		query.setParameter("a", value1);
		query.setParameter("b", value2);
		List<Stockdetails> st = query.getResultList();
		for (Stockdetails product: st) {
	           displayProductOnServerConsole("Got product in getAllProducts()", product);
	        }
		return st;
	}
	
	public List<Stocksdummy> stockperformance_h(String ti, String exm, Date d1, Date d2) {
		Query query = em.createNativeQuery("select * from stocksdummy where ticker =:a and exchangemarket =:b and (date between :c and :d) order by high DESC", Stocksdummy.class);
	    query.setParameter("a",ti);
	    query.setParameter("b",exm);
	    query.setParameter("c", d1);
	    query.setParameter("d", d2);
	    List<Stocksdummy> products = query.setMaxResults(1).getResultList();
	    //String result = null;
	    /*for (Stocksdummy product: products) {
	    	result += product+" ";
			displayProductOnServerConsole("Got product in getAllProducts()", product);
		}*/
		return products;
	}
	
	public List<Stocksdummy> stockperformance_l(String ti, String exm, Date d1, Date d2) {
		Query query = em.createNativeQuery("select * from stocksdummy where ticker =:a and exchangemarket =:b and (date between :c and :d) order by low ASC", Stocksdummy.class);
	    query.setParameter("a",ti);
	    query.setParameter("b",exm);
	    query.setParameter("c", d1);
	    query.setParameter("d", d2);
	    List<Stocksdummy> products = query.setMaxResults(1).getResultList();
	    //String result = null;
	    /*for (Stocksdummy product: products) {
	    	result += product+" ";
			displayProductOnServerConsole("Got product in getAllProducts()", product);
		}*/
		return products;
	}
	
	public List<String> detailsForStockExchange(String value1) {
		TypedQuery<String> query = (TypedQuery<String>) em.createQuery("SELECT p.exchangemarket FROM stocksdummy AS p where ticker = :a group by exchangemarket");
		query.setParameter("a", value1);
		List<String> st = query.getResultList();
		for (String product: st) {
	           displayProductOnServerConsole("Got product in getAllProducts()", product);
	        }
		return st;
	}


public List<Stocksdummy> loser(java.util.Date d, String c) {
		
		Query query = em.createNativeQuery("select * from stocksdummy where date=:a and country=:b order by ((open-close)/open) desc", Stocksdummy.class);
	    query.setParameter("a",d);
	    query.setParameter("b",c);
	    List<Stocksdummy> products = (List<Stocksdummy>)query.setMaxResults(2).getResultList();
	    for (Stocksdummy product: products) {
			displayProductOnServerConsole("Got product in getAllProducts()", product);
		}
		return products;
		
	}
 
public List<Stocksdummy> loserSector(java.util.Date d, String c) {
	
	Query query = em.createNativeQuery("select * from stocksdummy where date=:a and sector=:b order by ((open-close)/open) desc", Stocksdummy.class);
    query.setParameter("a",d);
    query.setParameter("b",c);
    List<Stocksdummy> products = (List<Stocksdummy>)query.setMaxResults(2).getResultList();
    for (Stocksdummy product: products) {
		displayProductOnServerConsole("Got product in getAllProducts()", product);
	}
	return products;
	
}



public List<Stocksdummy> gainer(java.util.Date d, String c) {
		
		Query query = em.createNativeQuery("select * from stocksdummy where date=:a and country=:b order by ((close-open)/open) desc", Stocksdummy.class);
	    query.setParameter("a",d);
	    query.setParameter("b", c);
	    List<Stocksdummy> products = (List<Stocksdummy>)query.setMaxResults(2).getResultList();
	    for (Stocksdummy product: products) {
			displayProductOnServerConsole("Got product in getAllProducts()", product);
		}
		return products;
		
	}

public List<Stocksdummy> gainerSector(java.util.Date d, String c) {
	
	Query query = em.createNativeQuery("select * from stocksdummy where date=:a and sector=:b order by ((close-open)/open) desc", Stocksdummy.class);
    query.setParameter("a",d);
    query.setParameter("b", c);
    List<Stocksdummy> products = (List<Stocksdummy>)query.setMaxResults(2).getResultList();
    for (Stocksdummy product: products) {
		displayProductOnServerConsole("Got product in getAllProducts()", product);
	}
	return products;
	
}


public List<Stocksdummy> mostVolatile(java.util.Date d) {
	
	Query query = em.createNativeQuery("select * from stocksdummy where date=:a order by ((abs(high-low))/open) desc", Stocksdummy.class);
    query.setParameter("a",d);
    List<Stocksdummy> products = (List<Stocksdummy>)query.setMaxResults(2).getResultList();
    for (Stocksdummy product: products) {
		displayProductOnServerConsole("Got product in getAllProducts()", product);
	}
	return products;
	
}

public List<Stocksdummy> mostVolatile(java.util.Date d, String c) {
	
	Query query = em.createNativeQuery("select * from stocksdummy where date=:a and country=:b order by ((abs(high-low))/open) desc", Stocksdummy.class);
    query.setParameter("a",d);
    query.setParameter("b", c);
    List<Stocksdummy> products = (List<Stocksdummy>)query.setMaxResults(2).getResultList();
    for (Stocksdummy product: products) {
		displayProductOnServerConsole("Got product in getAllProducts()", product);
	}
	return products;
	
}

public List<Stocksdummy> mostVolatileSector(java.util.Date d, String c) {
	
	Query query = em.createNativeQuery("select * from stocksdummy where date=:a and sector=:b order by ((abs(high-low))/open) desc", Stocksdummy.class);
    query.setParameter("a",d);
    query.setParameter("b", c);
    List<Stocksdummy> products = (List<Stocksdummy>)query.setMaxResults(2).getResultList();
    for (Stocksdummy product: products) {
		displayProductOnServerConsole("Got product in getAllProducts()", product);
	}
	return products;
	
}


public List<Stocksdummy> mostTrendingSector(java.util.Date d, String c) {
	
	Query query = em.createNativeQuery("select * from stocksdummy where date=:a and sector=:b order by vol desc", Stocksdummy.class);
    query.setParameter("a",d);
    query.setParameter("b", c);
    List<Stocksdummy> products = (List<Stocksdummy>)query.setMaxResults(2).getResultList();
    for (Stocksdummy product: products) {
		displayProductOnServerConsole("Got product in getAllProducts()", product);
	}
	return products;
}


public List<Stocksdummy> mostTrending(java.util.Date d, String c) {
	
	Query query = em.createNativeQuery("select * from stocksdummy where date=:a and country=:b order by vol desc", Stocksdummy.class);
    query.setParameter("a",d);
    query.setParameter("b", c);
    List<Stocksdummy> products = (List<Stocksdummy>)query.setMaxResults(2).getResultList();
    for (Stocksdummy product: products) {
		displayProductOnServerConsole("Got product in getAllProducts()", product);
	}
	return products;
}

public List<Stocksdummy> historyX(String s1,String s2,String s4) {
	
	 
	 
    String d1 = "20131010";
    SimpleDateFormat x=new SimpleDateFormat("yyyyMMdd");
    java.util.Date s3 = null;
	try {
		s3 = x.parse(d1);
		
		
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    switch(s4){
	    case "0":Query query = em.createNativeQuery("select * from stocksdummy where ((ticker=:a and exchangemarket=:b) and (date>= :c - interval 6 day))", Stocksdummy.class);
			    query.setParameter("a",s1);
			    query.setParameter("b",s2);
			    query.setParameter("c",s3);
			    List<Stocksdummy> products = (List<Stocksdummy>)query.setMaxResults(7).getResultList();
			    for (Stocksdummy product: products) {
					displayProductOnServerConsole("Got product in getAllProducts()", product);
				}
				return products;
				
	    case "1":Query query1 = em.createNativeQuery("select * from stocksdummy where ((ticker=:a and exchangemarket=:b) and (date>= :c - interval 13 day))", Stocksdummy.class);
			    query1.setParameter("a",s1);
			    query1.setParameter("b",s2);
			    query1.setParameter("c",s3);List<Stocksdummy> products1 = (List<Stocksdummy>)query1.setMaxResults(14).getResultList();
			    for (Stocksdummy product: products1) {
					displayProductOnServerConsole("Got product in getAllProducts()", product);
				}
				return products1;
				
	    case "2":Query query2 = em.createNativeQuery("select * from stocksdummy where ((ticker=:a and exchangemarket=:b) and (date>= :c - interval 29 day))", Stocksdummy.class);
			    query2.setParameter("a",s1);
			    query2.setParameter("b",s2);
			    query2.setParameter("c",s3);List<Stocksdummy> products2 = (List<Stocksdummy>)query2.setMaxResults(30).getResultList();
			    for (Stocksdummy product: products2) {
					displayProductOnServerConsole("Got product in getAllProducts()", product);
				}
				return products2;
		
	    case "3":Query query3 = em.createNativeQuery("select * from stocksdummy where ((ticker=:a and exchangemarket=:b) and (date>= :c - interval 179 day))", Stocksdummy.class);
			    query3.setParameter("a",s1);
			    query3.setParameter("b",s2);
			    query3.setParameter("c",s3);List<Stocksdummy> products3 = (List<Stocksdummy>)query3.setMaxResults(180).getResultList();
			    for (Stocksdummy product: products3) {
					displayProductOnServerConsole("Got product in getAllProducts()", product);
				}
				return products3;
		
	    case "4":Query query4 = em.createNativeQuery("select * from stocksdummy where ((ticker=:a and exchangemarket=:b) and (date>= :c - interval 364 day))", Stocksdummy.class);
			    query4.setParameter("a",s1);
			    query4.setParameter("b",s2);
			    query4.setParameter("c",s3);List<Stocksdummy> products4 = (List<Stocksdummy>)query4.setMaxResults(365).getResultList();
			    for (Stocksdummy product: products4) {
					displayProductOnServerConsole("Got product in getAllProducts()", product);
				}
				return products4;
		
	    case "5":Query query5 = em.createNativeQuery("select * from stocksdummy where ((ticker=:a and exchangemarket=:b) and (date>= :c - interval 1824 day))", Stocksdummy.class);
			    query5.setParameter("a",s1);
			    query5.setParameter("b",s2);
			    query5.setParameter("c",s3);
			    List<Stocksdummy> products5 = (List<Stocksdummy>)query5.setMaxResults(1825).getResultList();
			    for (Stocksdummy product: products5) {
					displayProductOnServerConsole("Got product in getAllProducts()", product);
				}
				return products5;
		
	    case "6":Query query6 = em.createNativeQuery("select * from stocksdummy where ((ticker=:a and exchangemarket=:b) and (date>= :c - interval 3649 day))", Stocksdummy.class);
			    query6.setParameter("a",s1);
			    query6.setParameter("b",s2);
			    query6.setParameter("c",s3);
			    
			    List<Stocksdummy> products6 = (List<Stocksdummy>)query6.setMaxResults(3650).getResultList();
			    for (Stocksdummy product: products6) {
					displayProductOnServerConsole("Got product in getAllProducts()", product);
				}
			    return products6;
	    
	    default: return null;
    }
}


public List<Stocksdummy> searchMarket(String s1) {
		
		Query query = em.createNativeQuery("select * from stocksdummy where ticker=:a group by exchangemarket", Stocksdummy.class);
	    query.setParameter("a",s1);
	    
	    List<Stocksdummy> products = (List<Stocksdummy>)query.setMaxResults(5).getResultList();
	    for (Stocksdummy product: products) {
			displayProductOnServerConsole("Got product in getAllProducts()", product);
		}
		return products;
		
	}
	
	//display values for a particular stock
	/*public void getDetails(String s) {
		//JSONParser parser = new JSONParser();
		//Object obj = parser.parse(s);
		JsonReader jr = Json.createReader(new StringReader(s)); 
		JsonArray jobj = jr.readArray();
		//JsonObject obj = new Json
		ListIterator l = jobj.listIterator();
		while (l.hasNext()) {
			JsonObject j = (JsonObject) l.next();
			JsonObject a = j.getJsonObject("exchangemarket");
			System.out.println(a);
		}
		//System.out.println(jobj.size());
		//System.out.println(jobj);
		//System.out.println(jobj.getString(15));
		//String name = (String) jobj.get("exchangemarket");
		//System.out.println(name);
		
	}*/
	
	
	//Display for String type Objects
	private void displayProductOnServerConsole(String message,String product) {
		// TODO Auto-generated method stub
    	 System.out.println(message);
         if (product == null) {
             System.out.print("Product is null");
         } else {
             System.out.println(product);
         }
     }
	
	//Display for StockDetails type Objects
		private void displayProductOnServerConsole(String message,Stockdetails product) {
			// TODO Auto-generated method stub
	    	 System.out.println(message);
	         if (product == null) {
	             System.out.print("Product is null");
	         } else {
	             System.out.println(product);
	         }
	     }
		
		//Display for StockDetails type Objects
				private void displayProductOnServerConsole(String message,Stocksdummy product) {
					// TODO Auto-generated method stub
			    	 System.out.println(message);
			         if (product == null) {
			             System.out.print("Product is null");
			         } else {
			             System.out.println(product);
			         }
			     }
	
	//Display for Prices type Object
    private void displayProductOnServerConsole(String message, Prices product) {
		// TODO Auto-generated method stub
    	 System.out.println(message);
         if (product == null) {
             System.out.print("Product is null");
         } else {
             System.out.println(product);
         }
     }

    
	public MarketDataBean() {
        // TODO Auto-generated constructor stub
    }

}
