public class DiscreteDistribution {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] probs = new int[args.length - 1];
        for( int i = 0; i < probs.length; i++){
            probs[i] = Integer.parseInt(args[i+1]);
        }
        int[] cumarr = new int[probs.length+1];
        for( int i = 1; i < cumarr.length; i++){
            cumarr[i] = cumarr[i-1]+probs[i-1];
        }

        for( int i = 0; i < n; i++){
            double rand = Math.random()*cumarr[cumarr.length-1];
            for(int j=0; j < cumarr.length; j++){
                if ( rand >= cumarr[j] && rand < cumarr[j+1] ){
                    System.out.print(j+1+" ");
                }
            }
        }
    }
}
