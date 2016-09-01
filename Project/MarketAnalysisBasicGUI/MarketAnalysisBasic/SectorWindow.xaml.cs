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
    /// Interaction logic for SectorWindow.xaml
    /// </summary>
    public partial class SectorWindow : Window
    {
        public SectorWindow()
        {
            InitializeComponent();
        }

        private void Compare(object sender, RoutedEventArgs e)
        {
            comboComapre.Items.Add("Automotive");
            comboComapre.Items.Add("BankingAndFinancialServices");
            comboComapre.Items.Add("FoodAndBeverages");
            comboComapre.Items.Add("InformationTechnology");
            comboComapre.Items.Add("Manufacturing");
            comboComapre.Items.Add("MediaAndEntertainment");
            comboComapre.Items.Add("Miscallaneous");
            comboComapre.Items.Add("OilAndGas");
            comboComapre.Items.Add("PSU");
            comboComapre.Items.Add("Services");
            comboComapre.Items.Add("Telecommunication");
        }

        private void SectorPerformers(object sender, RoutedEventArgs e)
        {
            comboSectorPerformers.Items.Add("ActivelyTraded");
            comboSectorPerformers.Items.Add("EPS");
            comboSectorPerformers.Items.Add("Gainers");
            comboSectorPerformers.Items.Add("Losers");
            comboSectorPerformers.Items.Add("MarketCap");
            comboSectorPerformers.Items.Add("PBRatio");
            comboSectorPerformers.Items.Add("PERatio");
            comboSectorPerformers.Items.Add("Return");
            comboSectorPerformers.Items.Add("Revenue");
            comboSectorPerformers.Items.Add("Stability");
            comboSectorPerformers.Items.Add("Volatility");
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

        private void CompareSectorPerformance(object sender, ContextMenuEventArgs e)
        {
            //// Compare the performance of the 2 sectors over a certain range of time
            // Also Plot the graph.


        }

        private void ShowTopPerformers(object sender, RoutedEventArgs e)
        {
            // Show the top stocks corresponding to the selected criteria over a certain range of time.
            // Also Plot the graphs.


        }
    }
}
