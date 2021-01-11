using System;

namespace LabHorseRace
{
    class Program
    {
        static void Main(string[] args)
        {
            Race race = new Race();
            race.Start();
            //press any key to continue
            Console.CursorTop += 3;
            Console.BackgroundColor = ConsoleColor.Black;
            Console.ForegroundColor = ConsoleColor.DarkGray;
        }
    }
}
