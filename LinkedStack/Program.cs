using System;

namespace LinkedStack
{
    class Program
    {
        static void Main(string[] args)
        {
            Stack<string> stack = new Stack<string>();
            stack.Push("A");
            stack.Push("B");
            stack.Push("C");

            for(int i = 0; i < 3; i++)
            {
                Console.WriteLine(stack.Pop());
            }

            Stack<int> stack2 = new Stack<int>();
            Console.WriteLine(stack.Pop());
            stack2.Push(10);
            stack2.Push(12);
            stack2.Push(20);

            for (int i = 0; i < 3; i++)
            {
                Console.WriteLine(stack.Pop());
            }
        }
    }
}
