using System;

namespace A04Connect4
{
    class Program
    {
        static void Main(string[] args)
        {
            
            Console.WriteLine("Player1: ");
            string p1 = Console.ReadLine();
            Console.WriteLine("Player2: ");
            string p2 = Console.ReadLine();

            Play play = new Play(p1,p2);
            play.PlayGame();
        }
    }
}
