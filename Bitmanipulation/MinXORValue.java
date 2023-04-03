/*Min Xor Value
Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value.

Return the minimum XOR value.

Input Format
First line contains n (Size of the array )

Second line contains n integers (Elements of array A)

Output Format
Print a single integer denoting minimum xor value

Example 1
Input

4
0 2 5 7
Output

2*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // Read the size of the array
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();  // Read the next integer
            A.add(num);              // Add it to the arraylist
        }
        int minXor = findMinXor(A);  // Call the method to find minimum XOR value
        System.out.println(minXor);  // Print the result
    }
    
    public static int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);  // Sort the arraylist to easily compare adjacent elements
        int minXor = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - 1; i++) {
            int currXor = A.get(i) ^ A.get(i + 1);  // Calculate XOR of current and next elements
            minXor = Math.min(minXor, currXor);     // Keep track of minimum XOR value seen so far
        }
        return minXor;
    }
}
