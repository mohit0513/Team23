using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows;

namespace MarketAnalysisBasic
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {
        public static List<KeyValuePair<DateTime, double>> intelPrices = new List<KeyValuePair<DateTime, double>>();
    }
}
