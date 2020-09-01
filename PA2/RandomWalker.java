public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);

        int x = 0;
        int y = 0;
        int step = 0;
        System.out.println("("+x+", "+y+")");
        while(Math.abs(x) + Math.abs(y) < r){
            double rand = Math.random();
            if(rand < 0.25){
                x -= 1;
            }else if (rand < 0.5){
                x += 1;
            }else if (rand < 0.75){
                y -= 1;
            }else{
                y += 1;
            }
            System.out.println("("+x+", "+y+")");
            step += 1;
        }
        System.out.println("steps = "+step);
    }
}
