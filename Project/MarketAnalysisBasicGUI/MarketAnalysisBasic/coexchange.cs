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
    public class Coexchange
    {
        [DataMember]
        public int idcoexchange { get; set; }
        [DataMember]
        public string ticker { get;  set; }
        //[DataMember]
        //public Exchangemarkets exchangemarkets;
       // [DataMember]
       // public Companies companies;

    }
}
