public class RevesPuzzle {

    private static void hanoi(int start, int last, String from, String middle, String to){
        if ( (last - start) == 0 ) StdOut.println("Move disc " + last + " from " + from + " to " + to);
        else{
            hanoi( start, last-1, from, to, middle );
            StdOut.println("Move disc " + last + " from " + from + " to " + to);
            hanoi( start, last-1, middle, from, to );
        }
    }

    private static void reve(int n, String from, String mid1, String mid2, String to){
        if ( n == 1 ) StdOut.println("Move disc " + n + " from " + from + " to " + to);
        else{
            int k = (int)Math.round( n + 1 - Math.sqrt( 2*n + 1 ) );
            reve( k, from, to, mid2, mid1 );
            hanoi( k+1, n, from, mid2, to );
            reve( k, mid1, from, mid2, to  );
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String pole1 = "A";
        String pole2 = "B";
        String pole3 = "C";
        String pole4 = "D";
        reve(n,pole1,pole2,pole3,pole4);
    }
}
