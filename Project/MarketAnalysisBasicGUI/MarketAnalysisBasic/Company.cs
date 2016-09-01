using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarketAnalysisBasic
{
    class Company
    {
        public string CompanyName { get; private set; }
        public int CompanyId { get; private set; }
        public string CeoName { get; private set; }
        public double Revenue { get; private set; }
        public double Earnings { get; private set; }
        public double Expenses { get; private set; }
        public double PERatio { get; private set; }
        public double PBRatio { get; private set; }
        public double EPS { get; private set; }
        public string[] CorporateAnnouncement { get; private set; }


        public Company()
        {


        }
        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override string ToString()
        {
            string message="";
            message += "";

            return message;
        }

        public override bool Equals(object obj)
        {
            if (obj is Company)
            {

                Company  p = obj as Company;
                return CompanyId == p.CompanyId;
            }

            return false;
        }

    }
}
