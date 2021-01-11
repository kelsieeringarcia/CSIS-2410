using System;
namespace LabHorseRace
{
    public class Track
    {
        public int NumberOfLanes { get; }
        public int Start { get; } //left position
        public int End { get; } //left position
        public ConsoleColor LaneColor { get; }
        private int top;

        public Track(int numberOfLanes, int length, int top)
        {
            NumberOfLanes = numberOfLanes;
            Start = 0;
            End = Start + length;
            LaneColor = ConsoleColor.Gray;
            this.top = top;
        }

        /// <summary>
        /// Returns the top position of the lane based on the
        /// lane numebrs 1 - n, where n is the number of lanes.
        /// </summary>
        /// <param name="laneNumber"></param>
        /// <returns>top position of the specified lane</returns>
        public int topOfLane(int laneNumber)
        {
            return top + laneNumber * 2 - 1;
        }

        /// <summary>
        /// Draws the track based on the field values.
        /// </summary>
        public void Draw()
        {
            ConsoleColor background = ConsoleColor.DarkGreen;
            ConsoleColor laneColor = ConsoleColor.Gray;

            ConsoleColor currentColor = background;
            int length = End - Start;

            for (int i = 0; i < (NumberOfLanes * 2 + 1); i++)
            {
                Console.BackgroundColor = currentColor;
                Console.SetCursorPosition(Start, top + i);
                string formatString = "{0," + length + "}";
                Console.Write(formatString, ' ');
                currentColor = (currentColor == background) ? laneColor : background;

            }


            

        }
    }
}
