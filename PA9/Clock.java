public class Clock {
    private int hr, min;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m){
        if ( h < 0 || h > 23 || m < 0 || m > 59 ){ throw new IllegalArgumentException("Invalid inputs, beyond legal range");}
        else{ hr = h; min = m; }
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s){
        if (s.length() != 5) {throw new IllegalArgumentException("Invalid String length");}
        else if (!s.substring(2,3).equals(":")) {throw new IllegalArgumentException("Invalid format");}
        else{
            int h = Integer.parseInt(s.substring(0,2));
            int m = Integer.parseInt(s.substring(3,5));
            if ( h < 0 || h > 23 || m < 0 || m > 59 ){ throw new IllegalArgumentException("Invalid inputs, beyond legal range");}
            else { hr = h; min = m; }
        }
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString(){
        if (hr < 10 && min < 10) { return "0" + hr + ":" + "0" + min ; }
        else if (min < 10) { return hr + ":" + "0" + min ; }
        else if (hr < 10) { return "0" + hr + ":" + min ; }
        else { return  hr + ":" + min ; }
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that){
        if (hr < that.hr) return true;
        else if (hr > that.hr) return false;
        else{
            if ( min < that.min ) return true;
            return false;
        }
    }

    // Adds 1 minute to the time on this clock.
    public void tic(){
        if ( min != 59 ){ min += 1; }
        else {
            hr+=1;
            min=0;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta){
        int now = hr*60+min;
        now += delta;
        now = now%(24*60);
        hr = now/60;
        min = now%60;
    }

    // Test client (see below).
    public static void main(String[] args){
        Clock c1 = new Clock(3,30);
        Clock c2 = new Clock("04:15");
        Clock c3 = new Clock(3,5);

        StdOut.println(c1.toString());
        StdOut.println(c2.toString());
        StdOut.println(c3.toString());

        StdOut.println(c1.isEarlierThan(c1));
        StdOut.println(c1.isEarlierThan(c2));
        StdOut.println(c1.isEarlierThan(c3));

        c1.tic();
        StdOut.println(c1.toString());

        c1.toc(1439);
        StdOut.println(c1.toString());

    }
}
