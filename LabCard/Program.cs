using System;

namespace LabCard
{
    class Program
    {
        static void Main(string[] args)
        {
            //foreach(Suit s in Enum.GetValues(typeof(Suit)))
            //{
            //    //Console.Write($"[{s} {(char)s}] ");
            //}
            //Console.WriteLine();
            Card card1 = new Card(Rank.Ace, Suit.Heart);
            Card card2 = new Card(Rank.King, Suit.Diamond);
            Console.WriteLine($"{card1}{card2}");
        }
    }
}
