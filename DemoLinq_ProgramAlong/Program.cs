using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace DemoLinq_ProgramAlong
{
    class Program
    {
        #region list of cities 
        private static List<City> cities = new List<City> {
            new City("Boston", UsState.MA, 617594, 48.3),
            new City("Columbus", UsState.OH, 787033, 217.2),
            new City("Houston", UsState.TX, 2099451, 599.6),
            new City("Murray", UsState.UT, 49308, 12.3),
            new City("Indianapolis", UsState.IN, 820445, 176.5),
            new City("Sandy", UsState.UT, 85000, 24.2),
            new City("Los Angeles", UsState.CA, 3792621, 468.7),
            new City("New York", UsState.NY, 8175133, 302.6),
            new City("Phoenix", UsState.AZ, 1445632, 516.7),
            new City("Salt Lake City", UsState.UT, 186440, 111.1),
            new City("Seattle", UsState.WA, 608660, 83.9)
        };
        #endregion

        #region Main
        static void Main(string[] args)
        {
            Console.WriteLine("\nL I N Q   D E M O");
            Console.WriteLine("~~~~~~~~~~~~~~~~~~~~");

            Console.WriteLine("\n\n1) All states:");
            AllStates();

            Console.WriteLine("\n\n2) All states no doubles:");
            AllStatesNoDoubles();

            Console.WriteLine("\n\n3) Cities with more than 1 million people:");
            CitiesGreaterThan1000000();

            Console.WriteLine("\n\n4) Name and population where more than 1 million:");
            NameAndPopulationWhereGreater1000000();

            Console.WriteLine("\n\n5) Cities whose name starts with 'S':");
            CitiesWhoseNameStartsWithS();

            Console.WriteLine("\n\n6) Cities sorted by area (large to small):");
            CitiesSortedByArea();

            Console.WriteLine("\n\n7) Group by State:");
            GroupByState();

            Console.WriteLine("\n\n. . . press enter . . .");
            Console.Read();
        }
        #endregion

        private static void AllStates()
        {
            IEnumerable<UsState> allStates =
                from c in cities
                select c.State;

            Console.WriteLine(string.Join(", ", allStates));
        }

        private static void AllStatesNoDoubles()
        {
            IEnumerable<UsState> allStatesDistinct =
            (from c in cities
            select c.State).Distinct();

            Console.WriteLine(string.Join(", ", allStatesDistinct));
        }

        private static void CitiesGreaterThan1000000()
        {
            IEnumerable<City> largeCities =
                from c in cities
                where c.Population > 1_000_000
                select c;

            Console.WriteLine(string.Join("\n", largeCities));
        }

        private static void NameAndPopulationWhereGreater1000000()
        {
            var nameAndPopulationOfLargeCities =
                from c in cities
                where c.Population > 1_000_000
                select new { c.Name, c.Population };

            Console.WriteLine(string.Join("\n", nameAndPopulationOfLargeCities));
            Console.WriteLine();

            foreach(var el in nameAndPopulationOfLargeCities)
            {
                Console.WriteLine($"{el.Name} ({el.Population})");
            }
        }

        private static void CitiesWhoseNameStartsWithS()
        {
            IEnumerable<City> citiesStartingWithS =
                from c in cities
                where c.Name[0] == 'S'
                select c;

            Console.WriteLine(string.Join("\n", citiesStartingWithS));
        }

        private static void CitiesSortedByArea()
        {
            IEnumerable<City> citiesByArea =
                from c in cities
                orderby c.Area
                select c;

            Console.WriteLine(string.Join("\n", citiesByArea));
        }

        private static void GroupByState()
        {
        }
    }
}
