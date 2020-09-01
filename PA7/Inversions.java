public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a){
        int count = 0;
        for ( int i = 0; i < a.length; i++ ){
            for ( int j = i + 1; j < a.length; j++ ){
                if (a[i]  > a[j]) count += 1;
            }
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k){
        int[] arr = new int[n];
        for ( int i = n-1; i>=0; i--){
            if ( k > i ) {
                arr[n-1-i] = i;
                k = k - i;
            }
            else if ( k == i ){
                arr[n-1-i] = i;
                int num = 0;
                for ( int j = 0; j < n; j++ ){
                    if ( j > n-1-i ){
                        arr[j] = num;
                        num+=1;
                    }
                }
                break;
            }
            else{
                arr[n - 1 -  (int)k ] = i;
                int num = 0;
                for ( int j = 0; j < n; j++ ){
                    if ( j >= n-1-i && j != (n  - 1 - (int)k) ){
                        arr[j] = num;
                        num+=1;
                    }
                }
                break;
            }
        }
        return arr;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] arr = generate(n,k);
        for ( int i = 0; i < arr.length; i++ ){
            StdOut.print(arr[i] + " ");
        }


    }
}
