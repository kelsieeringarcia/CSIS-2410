using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Delegate
{

    public class Program
    {
        static List<int> data = new List<int> { 3, 5, 7 };

        static void Main(string[] args)
        {
            DrawAll(ConsoleDrawing.Square);
            DrawAll(ConsoleDrawing.Triangle);
            DrawAll(n => ConsoleDrawing.Frame(n, 2 * n));
            DrawAll(n => ConsoleDrawing.Line(n, '~'));
            DrawAll(n =>ConsoleDrawing.Diamond5x5());
        }


        private static void DrawAll(Action<int> drawMethod)
        {
            foreach (int number in data)
            {
                drawMethod(number);
                Console.WriteLine();
            }
        }
    }
}
