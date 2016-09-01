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
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using System.Windows.Controls.DataVisualization.Charting;
using System.Windows;
using System.Windows.Controls;
using System.Net;
using System.IO;
using System.Runtime.Serialization.Json;

namespace MarketAnalysisBasic
{
    /// <summary>
    /// Interaction logic for StockWindow.xaml
    /// </summary>
    public partial class StockWindow : Window
    {
        public StockWindow()
        {
            InitializeComponent();
        }

        private void listBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

        }
        public static List<KeyValuePair<DateTime, double>> intelPrices = new List<KeyValuePair<DateTime, double>>();

        private void ShowTradeSnapshot(object sender, RoutedEventArgs e)
        {

            string value1 = (string)txt1StockInformation.Text;
            string value2 = (string)txtExchange.Text;

            WebClient webClient = new WebClient();

            if (comboSelectRange.SelectedIndex == -1)
            {
                DateTime d = (DateTime)(dtpStart.SelectedDate);
                string value3 = d.ToString("yyyyMMdd");

                d = (DateTime)(dtpEnd.SelectedDate);
                string value4 = d.ToString("yyyyMMdd");

                Stream newStream = webClient.OpenRead("http://192.168.173.3:8080/MarketDataAnalysisWeb/rest/stock/stockperformance/lowest/" + value1 + "/" + value2 + "/" + value3 + "/" + value4 + "");

                Stream newStream1 = webClient.OpenRead("http://192.168.173.3:8080/MarketDataAnalysisWeb/rest/stock/stockperformance/highest/" + value1 + "/" + value2 + "/" + value3 + "/" + value4 + "");

                DataContractJsonSerializer listSerializer = new DataContractJsonSerializer(typeof(List<StockDetails>));
                DataContractJsonSerializer listSerializer1 = new DataContractJsonSerializer(typeof(List<StockDetails>));
                List<StockDetails> stocks = (List<StockDetails>)listSerializer.ReadObject(newStream);
                List<StockDetails> stocks1 = (List<StockDetails>)listSerializer1.ReadObject(newStream1);
                
                string msg = "";

                foreach (StockDetails stock in stocks)
                {
                    msg += "Ticker : " + stock.ticker + "\nStock Low : " + stock.low;
                }

                foreach (StockDetails stock in stocks1)
                {
                    msg += "\nStock High : " + stock.high;
                }

                MessageBox.Show(msg);

                newStream = webClient.OpenRead("http://192.168.173.3:8080/MarketDataAnalysisWeb/rest/stock/stockhistoryver/" + value1 + "/" + value2 + "/" + value3 + "/" + value4 + "");
                stocks = (List<StockDetails>)listSerializer.ReadObject(newStream);
                foreach (StockDetails stock in stocks)
                {
                    DateTime Datadate = DateTime.ParseExact(stock.date, "yyyy-MM-dd", null);

                    intelPrices.Add(new KeyValuePair<DateTime, double>(Datadate, stock.close));

                }
                lineseries.ItemsSource = intelPrices;
                dataGrid.ItemsSource = stocks;

            }

            else
            {
                int x = comboSelectRange.SelectedIndex;

                string value3 = x.ToString();

                Stream newStream = webClient.OpenRead("http://192.168.173.3:8080/MarketDataAnalysisWeb/rest/stock/test/" + value1 + "/" + value2 + "/" + value3 + "");

                DataContractJsonSerializer listSerializer = new DataContractJsonSerializer(typeof(List<StockDetails>));

                List<StockDetails> stocks = (List<StockDetails>)listSerializer.ReadObject(newStream);

                foreach (StockDetails stock in stocks)
                {
                    string msg = "";
                    msg += "Stock High : " + stock.high + "\nStock Low : " + stock.low;

                    MessageBox.Show(msg);

                }

            }


        }

        private void ShowCompanyInformation(object sender, RoutedEventArgs e)
        {
            //MessageBox.Show(company.Tostring());
        }

        private void PeerComparison(object sender, RoutedEventArgs e)
        {
            PeerComparison stockComparison = new PeerComparison();
            stockComparison.Show();
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
        }

        private void ShowInformationAndCharts(object sender, RoutedEventArgs e)
        {
            // Show Graphs,Histograms,Tables
            


        }

       
    }
}
