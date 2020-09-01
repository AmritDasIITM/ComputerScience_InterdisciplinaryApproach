import java.util.Arrays;

public class MaximumSquareSubmatrix {

    // Calculates the minimum.
    private static int minimum( int a , int b, int c ){
        int min = a;
        if ( b < min ) min = b;
        if ( c < min ) min = c;
        return min;
    }

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a){

        int [][] Dparr = new int[a.length][a[0].length];
        int size = 0;
        for ( int i = 0; i < a.length; i++ ){
            for ( int j = 0; j < a[0].length; j++ ){
                if ( i == 0 || j == 0 ) {
                    Dparr[i][j] = a[i][j];
                    if ( Dparr[i][j] > size ) size = Dparr[i][j];
                }
                else{
                    if ( a[i][j] == 0 ) Dparr[i][j]=0;
                    else {
                        Dparr[i][j] = minimum( Dparr[i-1][j], Dparr[i][j-1], Dparr[i-1][j-1] ) + 1;
                        if ( Dparr[i][j] > size ) size = Dparr[i][j];
                    }
                }
            }
        }
        return size;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args){
        int n = StdIn.readInt();
        int[][] arr = new int[n][n];

        for ( int i = 0; i < n; i++ ){
            for ( int j = 0; j < n; j++ ){
                arr[i][j] = StdIn.readInt();
            }
        }

        StdOut.println(size(arr));
    }
}
