using System;
using System.Collections.Generic;

namespace Delegate
{
    public class Program
    {
        // TODO 1 and 2:
        //Inside the class Program create the following field:
        //a static generic list of integers named data.
        //Initialize it with a new List that has three elements: 3, 5, and 7

//      Implement the method DrawAll
//      The comment above the method describes the functionality it should provide
        public static List<int> data = new List<int> { 3, 5, 7 };


        static void Main(string[] args)
        {
            Action<int> draw = ConsoleDrawing.Triangle;
            // TODO 3 - TODO 6
//            Inside the main method call the method DrawAll. Pass the static method ConsoleDrawing.Triangle as an argument.You can do that because this method matches the signature specified in the parameter of DrawAll.
//Run the program.You should see three triangles of different sizes
//Comment out the DrawAll method call.
//Now call DrawAll again but this time pass the static method ConsoleDrawing.Square as an argument.
//Run the program.You should see three squares of different sizes

            //DrawAll(ConsoleDrawing.Triangle);
            //DrawAll(ConsoleDrawing.Square);
            //DrawAll(draw);
            draw += ConsoleDrawing.Square;
            DrawAll(draw);



        }

        /// <summary>
        ///  Loops through all the numbers in the list data. 
        ///  for each of the numbers it calls the method(s) associated with the delegate drawMethod
        ///  and passes the number as parameter
        ///  After each call of drawMethod the cursor is advanced to the next line
        /// </summary>
        /// <param name="drawMethod"></param>
        private static void DrawAll(Action<int> drawMethod)
        {
            foreach (int el in data)
            {
                drawMethod(el);
            }
        }
    }
}
