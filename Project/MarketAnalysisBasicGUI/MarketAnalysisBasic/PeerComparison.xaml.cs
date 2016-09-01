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

namespace MarketAnalysisBasic
{
    /// <summary>
    /// Interaction logic for PeerComparison.xaml
    /// </summary>
    public partial class PeerComparison : Window
    {
        public PeerComparison()
        {
            InitializeComponent();
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

        private void CompareStockExchange(object sender, RoutedEventArgs e)
        {
            // Compare the stocks performance with the performance of the stock exchange on which it is listed
            // over a range of time.Show their performance graph.
        }

        private void ComapreSectorPerformance(object sender, RoutedEventArgs e)
        {
            // Compare the stocks performance with the performance of the sector in which it belongs
            // over a range of time.Show their performance graph.
        }

        private void CompreSectorStocks(object sender, RoutedEventArgs e)
        {
            // Add all the stocks belonging to that sector listed on that particular stock exchange
            /*comboSectorStocks.Items.Add();
            comboSectorStocks.Items.Add();
            comboSectorStocks.Items.Add();
            comboSectorStocks.Items.Add();
            comboSectorStocks.Items.Add();
            comboSectorStocks.Items.Add();
            */
        }

        private void Search(object sender, RoutedEventArgs e)
        {

        }
    }
}
