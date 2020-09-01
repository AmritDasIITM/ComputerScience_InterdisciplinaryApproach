public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k=0;
        while( Math.pow(2,k) < Math.pow(n,2)){
            k+=1;
        }
        int len = (int)Math.pow(2,k);

        int[] thuearr = new int[len];

        for(int i=0; i < k; i++ ){
            for ( int j = (int)Math.pow(2,i); j < (int)Math.pow(2,i+1); j++){
                thuearr[j] = 1 - thuearr[j-(int)Math.pow(2,i)];
            }
        }
        String[] strarr = new String[thuearr.length];

        for ( int i = 0; i < thuearr.length; i++ ){
            if ( thuearr[i] == 1 ) strarr[i] = "-";
            else strarr[i] = "+";
        }

        for(int i=0; i < n; i++ ){
            for ( int j = 0; j < n; j++){
                System.out.print(strarr[n*i+j]+" ");
            }
            System.out.println("");
        }

    }
}
