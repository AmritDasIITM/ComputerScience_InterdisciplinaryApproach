public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);

        if ( a == 0 && b == 0 ) return 0;
        else if ( a == 0 && b != 0 ) return b;
        else if ( b == 0 && a != 0 ) return a;
        else {
            while ( a != 0 && b != 0 ){
                int temp = a;
                a = b;
                b = temp % b;
            }
            if ( a == 0 ) return b;
            else return a;
        }

    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);

        if ( a == 0 && b == 0 ) return 0;
        else return (a/gcd(a,b))*b;
    }


    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b){
        if (gcd (a,b)==1) return true;
        else return false;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n){
        if ( n <= 0 ) return 0;
        else{
            int count=0;
            for ( int i =1; i < n; i++){
                if (areRelativelyPrime(n,i)) count +=1;
            }
            return count;
        }
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int n1 = Integer.parseInt( args[0] );
        int n2 = Integer.parseInt( args[1] );

        StdOut.println("gcd(" + n1 + ", "+ n2 +") = " + gcd(n1,n2));
        StdOut.println("lcm(" + n1 + ", "+ n2 +") = " + lcm(n1,n2));
        StdOut.println("areRelativelyPrime(" + n1 + ", "+ n2 +") = " + areRelativelyPrime(n1,n2));
        StdOut.println("totient(" + n1 + ") = " + totient(n1));
        StdOut.println("totient(" + n2 + ") = " + totient(n2));
    }
}
