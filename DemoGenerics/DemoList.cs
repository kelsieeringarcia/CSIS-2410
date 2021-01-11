using System;
using System.Collections.Generic;

namespace DemoGenerics
{
    /// <summary>
    /// Demo on how to use generic list
    ///
    /// Author: Kelsie Garcia
    /// </summary>
    public class DemoList
    {
        #region DemoList
        public static void Demo()
        {
            Console.WriteLine("Demo List");
            Console.WriteLine("----------");

            //use collection initializer
            List<double> numbers = new List<double>() { 3.3, 5.5, 1.1, 9.9, 7.7 };

            //use string.Join to print collection elements
            PrintList(numbers);

            //use indexer for read and write access
            Console.WriteLine($"Second list element : {numbers[1]}");
            Console.WriteLine($"Last element: {numbers[numbers.Count - 1]}");
            numbers[0] *= 10;

            //print sorted list
            numbers.Sort();
            PrintList(numbers);

            //check whether an item is included in the list
            CheckList(numbers, 5.5);
            CheckList(numbers, 6.6);
            Console.WriteLine();
        }

        private static void CheckList(List<double> numbers, double d)
        {
            string isFound = numbers.Contains(d) ? "is" : "is not";
            Console.WriteLine($" {d} {isFound} in the list");
        }

        private static void PrintList(List<double> numbers)
        {
            Console.WriteLine($"numbers: [{string.Join(", ", numbers)}]");
        }
        #endregion
    }
}
