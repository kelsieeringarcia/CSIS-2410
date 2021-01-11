using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;

namespace DemoExtensionMethods
{
    class Program
    {
        private static readonly Random rand = new Random();
        static void Main(string[] args)
        {
            IList<Rectangle> list = new List<Rectangle>();
            //fill is with 25 rectangles: the length is 1-9 and width is 1-5.
            for(int i = 0; i < 25; i++)
            {

                list.Add(new Rectangle(rand.Next(1, 10), rand.Next(1,6)));
            }
            Console.WriteLine($"List: {string.Join(" ", list)}");

            //LinqReview(list);

            DemoStandardQueryOperators(list);
        }

        private static void DemoStandardQueryOperators(IList<Rectangle> list)
        {
            //take
            IEnumerable<Rectangle> firstSevenRectangles = list.Take(7);
            Console.WriteLine($"firstSevenRectangles: {String.Join(" ", firstSevenRectangles)}");
            Console.WriteLine();

            //TakeWhile
            IEnumerable<Rectangle> smallerRectangles = list.TakeWhile(x => x.Area() < 30);
            Console.WriteLine($"smallerRectangles: {String.Join(" ", smallerRectangles)}");

            //skip
            IEnumerable<Rectangle> skip3Take5 = list.Skip(3).Take(5);
            Console.WriteLine($"skip3Take5: {String.Join(" ", skip3Take5)}");

            //skip rectangle <25 take rectangle >= 25
            IEnumerable<Rectangle> skipSmallerTakeBigger = list
                .SkipWhile(x => x.Area() < 25)
                .TakeWhile(x => x.Area() >= 25);
            Console.WriteLine($"skipSmallerTakeBigger: {String.Join(" ", skipSmallerTakeBigger)}");

            //Min and max length
            Console.WriteLine($"Min length: {list.Min(x => x.Length)}");
            Console.WriteLine($"Max length: {list.Max(x => x.Length)}");

            //Average Width
            Console.WriteLine($"Average width: {list.Average(x => x.Width)}");

            //sum of the areas of all rectangles
            Console.WriteLine($"Sum of areas: {list.Sum(x => x.Area())}");

            //last and first rectangle
            Console.WriteLine($"First rectangle: {list.First()}");
            Console.WriteLine($"Last rectangle: {list.Last()}");



        }

        /// <summary>
        /// Review linq queries without grouping
        /// Demonstrate deferred execution.
        /// </summary>
        /// <param name="rectangles"></param>
        private static void LinqReview(IList<Rectangle> rectangles)
        {
            Console.WriteLine("LINQ Review");
            Console.WriteLine("------------");
            //selects all rectangles with an area <= 15
             
            IEnumerable<Rectangle> smallRectangles =
                from r in rectangles
                where r.Area() <= 15
                select r;

            //add elements after specifying the query
            rectangles.Add(new Rectangle(10, 1));
            rectangles.Add(new Rectangle(12, 12));
            rectangles.Insert(0, new Rectangle(11, 1));

            Console.WriteLine($"all rectangles: {string.Join(" ", rectangles)}");
            Console.WriteLine();
            //notice the deferred execution
            //10,1 and 12,12 is part of the small rectangles
            Console.WriteLine($"small rectangles: {string.Join(" ", smallRectangles)}");
            Console.WriteLine();
            //group by width

            Console.WriteLine("Group by width");
            var widths =
                from w in rectangles
                group w by w.Width into ws
                orderby ws.Key
                select new { Width = ws.Key, Rec = ws };

            foreach (var group in widths)
            {
                Console.WriteLine($"{group.Width}: {string.Join(" ", group.Rec)}");

            }


        }
    }
}
