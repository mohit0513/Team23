using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using System.Windows;
using System.Windows.Controls;
using System.Net;
using System.IO;
using System.Runtime.Serialization.Json;


namespace MarketAnalysisBasic
{
    /// <summary>
    /// Interaction logic for StockExchangeWindow.xaml
    /// </summary>
    public partial class StockExchangeWindow : Window
    {
        public StockExchangeWindow()
        {
            InitializeComponent();
        }

        private void ExchangePerformers(object sender, RoutedEventArgs e)
        {
            comboExchangePerformers.Items.Add("ActivelyTraded");
            comboExchangePerformers.Items.Add("EPS");
            comboExchangePerformers.Items.Add("Gainers");
            comboExchangePerformers.Items.Add("Losers");
            comboExchangePerformers.Items.Add("MarketCap");
            comboExchangePerformers.Items.Add("PBRatio");
            comboExchangePerformers.Items.Add("PERatio");
            comboExchangePerformers.Items.Add("Return");
            comboExchangePerformers.Items.Add("Revenue");
            comboExchangePerformers.Items.Add("Stability");
            comboExchangePerformers.Items.Add("Volatility");
        }

        private void LastNumberOfDays(object sender, RoutedEventArgs e)
        {
            comboSelectRange.Items.Add("7 Days");
            comboSelectRange.Items.Add("2 Weeks");
            comboSelectRange.Items.Add("30 Days");
            comboSelectRange.Items.Add("6 Months");
            comboSelectRange.Items.Add("1 Years");
            comboSelectRange.Items.Add("5 Years");
            comboSelectRange.Items.Add("10 Years");
            //comboSelectRange.Items.Add((int)7);

        }

        private void StockExchangePerformances(object sender, RoutedEventArgs e)
        {
            // Show the performance of the stock exchanges on a graph
            // Implement grpah for
           

        }

        private void ShowTopPerformers(object sender, RoutedEventArgs e)
        {
            // Show the top stocks corresponding to the selected criteria.

            string stockExchange = (string)(comboExchangePerformers.SelectedItem);

            if (comboExchangePerformers.SelectedIndex == 0)
            {
                string value1 = (string)txtSearch.Text;

                DateTime d = (DateTime)(dtpStart.SelectedDate);
                string value2 = d.ToString("yyyyMMdd");

                WebClient webClient = new WebClient();

                Stream newStream = webClient.OpenRead("http://192.168.173.3:8080/MarketDataAnalysisWeb/rest/stock/test/" + value1 + "/" + value2 + "");

                DataContractJsonSerializer listSerializer = new DataContractJsonSerializer(typeof(List<StockDetails>));

                List<StockDetails> stocks = (List<StockDetails>)listSerializer.ReadObject(newStream);

                foreach (StockDetails stock in stocks)
                 {
                      string msg = "";
                       msg += "Ticker : " + stock.ticker + "\nTraded Volume : " + stock.vol;
                        MessageBox.Show(msg);
                 }

                return;

            }

            if (comboExchangePerformers.SelectedIndex == 10)
            {
                string value1 = (string)txtSearch.Text;

                DateTime d = (DateTime)(dtpStart.SelectedDate);
                string value2 = d.ToString("yyyyMMdd");

                WebClient webClient = new WebClient();

                Stream newStream = webClient.OpenRead("http://192.168.173.3:8080/MarketDataAnalysisWeb/rest/stock/test/" + value1 + "/" + value2 + "");

                DataContractJsonSerializer listSerializer = new DataContractJsonSerializer(typeof(List<StockDetails>));

                List<StockDetails> stocks = (List<StockDetails>)listSerializer.ReadObject(newStream);

                foreach (StockDetails stock in stocks)
                {
                    string msg = "";
                    msg += "Ticker : " + stock.ticker + "\nTraded Volume : " + stock.vol;
                    MessageBox.Show(msg);
                }

                return;
            }

            if (comboExchangePerformers.SelectedIndex == 2)
            {
                string value1 = (string)txtSearch.Text;

                DateTime d = (DateTime)(dtpStart.SelectedDate);
                string value2 = d.ToString("yyyyMMdd");

                WebClient webClient = new WebClient();

                Stream newStream = webClient.OpenRead("http://192.168.173.3:8080/MarketDataAnalysisWeb/rest/stock/test/" + value1 + "/" + value2 + "");

                DataContractJsonSerializer listSerializer = new DataContractJsonSerializer(typeof(List<StockDetails>));

                List<StockDetails> stocks = (List<StockDetails>)listSerializer.ReadObject(newStream);

                foreach (StockDetails stock in stocks)
                {
                    string msg = "";
                    msg += "Ticker : " + stock.ticker + "\nTraded Volume : " + stock.vol;
                    MessageBox.Show(msg);
                }

                return;
            }

            if (comboExchangePerformers.SelectedIndex == 3)
            {
                string value1 = (string)txtSearch.Text;

                DateTime d = (DateTime)(dtpStart.SelectedDate);
                string value2 = d.ToString("yyyyMMdd");

                WebClient webClient = new WebClient();

                Stream newStream = webClient.OpenRead("http://192.168.173.3:8080/MarketDataAnalysisWeb/rest/stock/test/" + value1 + "/" + value2 + "");

                DataContractJsonSerializer listSerializer = new DataContractJsonSerializer(typeof(List<StockDetails>));

                List<StockDetails> stocks = (List<StockDetails>)listSerializer.ReadObject(newStream);

                foreach (StockDetails stock in stocks)
                {
                    string msg = "";
                    msg += "Ticker : " + stock.ticker + "\nTraded Volume : " + stock.vol;
                    MessageBox.Show(msg);
                }

                return;
            }

            if (comboExchangePerformers.SelectedIndex == 7)
            {

                string value1 = (string)txtSearch.Text;

                DateTime d = (DateTime)(dtpStart.SelectedDate);
                string value2 = d.ToString("yyyyMMdd");

                WebClient webClient = new WebClient();

                if (dtpStart.IsEnabled== true)
                {

                    d = (DateTime)(dtpStart.SelectedDate);
                    string value3 = d.ToString("yyyyMMdd");

                }


                Stream newStream = webClient.OpenRead("http://192.168.173.3:8080/MarketDataAnalysisWeb/rest/stock/test/" + value1 + "/" + value2 + "");

                DataContractJsonSerializer listSerializer = new DataContractJsonSerializer(typeof(List<StockDetails>));

                List<StockDetails> stocks = (List<StockDetails>)listSerializer.ReadObject(newStream);

                foreach (StockDetails stock in stocks)
                {
                    string msg = "";
                    msg += "Ticker : " + stock.ticker + "\nTraded Volume : " + stock.vol;
                    MessageBox.Show(msg);
                }

                return;
            }



        }

