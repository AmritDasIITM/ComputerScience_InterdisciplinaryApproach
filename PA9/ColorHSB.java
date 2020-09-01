public class ColorHSB {
    private final int hue, sat, br;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h >= 360 || s < 0 || b < 0 || s > 100 || b > 100){
          throw new IllegalArgumentException("Values beyond permitted range");
        }
        else{ hue = h; sat = s; br = b; }
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString(){
        return "(" + hue + ", " + sat + ", " + br + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale(){
        return br == 0 || sat == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if ( that == null ){
            throw new IllegalArgumentException("Invalid input, Give ColorHSB datatype");
        }
        else{
            int t1a, t1b, t2, t3;
            t1a = (hue - that.hue)*(hue - that.hue);
            int var = 360 - Math.abs(hue - that.hue);
            t1b = var * var;
            t2  = (sat-that.sat)*(sat-that.sat);
            t3  = (br-that.br)*(br-that.br);

            if ( t1a > t1b ) return t1b + t2 + t3;
            return t1a + t2 + t3;
        }
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int hue = Integer.parseInt(args[0]);
        int sat = Integer.parseInt(args[1]);
        int br = Integer.parseInt(args[2]);

        ColorHSB our = new ColorHSB(hue, sat, br);
        boolean isGray = our.isGrayscale();
        int besth=0,bests=0,bestb=0;
        String nearest = "";
        int minDist = 360*360+2*100*100;
        while (!StdIn.isEmpty()){
            String name = StdIn.readString();
            int h = StdIn.readInt();
            int s = StdIn.readInt();
            int b = StdIn.readInt();
            ColorHSB stan = new ColorHSB(h, s, b);

            if ( our.distanceSquaredTo(stan) < minDist ){
                minDist = our.distanceSquaredTo(stan);
                nearest = name;
                bestb = b;
                besth = h;
                bests = s;
            }

        }
        ColorHSB near = new ColorHSB(besth, bests, bestb);
        StdOut.println(nearest + " " +near.toString());
    }

}
