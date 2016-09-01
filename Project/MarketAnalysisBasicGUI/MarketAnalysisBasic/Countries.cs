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
    public class countries
    {
        [DataMember]
        public int idCountry{ get;  set; }
        [DataMember]
        public string country { get;  set; }
        [DataMember]
        regions Region;

    }
}
