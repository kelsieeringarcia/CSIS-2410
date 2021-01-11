using System;
using System.IO;

namespace FileIO
{
    class Program
    {
        static void Main(string[] args)
        {
            string file = "ResourceFolder/Words.txt";
            try
            {
                using (StreamReader reader = new StreamReader(file))
                {
                    string line;
                    while ((line = reader.ReadLine()) != null)
                    {
                        try
                        {
                            char firstDuplicateChar = Strings.GetFirstDuplicate(line);
                            Console.WriteLine($"First duplicate character in {line}: {firstDuplicateChar}");
                        }
                        catch (ArgumentException ex)
                        {
                            Console.WriteLine();
                            Console.WriteLine($"Problem identifying the first duplicate");
                            Console.WriteLine(ex.Message);
                            Console.WriteLine();
                        }
                    }
                }
            }
            catch (IOException ex)
            {
                Console.WriteLine($"A problem occured reading the file {file}");
                Console.WriteLine(ex.Message);
            }
        }
    }
}
