using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LabLinq2
{
    class Program
    {
        private static List<Automobile> automobiles = new List<Automobile> {
            new Automobile(2005, AutomobileCategory.Bus, ConsoleColor.Yellow),
            new Automobile(2012, AutomobileCategory.Car, ConsoleColor.Red),
            new Automobile(2002, AutomobileCategory.Truck, ConsoleColor.Blue),
            new Automobile(2005, AutomobileCategory.Car, ConsoleColor.Green),
            new Automobile(2010, AutomobileCategory.Car, ConsoleColor.Red) };

        static void Main(string[] args)
        {
            Console.WriteLine("\n* * * * * * * * * * * * * * * * *");
            Console.WriteLine("all automobiles\n");
            foreach(Automobile a in automobiles)
            {
                a.Display();
                Console.WriteLine();
            }

            Console.WriteLine("\n* * * * * * * * * * * * * * * * *");
            Console.WriteLine("automobiles that were built up until 2010\n");
            var builtUpUntil2010 =
                from a in automobiles
                where a.Year <= 2010
                select a;

            foreach (var a in builtUpUntil2010)
            {
                a.Display();
                Console.WriteLine();
            }


            Console.WriteLine("\n* * * * * * * * * * * * * * * * *");
            Console.WriteLine("automobiles that are red\n");
            var redAutomobiles =
                from a in automobiles
                where a.Color == ConsoleColor.Red
                select a;

            foreach (var a in redAutomobiles)
            {
                a.Display();
                Console.WriteLine();
            }


            Console.WriteLine("\n* * * * * * * * * * * * * * * * *");
            Console.WriteLine("automobiles that are blue or that were built in 2005\n");
            var blueAutomobilesBefore2005 =
                from a in automobiles
                where a.Color == ConsoleColor.Blue && a.Year < 2005
                select a;

            foreach (var a in blueAutomobilesBefore2005)
            {
                a.Display();
                Console.WriteLine();
            }


            Console.WriteLine("\n* * * * * * * * * * * * * * * * *");
            Console.WriteLine("automobiles that are not Red and not a bus\n");
            var notRedAndNotABus =
                from a in automobiles
                where a.Color != ConsoleColor.Red && a.Category != AutomobileCategory.Bus
                select a;

            foreach (var a in notRedAndNotABus)
            {
                a.Display();
                Console.WriteLine();
            }

        }


    }
}
