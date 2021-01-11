using System;
namespace LabCard
{
    public enum Suit { Clubs = 9827, Spade = 9824, Heart = 9829, Diamond = 9830 }
    public enum Rank { Deuce, Three, Four, Five, Six, Seven,
        Eight, Nine, Ten, Jack, Queen, King, Ace}

    /// <summary>
    /// 
    /// </summary>
    public struct Card
    {
        public Rank Rank { get; }
        public Suit Suit { get; }

        public Card(Rank rank, Suit suit)
        {
            Rank = rank;
            Suit = suit;
        }

        public override string ToString()
        {
            return $"{(char)Suit} {Rank}  ";
        }
    }
}
