using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using System.Net;
using System.IO;
using System.Runtime.Serialization.Json;

namespace MarketAnalysisBasic
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>

    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private string filename = "Stock.txt";
        List<StockDetails> stockList = new List<StockDetails>();

        private void WriteJson(object sender, RoutedEventArgs e)
        {
            //StockDetails stockDetail = new StockDetails("ABCD", 567.00, 675.00, 686.00, 569.00, 7234652);
            FileStream filestream = new FileStream(filename, FileMode.Create);

            DataContractJsonSerializer serializer = new DataContractJsonSerializer(typeof(StockDetails));
            //serializer.WriteObject(filestream, stockDetail);
            filestream.Close();
        }

        private void ReadJson(object sender, RoutedEventArgs e)
        {
            StreamReader reader = new StreamReader(filename);

            DataContractJsonSerializer serializer = new DataContractJsonSerializer(typeof(StockDetails));

            StockDetails other = (StockDetails)serializer.ReadObject(reader.BaseStream);
            MessageBox.Show(other.ToString());
        }

        private void WriteJsonArray(object sender, RoutedEventArgs e)
        {
            StockDetails[] accounts = new StockDetails[]
                {
                    //new StockDetails("ABCDF", 567.00, 675.00,686.00,569.00,7234654),
                   // new StockDetails("ABCDE", 567.00, 675.00,686.00,569.00,7234653)

                };
            FileStream filestream = new FileStream(filename, FileMode.Create);
            DataContractJsonSerializer arrayserializer = new DataContractJsonSerializer(typeof(StockDetails[]));
            arrayserializer.WriteObject(filestream, accounts);
            filestream.Close();
        }

        private void ReadJsonArray(object sender, RoutedEventArgs e)
        {
            StreamReader reader = new StreamReader(filename);
            DataContractJsonSerializer arrayserializer = new DataContractJsonSerializer(typeof(StockDetails[]));

            StockDetails[] stocks = (StockDetails[])arrayserializer.ReadObject(reader.BaseStream);
            string output = "";
            foreach (StockDetails stockDetails in stocks)
                output += stockDetails + "\n";

            MessageBox.Show(output);
        }

        private void ReadString(object sender, RoutedEventArgs e)
        {
            WebClient web = new WebClient();
            string webStream = web.DownloadString("http://192.168.173.3:8080/MarketDataAnalysisWeb/rest/stock");

            //StreamReader reader = new StreamReader(filename);
           // DataContractJsonSerializer serializer = new DataContractJsonSerializer(typeof(StockDetails));
           // StockDetails other = (StockDetails)serializer.ReadObject(webStream);
            //MessageBox.Show(other.ToString());

            MessageBox.Show(webStream);
        }

        private void WriteString(object sender, RoutedEventArgs e)
        {
            string result = "Hello";
            FileStream filestream = new FileStream(filename, FileMode.Create);

            DataContractJsonSerializer serializer = new DataContractJsonSerializer(typeof(string));
            serializer.WriteObject(filestream,result);
            filestream.Close();

            StreamReader stream = new StreamReader(filename);
            string newMessage = (string)serializer.ReadObject(stream.BaseStream);

            WebClient cli = new WebClient();
            string URL = "http://192.168.173.3:8080/MarketDataAnalysisWeb/rest/stock";
            cli.Headers [HttpRequestHeader.ContentType] = "text/plain";
            string response = cli.UploadString(URL,newMessage);
            MessageBox.Show(response);
        }
   
        private void ReadObject(object sender, RoutedEventArgs e)
        {

            WebClient webClient = new WebClient();

            Stream stream = webClient.OpenRead("http://192.168.173.3:8080/MarketDataAnalysisWeb/rest/stock");

            DataContractJsonSerializer listSerializer = new DataContractJsonSerializer(typeof( List< StockDetails > ) );

            List < StockDetails > stocks = ( List < StockDetails > ) listSerializer.ReadObject(stream);

            string output = "";

            foreach (StockDetails stock in stocks)
            {
                stock.Date = DateTime.ParseExact(stock.date, "yyyy-MM-dd", null);

                output += stock.ToString() + "\n";
                stockList.Add(stock);

            }

            MessageBox.Show(output);
                
        }

        private void WriteObject(object sender, RoutedEventArgs e)
        {
            FileStream filestream = new FileStream(filename, FileMode.Create);

            DataContractJsonSerializer serializerList = new DataContractJsonSerializer(typeof(List<StockDetails>));
            serializerList.WriteObject(filestream, stockList);
            filestream.Close();


            // Now Send This File to the Server just like sending a string.

            string result = "";
            StreamReader Sr = new StreamReader(filename);

            while (Sr.Peek() > -1)
            {
                result += Sr.ReadLine() + "\n";
            }

            Sr.Close();

            FileStream newFileStream = new FileStream(filename, FileMode.Create);

            DataContractJsonSerializer serializer = new DataContractJsonSerializer(typeof(string));
            serializer.WriteObject(newFileStream, result);
            newFileStream.Close();

            StreamReader stream = new StreamReader(filename);
            string newMessage = (string)serializer.ReadObject(stream.BaseStream);

            WebClient cli = new WebClient();
            string URL = "http://192.168.173.3:8080/MarketDataAnalysisWeb/rest/stock";

            cli.Headers[HttpRequestHeader.ContentType] = "text/plain";
            string response = cli.UploadString(URL, newMessage);

            MessageBox.Show(response);

        }


        private void CreateBasket(object sender, RoutedEventArgs e)
        {
            BasketWindow basketWindow = new BasketWindow();
            basketWindow.Show();
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
            //comboCountry.Items.Add();

        }

        private void FillSector(object sender, RoutedEventArgs e)
        {
            
                comboSectors.Items.Add("Automotive");
                comboSectors.Items.Add("BankingAndFinancialServices");
                comboSectors.Items.Add("FoodAndBeverages");
                comboSectors.Items.Add("InformationTechnology");
                comboSectors.Items.Add("Manufacturing");
                comboSectors.Items.Add("MediaAndEntertainment");
                comboSectors.Items.Add("Miscallaneous");
                comboSectors.Items.Add("OilAndGas");
                comboSectors.Items.Add("PSU");
                comboSectors.Items.Add("Services");
                comboSectors.Items.Add("Telecommunication");
        

        }

        private void UpdateStockExchange(object sender, SelectionChangedEventArgs e)
        {

            if (comboCountry.SelectedIndex == 4)
            {
                comboStockExchange.Items.Clear();
                comboStockExchange.Items.Add("BombayStockExchangeSENSEX");
                comboStockExchange.Items.Add("NationalStockExchangeNIFTY");
            }

            else if (comboCountry.SelectedIndex == 2)
            {
                comboStockExchange.Items.Clear();
                comboStockExchange.Items.Add("BörseMünchen");
                comboStockExchange.Items.Add("FrankfurtStockExchange");
                comboStockExchange.Items.Add("DeutscheBörse");
            }

            else if (comboCountry.SelectedIndex == 0)
            {
                comboStockExchange.Items.Clear();
                comboStockExchange.Items.Add("ShanghaiStockExchange");
                comboStockExchange.Items.Add("ShenzhenStockExchange");
            }

            else if (comboCountry.SelectedIndex == 1)
            {
                comboStockExchange.Items.Clear();
                comboStockExchange.Items.Add("EuropeanStockExchange");
                comboStockExchange.Items.Add("EuronextParis");
            }

            else if (comboCountry.SelectedIndex == 3)
            {
                comboStockExchange.Items.Clear();
                comboStockExchange.Items.Add("HongKongStockExchange");
            }

            else if (comboCountry.SelectedIndex == 5)
            {
                comboStockExchange.Items.Clear();
                comboStockExchange.Items.Add("JapanExchangeGroupTokyoNIKKEI");
            }

            else if (comboCountry.SelectedIndex == 6)
            {
                comboStockExchange.Items.Clear();
                comboStockExchange.Items.Add("LondonStockExchange");
                comboStockExchange.Items.Add("Euronext");
            }

            else
            {
                comboStockExchange.Items.Clear();
                comboStockExchange.Items.Add("NASDAQ");
                comboStockExchange.Items.Add("NYSE");
            }


        }

        private void Search(object sender, RoutedEventArgs e)
        {
            if (comboStockExchange.SelectedIndex == -1 && comboStock.SelectedIndex == -1)
            {
                string newTicker = txtSearch.Text;
                //MessageBox.Show(newTicker);

                StockDetails newStock = new StockDetails(txtSearch.Text);

                List<StockDetails> newStockList = new List<StockDetails>();

                newStockList = SendRetrieve1(newStock);

                if (newStockList.Count == 0)
                {
                    MessageBox.Show("No Matching Stock");
                }

                else
                {
                    StockWindow stockWindow = new StockWindow();

                    foreach (StockDetails stock in newStockList)
                    {
                        comboSelectedStock.Items.Add(stock.exchangemarket);
                    }

                    StockDetails newstock = new StockDetails((string)comboSelectedStock.SelectedItem, (string)newTicker);

                    newStockList = SendRetrieve(newStock);

                    foreach (StockDetails stock in newStockList)
                    {
                        stock.Date = DateTime.ParseExact(stock.date, "yyyy-MM-dd", null);
                        stockWindow.txt1StockInformation.Text= stock.ToString();
                    }
                        

                    stockWindow.Show();

                }

            }


        }


        private void OpenStockWindow(object sender, RoutedEventArgs e)
        {

            if (comboStockExchange.SelectedIndex != -1 && comboStock.SelectedIndex != -1)
            {
                StockDetails newStock = new StockDetails( (string) comboStockExchange.SelectedItem, (string)(comboStock.SelectedItem));
                List<StockDetails> newStockList = new List<StockDetails>();
                //newStockList.Add(newStock);

                newStockList = SendRetrieve(newStock);

                StockWindow stockWindow = new StockWindow();

                foreach (StockDetails stock in newStockList)
                {
                    stock.Date = DateTime.ParseExact(stock.date, "yyyy-MM-dd", null);
                    stockWindow.txt1StockInformation.Text=stock.ticker;
                    stockWindow.txtExchange.Text = stock.exchangemarket;
                }                 

                stockWindow.Show();

            }

        }


        private void StockExchangePerformance(object sender, RoutedEventArgs e)
        {
            // Display performance of the index of the stock exchange by selecting day range
            StockExchangeWindow stockExchangeWindow = new StockExchangeWindow();

            // Show Graph for Selected stock exchange.

            stockExchangeWindow.txtSearch.Text= (string)(comboStockExchange.SelectedItem);

            stockExchangeWindow.Show();

        }

        private void SectorPerformance(object sender, RoutedEventArgs e)
        {
            //Display performance of the index of the sector on the stock exchange by selecting time range
            SectorWindow sectorWindow = new SectorWindow();

            sectorWindow.listSector.Items.Add((string)(comboStockExchange.SelectedItem));
            sectorWindow.listStockExchange.Items.Add((string)comboSectors.SelectedItem);

            sectorWindow.Show();
        }



        private void FillStocks(object sender, SelectionChangedEventArgs e)
        {
            
                foreach (StockDetails stock in stockList)
                {
                    if ((string)comboStockExchange.SelectedItem == (stock.exchangemarket) /*&& comboSectors.SelectedItem == (stock.Sector) */)
                    {
                        comboStock.Items.Add(stock.ticker);
                    }

            }

            //stockList.Clear();
        }


        private List < StockDetails > SendRetrieve (StockDetails stock)
        {
            
            string value1 = (string)comboStock.SelectedItem;
            string value2 = (string)comboStockExchange.SelectedItem;
            //string value3 = "NULL";
            //string value4 = "NULL";
      
            WebClient webClient = new WebClient();

            Stream newStream = webClient.OpenRead("http://192.168.173.3:8080/MarketDataAnalysisWeb/rest/stock/test/"+value2+"/"+value1+"");

            DataContractJsonSerializer listSerializer = new DataContractJsonSerializer(typeof(List<StockDetails>));

            List<StockDetails> stocks = (List<StockDetails>)listSerializer.ReadObject(newStream);

            return stocks;

        }


        private List<StockDetails> SendRetrieve1(StockDetails stock)
        {
            string value1 = (string)txtSearch.Text;
            //string value2 = (string)comboStockExchange.SelectedItem;
            //string value3 = "NULL";
            //string value4 = "NULL";

            WebClient webClient = new WebClient();

            Stream newStream = webClient.OpenRead("http://192.168.173.3:8080/MarketDataAnalysisWeb/rest/stock/test/" + value1 + "");

            DataContractJsonSerializer listSerializer = new DataContractJsonSerializer(typeof(List<StockDetails>));

            List<StockDetails> stocks = (List<StockDetails>)listSerializer.ReadObject(newStream);

            return stocks;

        }

        private List<StockDetails> SendRetrieve2(StockDetails stock)
        {
            string value1 = (string)txtSearch.Text;
            string value2 = "123";
            string value3 = "123";
            string value4 = "123";

            string content = "param1=value1&param2=value2&param3=value3&param4=value4";

            WebClient client = new WebClient();
            string URL = "http://192.168.173.3:8080/MarketDataAnalysisWeb/rest/stock/3";

            client.Headers[HttpRequestHeader.ContentType] = "text/plain";
            string response = client.UploadString(URL, content);


            WebClient webClient = new WebClient();

            Stream newStream = webClient.OpenRead(response);

            DataContractJsonSerializer listSerializer = new DataContractJsonSerializer(typeof(List<StockDetails>));

            List<StockDetails> stocks = (List<StockDetails>)listSerializer.ReadObject(newStream);

            return stocks;

        }


        private void PopulateChart(object sender, RoutedEventArgs e)
        {
            List<KeyValuePair<string, double>> stockPrices = new List<KeyValuePair<string, double>>();
            stockPrices.Add(new KeyValuePair<string, double>("IBM", 23.3));
            stockPrices.Add(new KeyValuePair<string, double>("Tata", 1.5));
            stockPrices.Add(new KeyValuePair<string, double>("Intel", 34.3));
            stockPrices.Add(new KeyValuePair<string, double>("Fujitsu", 24.3));
            stockPrices.Add(new KeyValuePair<string, double>("ICD", 17.4));

            List<KeyValuePair<string, double>> others = new List<KeyValuePair<string, double>>();
            others.Add(new KeyValuePair<string, double>("IBM", 4.3));
            others.Add(new KeyValuePair<string, double>("Tata", 43.5));
            others.Add(new KeyValuePair<string, double>("Intel", 74.3));
            others.Add(new KeyValuePair<string, double>("Fujitsu", 14.3));
            others.Add(new KeyValuePair<string, double>("ICD", 37.4));

            //chtStocks.DataContext = stockPrices;
        }

        private void UseSeries(object sender, RoutedEventArgs e)
        {

        }

        private void ShowSeries(object sender, RoutedEventArgs e)
        {
            (new StockWindow()).Show();
        }

    }
}

//dt.ToString("yyyyMMdd"););