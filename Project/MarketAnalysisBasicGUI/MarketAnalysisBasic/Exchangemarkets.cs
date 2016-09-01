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
    public class exchangemarkets
    {
        [DataMember]
        public int idexhange { get; set; }
        [DataMember]
        public string exchangemarket { get; set; }
        [DataMember]
        public countries Countries ;

    }
}
