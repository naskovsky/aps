/*
Divisors of 42 are : 1, 2, 3, 6, 7, 14, 21, 42. These divisors squared are: 1, 4, 9, 36, 49, 196, 441, 1764.
The sum of the squared divisors is 2500 which is 50 * 50, a square!

Given two integers m, n (1 <= m <= n) we want to find all integers between m and n whose sum of squared divisors is itself a square. 42 is such a number.

The result will be an array of arrays or of tuples (in C an array of Pair) or a string, each subarray having two elements,
first the number whose squared divisors is a square and then the sum of the squared divisors.

#Examples:

list_squared(1, 250) --> [[1, 1], [42, 2500], [246, 84100]]
list_squared(42, 250) --> [[42, 2500], [246, 84100]]
250, 500 == [[287, 84100]]
300, 600 == []
600, 1500 == [[728, 722500], [1434, 2856100]]
*/

package KirilAlgoritmi;

import java.util.*;
import java.lang.Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static boolean checkPerfectSquare(double x) {

        // finding the square root of given number
        double sq = Math.sqrt(x);

        /* Math.floor() returns closest integer value, for
         * example Math.floor of 984.1 is 984, so if the value
         * of sq is non integer than the below expression would
         * be non-zero.
         */
        return ((sq - Math.floor(sq)) == 0);
    }

    public static String listSquared(long m, long n) {
        ArrayList<String> lista = new ArrayList<>();
        int counter = 0;
        for (long i = m; i <= n; i++) {
            long jPom = 0;
            int suma = 0;
            int br = 0;
            for (long j = 1; j <= i; j++) {
                if (i % j == 0) {
                    int rez = (int) Math.pow(j, 2);
                    suma += rez;
                    br++;
                }
                jPom = j;
            }
            if (checkPerfectSquare(suma) && br >= 1) {
                String strr = "[" + jPom + ", " + suma + "]";
                lista.add(strr);
            }
        }

        return lista.toString();
    }

    public static void main(String[] args) throws IOException {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        String str = "1 9 3 4 -5";
        String str2 = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0};
        //int[] result = DataReverse(arr);*/
        String result = listSquared(1, 250);

        System.out.println(result);
    }
}
