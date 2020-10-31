using System;
namespace A04Connect4
{
    /// <summary>
    /// This class is used for playing the game of connect 4
    /// Authors: Kelsie Garcia and Chad Zuniga
    /// </summary>
    public class Play
    {
        Board board;
        Player[] players;
        private int turn = 1;
        ConsoleColor currentColor;
        ConsoleColor previousColor;

        /// <summary>
        /// This is constructing a game played by the constructed players
        /// </summary>
        /// <param name="player1"></param>
        /// <param name="player2"></param>
        public Play(string player1, string player2)
        {
            board = new Board();
            players = new Player[] {new Player(ConsoleColor.Red, player1), new Player(ConsoleColor.Black, player2)};
        }

        void SetUp()
        {
            board.Draw();
            foreach (Player el in players)
            {
                Console.WriteLine(el.Name);
            }

            currentColor = players[0].Color;


        }

        string GetTurn()
        {
            string player;
            //if (currentColor == players[0].Color)
            //{
            //player = players[0].Name;
            //currentColor = players[1].Color;
            //previousColor = players[0].Color;
            //}
            //else
            //{
            //player = players[1].Name;
            //currentColor = players[0].Color;
            //previousColor = players[1].Color;
            //}
            if (turn % 2 == 0)
            {
                player = players[1].Name;
                currentColor = players[0].Color;
                previousColor = players[1].Color;
            }
            else
            {
                player = players[0].Name;
                currentColor = players[1].Color;
                previousColor = players[0].Color;
            }

            return player;
        }

        /// <summary>
        /// This method is playing the game from the beginning
        /// </summary>
        public void PlayGame()
        {
            SetUp();

            int top = 15;
            bool gameOver = false;
            while (!gameOver)
            {

                int col;
                var input = "";
                var name = "";
                bool isValid = false;
                do
                {
                    Console.BackgroundColor = ConsoleColor.Black;
                    Console.ForegroundColor = ConsoleColor.White;
                    Console.SetCursorPosition(0, top);
                    if(turn % 2 == 0)
                    {
                       name = players[1].Name;
                    }
                    else
                    {
                        name = players[0].Name;
                    }
                    Console.Write($"{name}'s turn. Select a Column: ");
                    input = Console.ReadLine();
                    //checking for input validation
                    isValid = int.TryParse(input, out col);
                    if(col < 0 || col > 8)
                    {
                        isValid = false;
                    }
                    else
                    {
                        for(int i = 0; i < board.Rows; i++)
                        {
                            if(board.Grid[i,col] == false)
                            {   //Checks to see if there is an available row
                                //to play at selected column.
                                board.Grid[i, col] = true;
                                Board.PlacePiece(col, i, previousColor);
                                break;
                            }
                            else
                            {
                                col = -1;
                            }
                        }
                    }
                } while (isValid == false);
                
                //Changing turn outside of do while loop
                GetTurn();
                turn++;
                //draws players on the board
                //Board.PlacePiece(col,previousColor);
            }
        }
    }
}
