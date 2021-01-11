using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoDelegate_ProgramAlong
{
    delegate double ConversionDelegate(double d);
    public class Program
    {
        static void Main(string[] args)
        {
            IList<double> data = new List<double> { 2, 4, 6, 8, 10 };

            // TODO a) create ConversionDelegate with 1 parameter of type double and return type double

            // TODO b) create instance of ConversionDelegate and assign InchToCm; invoke delegate
            ConversionDelegate myDelegate = LengthConverter.InchToCm;
            Console.WriteLine($"myDelegate(1) : {myDelegate(1)}");

            // TODO c) implement ConvertList

            // TODO d) convert list then call DisplayList
            IList<double> dataToCm = ConvertList(data, myDelegate);
            DisplayList(dataToCm, "Inch to cm");

            // TODO e) repeat for InchToM
            myDelegate = LengthConverter.InchToM;
            IList<double> dataToM = ConvertList(data, myDelegate);
            DisplayList(dataToM, "Inch to M");

            // TODO f) What about FeetToInch? (adapter method, anonymous method)
            //IList<double> dataToInches = ConvertList(data, FeetToInchAdapter);
            //DisplayList(dataToInches, "Feet to Inch");
            IList<double> dataToInches = ConvertList(data, x => LengthConverter.FeetToInch((int)Math.Round(x)));
            DisplayList(dataToInches, "Feet to Inch");

            Console.WriteLine("\n");
        }

        //private static double FeetToInchAdapter(double d)
        //{
        //    return LengthConverter.FeetToInch((int) Math.Round(d));
        //}

        /// <summary>
        /// Print title followed by a colon, a space and all list elements
        /// separated by a blank(space). At the end it advances to the next line.
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="list"></param>
        /// <param name="title"></param>
        private static void DisplayList<T>(IList<T> list, string title)
        {
            Console.WriteLine($"{title}: {string.Join(" ", list)}");

        }

        private static IList<double> ConvertList(IList<double> data, ConversionDelegate convert)
        {
            IList<double> results = new List<double>();
            foreach (double el in data)
            {
                results.Add(convert(el));
            }
            return results;
        }


    }
}