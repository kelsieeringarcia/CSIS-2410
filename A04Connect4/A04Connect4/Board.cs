using System;
namespace A04Connect4
{
    /// <summary>
    /// This class is for creating the connect 4 board
    /// Authors: Kelsie Garcia and Chad Zuniga
    /// </summary>
    public class Board
    {
        private int columns = 7;
        private int rows = 6;
        public int Rows { get { return rows; } }
        //set available slots to false and unavailable to true
        private bool[,] grid = new bool[6, 7];
        public bool[,] Grid { get { return grid; } }

        /// <summary>
        /// This is the constructor for the players board
        /// for a new game
        /// </summary>
        public Board()
        {
        }
        /// <summary>
        /// This method draws the board with the column/row headers
        /// along with the borders of the columns
        /// </summary>
        public void Draw()
        {
            Console.WriteLine("    1  2  3  4  5  6  7 ");//column label

            for (int i = 0; i < rows; i++)
            {
                Console.BackgroundColor = ConsoleColor.Black;
                Console.Write(i + 1 + " ");//row label
                Console.BackgroundColor = ConsoleColor.DarkGray;
                Console.Write(" ");//boarder on the side
                for (int j = 0; j < (columns * 2); j++)
                {

                    if (j % 2 == 0)
                    {   //columns
                        Console.BackgroundColor = ConsoleColor.Gray;
                        Console.Write("  ");
                    }
                    else
                    {   //borders
                        Console.BackgroundColor = ConsoleColor.DarkGray;
                        Console.Write(" ");
                    }

                }
                //prints on the next line
                Console.WriteLine();
            }
            setBoardEmpty();
        }

        /// <summary>
        /// This method sets all the the column slots to false
        /// so that it shows the slots are not filled with player tokens
        /// </summary>
        private void setBoardEmpty()
        {
            for(int i = 0; i < rows; i++)
            {
                for(int j = 0; j < columns; j++)
                {
                    grid[i, j] = false;
                }
            }
        }

        //We should make another method, or insert here how we are going to stack
        //the pieces on top of eachother
        public static void PlacePiece(int column, int row, ConsoleColor color)
        {
            Console.SetCursorPosition((column*3), 10 - row);
            Console.BackgroundColor = ConsoleColor.Gray;
            Console.ForegroundColor = color;
            Console.Write("⬤");
        }


    }
}