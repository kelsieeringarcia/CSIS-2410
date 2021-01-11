using System;
namespace DemoExtensionMethods
{
    /// <summary>
    /// This method is for constructing a rectangle.
    /// </summary>
    public class Rectangle
    {
        public int Length { get; }
        public int Width { get; }

        public Rectangle(int length, int width)
        {
            Length = length;
            Width = width;
        }

        public int Area()
        {
            return Length * Width;
        }

        public override string ToString()
        {
            return $"[ {Length} x {Width} ]";
        }
    }
}
