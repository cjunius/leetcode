// https://leetcode.com/problems/climbing-stairs
class Solution {

    // Uses Fibonacci Sequence F(n) = F(n-1) + F(n-2); 1, 2, 3, 5, 8, 13...

    public int climbStairs(int n) {
        return climbStairs_Array(n);
        //return climbStairs_Recursive(n);
        //return climbStairs_Formula_Phi(n);
        //return climbStairs_Formula_PhiAndphi(n);
    }

    public int climbStairs_Array(int n) {
        if(n<=3) return n;

        int[] a = new int[n+1];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;

        for(int i=4; i<=n; i++) {
            a[i] = a[i-1] + a[i-2];
        }
        return a[n];
    }

    // Exceeds Time Limit
    public int climbStairs_Recursive(int n) {
        if(n <= 3) return n;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    public int climbStairs_Formula_Phi(int n) {
        if(n <= 3) return n;
        double Phi = Fibonacci_Sequence.calculate_Phi(n);
        return Fibonacci_Sequence.calculate_fibonacci_sequence(Phi);
    }

    public int climbStairs_Formula_PhiAndphi(int n) {
        if(n <= 3) return n;
        double Phi = Fibonacci_Sequence.calculate_Phi(n);
        double phi = Fibonacci_Sequence.calculate_phi(n);
        return Fibonacci_Sequence.calculate_fibonacci_sequence(Phi, phi);
    }

    class Fibonacci_Sequence {

        public static double calculate_Phi(int n) {
            return Math.pow(((1+Math.sqrt(5))/2), n+1);
        }

        public static double calculate_phi(int n) {
            return Math.pow(((1-Math.sqrt(5))/2), n+1);
        }

        public static int calculate_fibonacci_sequence(double Phi) {
            double phi = -1/Phi;
            return calculate_fibonacci_sequence(Phi, phi);
        }

        public static int calculate_fibonacci_sequence(double Phi, double phi) {
            return new Double((Phi-phi)/Math.sqrt(5)).intValue();
        }

    }

    
}
