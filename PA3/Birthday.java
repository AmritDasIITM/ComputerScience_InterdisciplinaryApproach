public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int[] clashcount = new int[n+1];

        for( int k = 0; k < trials; k++){
            int[] presentarr = new int[n+1];
            boolean clash = false;
            for( int i = 0; i < n+1; i++ ){
                int rand = (int)(Math.random()*n);
                for( int j = 0; j < i; j++ ){
                    if (presentarr[j]== rand){
                        clash = true;
                    }
                }
                if (!clash) {presentarr[i] = rand;}
                else {clashcount[i] += 1; break;}
            }
        }

        double total = 0;
        int count = 1;
        double frac = 0;
        while (frac < 0.5){
            total += clashcount[count-1];
            frac = total/trials;
            System.out.println(count+" "+clashcount[count-1]+" "+frac);
            count+=1;
        }
    }
}
