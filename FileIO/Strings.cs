using System;
using System.Collections.Generic;

namespace FileIO
{
    public class Strings
    {

        /// <summary>
        /// Determines the first character ithat occurs more than once
        /// in the string text
        /// If text has no duplicates, it returns '\0'.
        /// If the text is empty or null, and ArgumentException should be thrown
        ///
        /// </summary>
        /// <param name="text"></param>
        /// <returns></returns>
        /// <exception cref="System.ArgumentException"> Thrown if text is empty or null</exception>
        public static char GetFirstDuplicate(String text)
        {
            if (text == null || text == string.Empty)
                throw new ArgumentException("The text cant be empty nor null");
            Dictionary<char, int> occurances = new Dictionary<char, int>();
            foreach(char c in text)
            {
                if (!occurances.ContainsKey(c))
                    occurances.Add(c, 1);
                else
                    occurances[c] += 1;

            }

            foreach (char c in text)
            {
                if (occurances[c] > 1)
                    return c;
            }

                return '\0';// string has no duplicates
        }

    }
}
