public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n){
        int count = 0;
        for( long num = 1; num < Math.cbrt(n); num++){
            long num2 = n - (long)Math.pow(num,3);
            double cbrtnum2 = Math.cbrt(num2);
            int intcbrtnum2 = (int)Math.cbrt(num2);
            if(intcbrtnum2>0){
                if (cbrtnum2 - intcbrtnum2 == 0.0){ count += 1;}}
        }
        return count == 4;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args){
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}
