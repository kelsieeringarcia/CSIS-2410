using System;
using System.Collections.Generic;

namespace DemoGenerics
{
    /// <summary>
    /// Demo on how to use generic Queue
    ///
    /// Author: Kelsie Garcia
    /// </summary>
    public class DemoQueue
    {
        #region DemoQueue
        public static void Demo()
        {
            Console.WriteLine("Demo Queue");
            Console.WriteLine("----------");

            // create queue of strings called queue
            Queue<string> queue = new Queue<string>();

            // add 3 people
            queue.Enqueue("Arron");
            queue.Enqueue("Ben");
            queue.Enqueue("Carl");

            // use foreach to list all people in queue
            PrintQueue(queue);

            // peek to see who is next
            Console.WriteLine($"Who is next? {queue.Peek()}");

            // remove on person
            Console.WriteLine($"{queue.Dequeue()} has been removed");

            // list all members in queue again
            PrintQueue(queue);
            Console.WriteLine();

        }

        private static void PrintQueue(Queue<string> queue)
        {
            foreach (string name in queue)
            {
                Console.Write($"{name} ");
            }
            Console.WriteLine();
        }
        #endregion
    }
}
