using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization.Json;
using System.Runtime.Serialization;

namespace MarketAnalysisBasic
{
    [DataContract]
    public class sectors
    {
        [DataMember]
        public int idSector { get; set; }
        [DataMember]
        public string sector { get;  set; }

        //exchangemarkets exchangeMarket;

    }
}
