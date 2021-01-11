using System;
using System.Collections.Generic;

namespace DemoGenerics
{
    public class DemoDictionary
    {
        #region Demo Dictionary
        public static void Demo()
        {
            Console.WriteLine("Demo Dictionary");
            Console.WriteLine("---------------");

            // Create and initialize a new dictionary with
            Dictionary<string, int> cities = new Dictionary<string, int>()
            {
                ["Tokyo"] = 32_450_000,
                ["New York"] = 19_750_000,
                ["Mumbai"] = 19_200_000,
                ["London"] = 12_875_000,
                ["Paris"] = 12_161_000,
                ["Cambridge"] = 125_700
            };

            // Use a method to add Berlin with 3337000
            cities.Add("Berlin",3_337_000);

            // try adding Cambridge (MA) with a population of 106,000
            // compile and run
            //cities.Add("Cambridge", 106_000);
            //can't call Add with the same key twice.

            // Use the item property (indexer) to print the populiation of Paris
            Console.WriteLine($"Population of Paris: {cities["Paris"]}");

            // Use the indexer to change the population of Paris to 1234567
            cities["Paris"] = 1_234_567;

            // If a key does not exist, setting the indexer for that key adds a new key/value pair.
            // use an indexer to add Melbourne with a population of 3188000
            cities["Melbourne"] = 3_188_000;

            // But: the indexer throws an exception if you try to look up a key that does not exist
            // try to look up Salt Lake City - Compile and run
            //Console.WriteLine($"Population of Salt Lake City: {cities["Salt Lake City"]}");


            // If you don't know whether a key exists in a given dictionary you can use TryGetValue  
            // TryGetValue returns false; it does not throw an exception (compare to TryParse)
            // check before accessing Salt Lake City
            cities["Salt Lake City"] = 200_000;

            if (cities.TryGetValue("Salt Lake City", out int population))
                Console.WriteLine($"Population of Salt Lake City: {population}");
            Console.WriteLine($"The value of population = {population}");

            // Alternative: check with ContainsKey
            if(cities.ContainsKey("Salt Lake City"))
                Console.WriteLine($"Population of Salt Lake City: {cities["Salt Lake City"]}");
            Console.WriteLine();

            // When using foreach to enumerate dictionary elements,
            // the elements are retrieved as KeyValuePair objects.
            Console.WriteLine("All Key Value Pairs:");
            foreach(KeyValuePair<string,int> kvp in cities)
            {
                Console.Write($"{kvp}, ");
            }
            Console.WriteLine("\n");

            // Use the Values property to list all values of the collection
            //foreach(int value in cities.Values)
            //{
            //    Console.Write($"{value} ");
            //}
            //Console.WriteLine();
            Console.WriteLine($"All Values: {string.Join(" ", cities.Values)}");
            Console.WriteLine();

            // Use the Keys property to list al keys of the collection
            Console.WriteLine($"All Keys: {string.Join(" ", cities.Keys)}");
            Console.WriteLine();


            // Delete Paris from the collection
            cities.Remove("Paris");

            // use a string.Join to print all dictionary entries - each in a separate line
            Console.WriteLine("All Dictionary Entries: ");
            Console.WriteLine($"{string.Join("\n", cities)}");
            Console.WriteLine();

            // print a city-population table with straight rows and columns

            Console.WriteLine("Cities          Population" );
            Console.WriteLine("--------------------------");
            foreach(KeyValuePair<string, int> pair in cities)
            {
                Console.WriteLine($"{pair.Key,-15} {pair.Value}");
            }
            Console.WriteLine("\n");


        }
        #endregion

    }
}
