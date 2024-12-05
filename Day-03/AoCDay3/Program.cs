using System.Globalization;
using System.Numerics;
using System.Runtime.CompilerServices;
using System.Runtime.InteropServices;
using System.Text.RegularExpressions;

namespace AoCDay3 {

    class Program {
        static void Main(string[] args){
            string filepath = "C:\\Users\\trevo\\Documents\\aocDay3Input.txt";
            string fileContent = File.ReadAllText(filepath);
            string pattern = @"mul\((\d+),\s*(\d+)\)"; // mul(int,int) REGEX
            List<List<int>> muls = new List<List<int>>();
            Regex regex = new Regex(pattern);
            MatchCollection matches = regex.Matches(fileContent);

            foreach (Match match in matches){
                List<int> pair = new List<int>(); // NEW X/Y PAIR OF INTS FOR EACH mul(_,_) MATCH
                int x = int.Parse(match.Groups[1].Value);
                int y = int.Parse(match.Groups[2].Value);
                pair.Add(x);
                pair.Add(y);
                muls.Add(pair); // ADD LIST OF PAIRS TO OUTER LIST
            }
            int total = 0;
            foreach(var pair in muls){
                Console.WriteLine(pair[0] + " : " + pair[1]); // PROOF OF MUL VALUES BEING APPENDED TO MULS LIST
                total += pair[0] * pair[1];
            }
            Console.WriteLine("Total: " + total); // DAY 3 ANSWER 1
        }
    }
}