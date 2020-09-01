public class CMYKtoRGB {
    public static void main(String[] args) {
        double C = Double.parseDouble(args[0]);
        double M = Double.parseDouble(args[1]);
        double Y = Double.parseDouble(args[2]);
        double K = Double.parseDouble(args[3]);

        int r,g,b;
        double white = 1-K;

        r = (int)(255 * white * (1-C));
        g = (int)(255 * white * (1-M));
        b = (int)(255 * white * (1-Y));

        System.out.println("red   = "+r);
        System.out.println("green = "+g);
        System.out.println("blue  = "+b);
    }
}
