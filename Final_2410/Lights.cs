using System;
namespace Final_2410
{
    public enum Usage { Indoor = 'I', Outdoor = 'O', Both = 'B' };
    /// <summary>
    /// This struct is used to construct different kind of lights
    /// 
    /// Author: Kelsie Garcia
    /// </summary>
    public struct Lights
    {
        public Usage Usage { get; }
        public int Length { get; set; }
        public bool Blinking { get; set; }

        /// <summary>
        /// Constructor of the lights
        /// </summary>
        /// <param name="usage"></param>
        /// <param name="length"></param>
        /// <param name="blinking"></param>
        public Lights(Usage usage, int length, bool blinking)
        {
            this.Usage = usage;
            this.Length = length;
            this.Blinking = blinking;
        }

        /// <summary>
        /// This method is used to display the created lights
        /// </summary>
        public void Display()
        {
            Console.Write($"[{(char)Usage}]");
            for (int i = 0;  i < Length; i++)
            {
                Console.Write($"{(Blinking ? '*' : 'o')}");
            }
            Console.WriteLine();
        }

        /// <summary>
        /// This method is to override the string to show something specific
        /// </summary>
        /// <returns></returns>
        public override string ToString()
        {
            return $"{(char)Usage}({Length}){(Blinking ? '*' : ' ')}";
        }
    }
}
