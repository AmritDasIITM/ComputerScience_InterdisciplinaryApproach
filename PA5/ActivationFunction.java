public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x){
        if ( !Double.isNaN(x)) {
            if (x < 0) return 0;
            else if (x > 0) return 1;
            else return 0.5;
        }else return Double.NaN;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x){
        if ( !Double.isNaN(x)) {
             return 1/( 1 + Math.exp(-x)) ;
        }else return Double.NaN;
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x){
        if ( !Double.isNaN(x)) {
            return ( Math.exp(x) - Math.exp(-x) )/( Math.exp(x) + Math.exp(-x) );
        }else return Double.NaN;
    }

    // Returns the softsign function of x.
    public static double softsign(double x){
        if ( !Double.isNaN(x)) {
            return x / ( 1 + Math.abs(x) );
        }else return Double.NaN;
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x){
        if ( !Double.isNaN(x)) {
            if ( x <= -2) return -1;
            else if ( x > -2 && x < 0 ) return x + x*x/4 ;
            else if ( x < 2 && x >= 0 ) return x - x*x/4 ;
            else return 1;
        }else return Double.NaN;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args){
        double n = Double.parseDouble(args[0]);

        StdOut.println("heaviside(" + n + ") = " + heaviside(n));
        StdOut.println("  sigmoid(" + n + ") = " + sigmoid(n));
        StdOut.println("     tanh(" + n + ") = " + tanh(n));
        StdOut.println(" softsign(" + n + ") = " + softsign(n));
        StdOut.println("     sqnl(" + n + ") = " + sqnl(n));

    }

}
