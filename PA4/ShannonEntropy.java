public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);

        int[] freq = new int[m];
        int count = 0;

        while ( !StdIn.isEmpty() ) {
            int num = StdIn.readInt();
            count+=1;
            freq[num-1] += 1;
        }
        double[] prob = new double[m];
        for (int i = 0; i < prob.length; i++ ){
            prob[i] = (double) freq[i]/count;
        }

        double entropy = 0;
        for (double v : prob) {
            if (v != 0.0) {
                entropy += -v * Math.log(v) / Math.log(2);
            }
        }
        System.out.format("%.4f", entropy);
    }
}

