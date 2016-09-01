using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization.Json;
using System.Runtime.Serialization;

namespace MarketAnalysisBasic
{

    /*enum StockSegment
    {
        Automotive,
        BankingAndFinancialServices,
        Telecommunication,
        InformationTechnology,
        Manufacturing,
        FoodAndBeverages,
        OilAndGas,
        Miscallaneous,
        PSU,
        Services,
        MediaAndEntertainment
    };

    enum StockCountry
    {
        India,
        USA,
        UK,
        Germany,
        France,
        Japan,
        China,
        Honkong
    };

    enum StockMarketIndia
    {
        NationalStockExchangeNIFTY,
        BombayStockExchangSENSEX
    };

    enum StockMarketUsa
    {
        NYSE,
        NASDAQ
    };

    enum StockMarketUk
    {
        LondonStockExchange,
        Euronext
    };

    enum StockMarketHonkong
    {
        HongKongStockExchange
    };

    enum StockMarketChina
    {
        ShanghaiStockExchange,
        ShenzhenStockExchange
    };

    enum StockMarketJapan
    {
        JapanExchangeGroupTokyoNIKKEI
    };

    enum StockMarketGermany
    {
        DeutscheBörse,
        BörseMünchen,
        FrankfurtStockExchange
    };

    enum StockMarketFrance
    {
        EuronextParis,
        EuropeanStockExchange
    };

    enum StockExchange
    {
        NationalStockExchangeNIFTY,
        BombayStockExchangeSENSEX,
        NYSE,
        NASDAQ,
        LondonStockExchange,
        Euronext,
        HongKongStockExchange,
        ShanghaiStockExchange,
        ShenzhenStockExchange,
        JapanExchangeGroupTokyoNIKKEI,
        DeutscheBörse,
        BörseMünchen,
        FrankfurtStockExchange,
        EuronextParis,
        EuropeanStockExchange
    };

    enum PerformanceCriterion
    {
        Return,
        Volatility,
        Stability,
        PERatio,
        PBRatio,
        ActivelyTraded,
        MarketCap,
        EPS,
        Revenue
    };

    */

    [DataContract]
   public  class StockDetails
    {     
        [DataMember]
        public double open { get;  set; }
        [DataMember]
        public double close { get;  set; }
        [DataMember]
        public double high { get;  set; }
        [DataMember]
        public double low { get;  set; }
        [DataMember]
        public string date { get; set; }
        [DataMember]
        public double vol { get; set; }

        //[DataMember]
        public DateTime Date { get; set; }

        //[DataMember]
        //public long date1 { get; set; }
        [DataMember]
        public string ticker { get; set; }
        [DataMember]
        public int coexchange_idcoexchange { get; set; }


        //[DataMember]
        public string Sector { get; set; }
        [DataMember]
        public string Country { get;  set; }

        
        [DataMember]
        public string Exchange { get;  set; }

        [DataMember]
        public string exchangemarket {get ;  set;}
        [DataMember]
        public double ValueWeightedAveragePrice { get;  set; }
        [DataMember]
        public long TradedPrice { get;  set; }
        [DataMember]
        public long FreeFloatMarketCap { get;  set; }
        [DataMember]
        public double YearHigh { get; set; }
        [DataMember]
        public double YearLow { get;  set; }
        [DataMember]
        public int BuyQuantity { get; set; }
        [DataMember]
        public int SellQuantitiy { get;  set; }
        [DataMember]
        public double BuyPrice { get;  set; }
        [DataMember]
        public double SellPrice { get;  set; }
        [DataMember]
        public int day { get;  set; }
        [DataMember]
        public int month { get;  set; }
        [DataMember]
        public int year { get;  set; }
        [DataMember]
        public string previousRange { get; set; }

        // [DataMember]
        public DateTime startDate { get;  set; }
        //[DataMember]
        public DateTime endDate { get; set; }
        [DataMember]
        public string startDateString { get;  set; }
        [DataMember]
        public string endDateString { get;  set; }

        public StockDetails(string stockExchange, string newticker)
        {
            exchangemarket = stockExchange;
            ticker = newticker;
        }

        public StockDetails(string newticker)
        {
            ticker = newticker;
        }

        public override string ToString()
        {

            string message ="CoExchange Id : " + coexchange_idcoexchange +"\nTicker : " + ticker + "\n Date Time : " + Date + "\nOpen Price"  + open + "\nClose Price : " + close + "\nHighest IntraDay Price : "
                + high + "\nLowestIntraDay Price : " + low + "\nTraded Volume : " + vol + "\nExchange Market : " + exchangemarket;

            message += "";

            return message;
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            if (obj is StockDetails)
            {
                StockDetails p = obj as StockDetails;
                return exchangemarket == p.exchangemarket && ticker == p.ticker;
            }

            return false;
        }

    }
}
