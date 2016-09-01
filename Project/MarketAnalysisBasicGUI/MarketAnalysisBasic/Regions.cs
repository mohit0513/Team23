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
    public class regions
    {
        [DataMember]
        public int idregion { get; set; }
        [DataMember]
        public string region { get;  set; }

    }
}
