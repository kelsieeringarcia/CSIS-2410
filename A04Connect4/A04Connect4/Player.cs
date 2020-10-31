using System;
namespace A04Connect4
{
    /// <summary>
    /// This class is for constructing the players with names and colors
    /// Authors: Kelsie Garcia and Chad Zuniga
    /// </summary>
    public class Player
    {
        public ConsoleColor Color { get; private set; }
        public string Name { get; private set; }

        public Player(ConsoleColor color, string name)
        {
            Color = color;
            Name = name;
        }
    }
}
