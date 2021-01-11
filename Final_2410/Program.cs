using System;
using System.Collections.Generic;
using System.Linq;

namespace Final_2410
{
    /// <summary>
    ///This class holds the main method where I used the given list and 
    /// manipulated the data
    /// 
    /// Author: Kelsie Garcia & Margarethe
    /// </summary>
    class Program
    {
        static void Main(string[] args)
        {
            IList<Lights> list = new List<Lights> {
                new Lights(Usage.Outdoor, 15, true),
                new Lights(Usage.Outdoor, 22, true),
                new Lights(Usage.Indoor, 10, false),
                new Lights(Usage.Both, 15, false),
                new Lights(Usage.Outdoor, 20, true),
                new Lights(Usage.Indoor, 18, false),
                new Lights(Usage.Indoor, 10, true),
                new Lights(Usage.Outdoor, 25, false),
                new Lights(Usage.Both, 12, true),
                new Lights(Usage.Indoor, 15, true)
                };

            Console.WriteLine("Part A");
            Console.WriteLine("------");
            foreach(Lights l in list)
            {
                Console.Write($"{l.ToString()} ");
                l.Display();
            }
            Console.WriteLine();

            Console.WriteLine("Part B");
            Console.WriteLine("------");

            Console.Write("Blinking lights no longer than 12 feet: ");
            IEnumerable<Lights> blinkingLessThan12 =
                from l in list
                where l.Length < 12 && l.Blinking == true
                select l;
            foreach(Lights l in blinkingLessThan12)
            {
                Console.Write(l);
            }
            Console.WriteLine();

            Console.Write("Average length of outdoor lights: ");
            double averageLengthOfOutdoorLights =
                (from l in list
                where l.Usage == Usage.Outdoor
                select l.Length).Average();
            Console.Write(averageLengthOfOutdoorLights);
            Console.WriteLine();

            Console.WriteLine("Lights grouped by usage: ");
            var lightsByGroup =
                from l in list
                group l by l.Usage into g
                select new { Usage = g.Key, List = g };

            foreach (var group in lightsByGroup)
            {
                Console.WriteLine(group.Usage);
                foreach (Lights s in group.List)
                {
                    Console.WriteLine($"    {s}");
                }
            }
            Console.WriteLine();

            Console.WriteLine("Part C");
            Console.WriteLine("------");
            /* TODO */
            Dictionary<Lights, bool> st = new Dictionary<Lights, bool>();
            foreach (Lights l in list)
            {
                if ((l.Usage == Usage.Outdoor && l.Blinking == true) ||
                    (l.Usage == Usage.Indoor && l.Length >= 15))
                {
                    st.Add(l,true);
                }
                else
                {
                    st.Add(l, false);
                }
                
            }
            foreach(var l in st)
            {
                if (l.Value == true)
                    l.Key.Display();
            }

        }
    }
}