        private void FillCountry(object sender, RoutedEventArgs e)
        {
            comboCountry.Items.Add("China");
            comboCountry.Items.Add("France");
            comboCountry.Items.Add("Germany");
            comboCountry.Items.Add("Honkong");
            comboCountry.Items.Add("India");
            comboCountry.Items.Add("Japan");
            comboCountry.Items.Add("UK");
            comboCountry.Items.Add("USA");
        }

        private void UpdateStockExchange(object sender, SelectionChangedEventArgs e)
        {
            if (comboCountry.SelectedIndex == 4)
            {
                comboStockExchange1.Items.Clear();
                comboStockExchange1.Items.Add("BombayStockExchangeSENSEX");
                comboStockExchange1.Items.Add("NationalStockExchangeNIFTY");
            }

            else if (comboCountry.SelectedIndex == 2)
            {
                comboStockExchange1.Items.Clear();
                comboStockExchange1.Items.Add("BörseMünchen");
                comboStockExchange1.Items.Add("FrankfurtStockExchange");
                comboStockExchange1.Items.Add("DeutscheBörse");
            }

            else if (comboCountry.SelectedIndex == 0)
            {
                comboStockExchange1.Items.Clear();
                comboStockExchange1.Items.Add("ShanghaiStockExchange");
                comboStockExchange1.Items.Add("ShenzhenStockExchange");
            }

            else if (comboCountry.SelectedIndex == 1)
            {
                comboStockExchange1.Items.Clear();
                comboStockExchange1.Items.Add("EuropeanStockExchange");
                comboStockExchange1.Items.Add("EuronextParis");
            }

            else if (comboCountry.SelectedIndex == 3)
            {
                comboStockExchange1.Items.Clear();
                comboStockExchange1.Items.Add("HongKongStockExchange");
            }

            else if (comboCountry.SelectedIndex == 5)
            {
                comboStockExchange1.Items.Clear();
                comboStockExchange1.Items.Add("JapanExchangeGroupTokyoNIKKEI");
            }

            else if (comboCountry.SelectedIndex == 6)
            {
                comboStockExchange1.Items.Clear();
                comboStockExchange1.Items.Add("LondonStockExchange");
                comboStockExchange1.Items.Add("Euronext");
            }

            else
            {
                comboStockExchange1.Items.Clear();
                comboStockExchange1.Items.Add("NASDAQ");
                comboStockExchange1.Items.Add("NYSE");
            }

        }

    }
}
