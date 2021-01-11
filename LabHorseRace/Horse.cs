using System;
namespace LabHorseRace
{
    public class Horse
    {
        public ConsoleColor Color { get; }
        private int laneNumber;
        private Track track;
        private int stride;
        public int Position { get; private set; } //position from the left
        

        public Horse(Track track, int laneNumber, ConsoleColor color, int speed)
        {
            Color = color;
            this.track = track;
            this.laneNumber = laneNumber;
            this.stride = speed;
            Position = track.Start;
        }

        public void Draw()
        {
            DrawColor(Color);
        }

        public void Move()
        {
            DrawColor(track.LaneColor);//erasing old position of the horse
            Position = Math.Min(Position + stride, track.End);
            DrawColor(Color);
        }

        public void DrawColor(ConsoleColor color)
        {
            Console.SetCursorPosition(Position, track.topOfLane(laneNumber));
            Console.BackgroundColor = color;
            Console.Write(' ');
        }
    }
}
