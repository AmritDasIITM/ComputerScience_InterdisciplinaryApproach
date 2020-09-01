public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k){
        if ( n ==0 && k == 0 ) return 1;
        else if ( k > n ||  k < -n ) return 0;
        else{
            long[][] coef = new long[n+1][2*n+1];
            coef[0][0]=1;
            for ( int row = 1; row <= n; row++ ){
                for ( int col = 0; col < 2*n+1; col++ ){
                    if ( col == 0 ) coef[row][col] = coef[row-1][col];
                    else if ( col == 1 ) coef[row][col] = coef[row-1][col] + coef[row-1][col-1];
                    else coef[row][col] = coef[row-1][col] + coef[row-1][col-1] + coef[row-1][col-2];
                }
            }
            return coef[n][n+k];
        }
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        StdOut.println(trinomial(n,k));
    }
}
