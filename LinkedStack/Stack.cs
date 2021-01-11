using System;
using System.Text;

namespace LinkedStack
{
    public class Stack<T>
    {
        private Node top;
        private int size;
        public Stack()
        {
            top = null;
            size = 0;
        }

        private class Node
        {
            internal T item;
            internal Node next;

        }

        public void Push(T item)
        {
            Node newNode = new Node();
            newNode.item = item;
            if (isEmpty())
                newNode.next = null;
            else
                newNode.next = top;

            top = newNode;
            size++;
        }

        public T Pop()
        {
            if (isEmpty())
                throw new InvalidOperationException("Can't pop from an empty stack.");
            T topItem = top.item;
            top = top.next;
            size--;
            return topItem;
        }

        public int Size()
        {
            return size;
        }

        public bool isEmpty()
        {
            return size == 0;
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            Node current = top;
            while(current != null)
            {
                sb.Append(current.item).Append(" ");
                current = current.next;
            }

            return sb.ToString();
        }

    }
}
