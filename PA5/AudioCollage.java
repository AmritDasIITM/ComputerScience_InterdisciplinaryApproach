public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha){
        double[] amp = new double[a.length];
        for ( int i = 0; i < a.length; i++){
            amp[i] = alpha * a[i];
        }
        return amp;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a){
        double[] rev = new double[a.length];
        for ( int i = 0; i < a.length; i++){
            rev[i] = a[a.length - 1- i];
        }
        return rev;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b){
        double[] merge = new double[a.length+b.length];
        for ( int i = 0; i < (a.length + b.length); i++){
            if ( i < a.length ) merge[i] = a[i];
            else merge[i] = b[i-a.length];
        }
        return merge;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b){
        double[] mix;
        if ( a.length >= b.length ) { mix = new double[a.length]; }
        else                        { mix = new double[b.length]; }

        for ( int i = 0; i < mix.length; i++ ){
            if ( i > a.length-1) mix[i] = b[i];
            else if ( i > b.length-1 ) mix[i] = a[i];
            else mix[i] = a[i] + b[i];
        }

        return mix;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha){
        double[] a2 = new double[ (int)Math.floor(a.length/alpha)];

        for ( int i = 0; i < a2.length; i++ ){
            a2[i] = a[ (int) Math.floor( i*alpha )];
        }
        return a2;
    }

    // Returns a normalised array by rescaling.
    public static double[] normalize( double[] a){
        double max = 0;
        for( int i = 0; i < a.length; i++ ){
            if ( Math.abs(a[i]) > max ) max = Math.abs(a[i]);
        }

        double[] norm = new double[a.length];
        for( int i = 0; i < a.length; i++ ){
            norm[i] = a[i]/max;
        }
        return norm;
    }

    // return array with all samples greater(less) than +1(-1) round to +1(-1).
    public static double[] clamp( double[] a){
        double[] clamp = new double[a.length];
        for( int i = 0; i < a.length; i++ ){
            if ( a[i]>1 ) clamp[i] = 1;
            else if ( a[i]<-1 ) clamp[i] = -1;
            else clamp[i] = a[i];
        }
        return clamp;
    }

    // Returns a contiguous subarray from a given sound.
    public static double[] cut( double[] a, int hi, int lo){
        double[] cut = new double[ hi - lo +1 ];
        for( int i = 0; i < cut.length; i++ ){
            cut[i] = a[ lo + i ];
        }
        return cut;
    }

    // Returns a given sound looped a number of times.
    public static double[] loop( double[] a, int num){
        double[] loop = new double[ num*a.length ];
        for( int i = 0; i < num; i++ ){
            for( int j = 0; j < a.length; j++ ){
                loop[j+i*a.length] = a[j];
            }
        }
        return loop;
    }

    // Returns a given sound concatenated with its reverse.
    public static double[] mirror( double[] a){
        double[] mirror = new double[ 2*a.length ];
        double[] reva = reverse(a);

        for( int i = 0; i < 2; i++ ){
            for( int j = 0; j < a.length; j++ ){
                if ( i == 0 ) mirror[j+i*a.length] = a[j];
                else mirror[j+i*a.length] = reva[j];
            }
        }
        return mirror;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args){
        double[] piano = StdAudio.read("piano.wav");
        double[] borap1 = StdAudio.read("Borap.wav");
        double[] singer = StdAudio.read("singer.wav");
        double[] melody = StdAudio.read("melody.wav");
        double[] beatbox = StdAudio.read("beatbox.wav");

        double[] collage = merge(normalize(mix(singer,amplify(piano,3))),reverse(beatbox));
        collage = merge(collage,borap1);
        collage = merge(changeSpeed(melody,1.25),collage);
        StdAudio.play(collage);
    }
}
