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

    class Check
    {
        [DataMember]
        public DateTime Date { get;  set; }


        public override string ToString()
        {
            return Date.ToString();
        }


    }
}
