using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LabLinq2
{
    public class Program
    {
        #region student list
        private static List<Student> students = new List<Student> {
            new Student("Don", "CS", 2015, true),
            new Student("Dan", "CS", 2012, true),
            new Student("Dee", "CS", 2013, false),
            new Student("Bob", "CJ", 2013, false),
            new Student("Ben", "CJ", 2013, true),
            new Student("Jan", "FA", 2012, true),
            new Student("Jim", "FA", 2014, false),
            new Student("Rob", "EE", 2015, true),
            new Student("Ray", "EE", 2012, true)
         };
        #endregion

        #region Main
        static void Main(string[] args)
        {
            LinqChallenge2();
        }

        static void LinqChallenge2()
        {
            Console.WriteLine("\nL I N Q   C H A L L E N G E 2:");

            Console.WriteLine("\n\n======= Group students by honor (no group name):");
            groupStudentsByHonorNoGroupName();

            Console.WriteLine("\n\n======= Group students by honor (with group name):");
            groupStudentsByHonorWithGroupName();

            Console.WriteLine("\n\n======= Group students by major:");
            groupStudentsByMajor();

            Console.WriteLine("\n\n======= Group students by first letter of major:");
            groupStudentsByFirstLetterOfMajor();

            Console.WriteLine("\n\n======= Group student names by year:");
            GroupStudentNamesByYear();

            Console.WriteLine("\n\n======= Group student names by year (ordered by year):");
            GroupStudentNamesByYearOrdered();

            Console.WriteLine("\n\n======= Number of students per year:");
            NumberOfStudentsPerYear();

            Console.WriteLine("\n\n======= List Numbered Students:");
            ListNumberedStudents();

            Console.WriteLine("\n\n. . . press enter . . .");
            Console.Read();
        }
        #endregion

        #region groupStudentsByHonor()
        private static void groupStudentsByHonorNoGroupName()
        {
            var studentsByHonor =
                from s in students
                group s by s.Honor;

            foreach (var group in studentsByHonor)
            {
                Console.WriteLine(group.Key ? "Honor Student" : "Student");
                foreach (Student s in group)
                {
                    Console.WriteLine($"    {s}");
                }
            }
        }

        private static void groupStudentsByHonorWithGroupName()
        {
            var studentsByHonor =
                from s in students
                group s by s.Honor into g
                select new { Honor = g.Key, Students = g };

            foreach (var group in studentsByHonor)
            {
                Console.WriteLine(group.Honor ? "Honor Student" : "Student");
                foreach (Student s in group.Students)
                {
                    Console.WriteLine($"    {s}");
                }
            }
        }
        #endregion

        #region groupStudentsByMajor()
        private static void groupStudentsByMajor()
        {
            var studentsByMajor =
                from s in students
                group s by s.Major[0] into g
                select new { Major = g.Key, Students = g };

            foreach (var group in studentsByMajor)
            {
                Console.WriteLine(group.Major);
                foreach (Student s in group.Students)
                {
                    Console.WriteLine($"    {s}");
                }
            }
        }
        #endregion

        #region groupStudentsByFirstLetterOfMajor()
        private static void groupStudentsByFirstLetterOfMajor()
        {
            var studentsByFirstLetterOfMajor =
                 from s in students
                 group s by s.Major into g
                 select new { FirstLetterOfMajor = g.Key, Students = g };

            foreach (var group in studentsByFirstLetterOfMajor)
            {
                Console.WriteLine(group.FirstLetterOfMajor);
                foreach (Student s in group.Students)
                {
                    Console.WriteLine($"    {s}");
                }
            }

        }
        #endregion

        #region GroupStudentNamesByYear
        private static void GroupStudentNamesByYear()
        {
            var StudentNamesByYear =
                from s in students
                group s by s.Year into g
                select new { Year = g.Key, Names = g };

            foreach (var group in StudentNamesByYear)
            {
                Console.WriteLine(group.Year);
                foreach (var n in group.Names)
                {
                    Console.WriteLine($"    {n}");
                }
            }

        }
        #endregion

        #region GroupStudentNamesByYearOrdered
        private static void GroupStudentNamesByYearOrdered()
        {
            var StudentNamesByYear =
                 from s in students
                 orderby s.Year
                 group s.Name by s.Year into g
                 orderby g.Key
                 select new { Year = g.Key, Names = g };

            foreach (var group in StudentNamesByYear)
            {
                Console.WriteLine(group.Year);
                foreach (var n in group.Names)
                {
                    Console.WriteLine($"    {n}");
                }
            }


        }
        #endregion

        #region NumberOfStudentsPerYear
        private static void NumberOfStudentsPerYear()
        {
            var studentCountPerYear =
                from s in students
                orderby s.Year
                group s by s.Year into g
                
                select new { Year = g.Key, Count = g.Count()};

            foreach (var group in studentCountPerYear)
            {
                Console.WriteLine($"{group.Year}: {group.Count} students");

            }

        }
        #endregion

        #region ListNumberedStudents
        private static void ListNumberedStudents()
        {
            IEnumerable<string> indextStudents = students.Select((s, i) => $"{i}: {s} ");
            Console.WriteLine(string.Join("\n", indextStudents));
        }
        #endregion
    }
}
