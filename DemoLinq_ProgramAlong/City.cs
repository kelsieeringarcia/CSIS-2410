using System;
namespace DemoLinq_ProgramAlong
{
    public enum UsState
    {
        AK, AL, AR, AZ, CA, CO, CT, DE, FL, GA,
        HI, IA, ID, IL, IN, KS, KY, LA, MA, MD,
        ME, MI, MN, MO, MS, MT, NC, ND, NE, NH,
        NJ, NM, NV, NY, OH, OK, OR, PA, RI, SC,
        SD, TN, TX, UT, VA, VT, WA, WI, WV, WY
    }

    public class City
    {
        public string Name { get; }
        public UsState State { get; }
        public int Population { get; }
        public double Area { get; }

        public City(string n, UsState state, int population, double area)
        {
            Name = n;
            State = state;
            Population = population;
            Area = area;
        }

        public override string ToString()
        {
            return string.Format("{0} ({1}) P:{2} A:{3}", Name, State, Population, Area);
        }
    }
}
