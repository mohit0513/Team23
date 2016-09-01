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
    public class companies
    {
        [DataMember]
        public int idcompany { get; set; }
        [DataMember]
        public string company { get;  set; }
        [DataMember]
        sectors newSector;

    }
}
