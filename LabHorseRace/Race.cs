using System;
using System.Threading;

namespace LabHorseRace
{
    /// <summary>
    /// Race that includes a race track and horses
    ///
    /// Author:Kelsie Garcia
    /// </summary>
    public class Race
    {
        private Track track;
        private Horse[] horses;

        private int titleTopPosition = 3;
        private ConsoleColor nativeBackground;
        public Race()
        {

            int trackTopPosition = 5;
            int numberOfLanes = 3;
            int laneLength = 45;
            track = new Track(numberOfLanes, laneLength, trackTopPosition);

            horses = new Horse[]
            {
                new Horse(track, 1, ConsoleColor.Yellow, 1),
                new Horse(track, 2, ConsoleColor.Red, 3),
                new Horse(track, 3, ConsoleColor.Cyan, 2),
            };

            nativeBackground = ConsoleColor.Black;
        }

        public void Start()
        {
            Setup();

            while (!Console.KeyAvailable)
            {
                Thread.Sleep(100);
            }
            DrawTitle("   H O R S E   R A C E   ");

            while (!Done())
            {
                foreach(Horse h in horses)
                {
                    h.Move();
                }
                Thread.Sleep(200);
            }
        }

        private bool Done()
        {
            foreach(Horse h in horses)
            {
                if(h.Position < track.End)
                    return false;
            }
            return true;
        }

        /// <summary>
        /// Prints "Press enter to start" on native background
        /// Draws the track
        /// Positions the horses on the track
        /// </summary>
        private void Setup()
        {
            Console.CursorVisible = false;

            DrawTitle("Press <Enter> to start ...");

            track.Draw();

            foreach(Horse h in horses)
            {
                h.Draw();
            }
        }

        private void DrawTitle(String text)
        {
            Console.SetCursorPosition(0, titleTopPosition);
            Console.BackgroundColor = nativeBackground;
            Console.WriteLine(text);
        }
    }
}
