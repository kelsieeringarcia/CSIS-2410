using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LabLinq2
{
    public enum AutomobileCategory { Bus, Car, Truck }
    class Automobile
    {
        public int Year { get; }

        public AutomobileCategory Category { get; }

        public ConsoleColor Color { get; }

        public Automobile(int year, AutomobileCategory category, ConsoleColor color)
        {
            Year = year;
            Category = category;
            Color = color;
        }

        public void Display()
        {
            ConsoleColor originalColor = Console.ForegroundColor;

            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine("{0}", Year);
            Console.ForegroundColor = Color;
            switch (Category)
            {
                case AutomobileCategory.Bus:
                    AsciiImage.Bus();
                    break;
                case AutomobileCategory.Car:
                    AsciiImage.Car();
                    break;
                case AutomobileCategory.Truck:
                    AsciiImage.Truck();
                    break;
                default:
                    Console.WriteLine("Not a valid Category");
                    break;
            }
            Console.ForegroundColor = originalColor;
        }
    }
}

