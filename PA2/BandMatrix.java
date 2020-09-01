public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        int max,min;
        for( int i = 0; i < n; i++ ){
            for ( int j = 0; j < n; j++ ) {
                min = i-r;
                max = i+r;
                if( max >= j && j >= min ) System.out.print("*" + " ");
                else                       System.out.print(0 + " ");
            }
            System.out.println();
        }
    }
}
