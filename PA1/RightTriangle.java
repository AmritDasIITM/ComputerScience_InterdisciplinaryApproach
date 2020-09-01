
public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        int max = Math.max(a,b);
        max = Math.max(max,c);

        int min = Math.min(a,b);
        min = Math.min(min, c);

        int mid = a+b+c-max-min;

        boolean pos = (a>0) && (b>0) && (c>0);
        boolean retVal = pos && (Math.pow(max,2) == Math.pow(min,2) + Math.pow(mid,2));

        System.out.println(retVal);
    }
}
