using System;
using System.Collections.Generic;
using System.Net;
using System.Text.RegularExpressions;
using System.Linq;

namespace DemoUrl
{
    class Program
    {
        static void Main(string[] args)
        {
            string url = "http://www.glozman.com/TextPages/Harry%20Potter%201%20-%20Sorcerer%27s%20Stone.txt";
            string text = string.Empty;
            try
            {

                using (WebClient client = new WebClient())
                {
                    text = client.DownloadString(url);
                }
            }
            catch(WebException ex)
            {
                Console.WriteLine($"A problem occurred accessing {url}");
                Console.WriteLine(ex.StackTrace);
            }

            string[] words = Regex.Split(text, "\\W+");

            // Word count
            Dictionary<string, int> wordCountST = new Dictionary<string, int>();
            foreach(string w in words)
            {
                if (wordCountST.ContainsKey(w))
                {
                    wordCountST[w]++;
                }
                else
                {
                    wordCountST.Add(w,1);
                }
            }
            //order a-z
            //Console.WriteLine($"{string.Join("\n", wordCountST.OrderBy(x => x.Key).Select(x => $"{x.Key}..{x.Value}"))}");
            //order 
            //Console.WriteLine($"{string.Join("\n", wordCountST.OrderBy(x => x.Value).Select(x => $"{x.Key}..{x.Value}"))}");
            //Specific word
            //Console.WriteLine($"{string.Join("\n", wordCountST.Where(x => x.Key.ToLower() ).Select(x => $"{x.Key}..{x.Value}"))}");
        }
    }
}
