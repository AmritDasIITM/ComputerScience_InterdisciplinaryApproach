public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);


        int sum = 0;
        for( int i =0; i < trials; i++ ) {
            int x = 0;
            int y = 0;
            while (Math.abs(x) + Math.abs(y) < r) {
                double rand = Math.random();
                if (rand < 0.25) {
                    x -= 1;
                } else if (rand < 0.5) {
                    x += 1;
                } else if (rand < 0.75) {
                    y -= 1;
                } else {
                    y += 1;
                }
                sum += 1;
            }
        }
        double avgsteps = (double) sum / trials;
        System.out.println("average number of steps = "+ avgsteps);
    }
}
