public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna){
        int max = 0;
        int present = 0;
        for (int i = 0; i < dna.length()-2; i++){
            if ( i == present) {
                if ( (dna.substring(i,i+3)).equals("CAG") ){
                    int count = 1;
                    for ( int j = i+3; j < dna.length()-2; j+=3 ){
                        if( (dna.substring(j,j+3)).equals("CAG") ){
                            count += 1;
                            if (j==dna.length()-3 || j==dna.length()-4 || j==dna.length()-5 ) {
                                if (count > max) max = count;
                            }
                        }else{
                            if ( max < count ) max = count;
                            present = i + 3*count - 1;
                            break;
                        }
                    }
                    if ( max < 1 ) max = 1;
                } else{
                    present += 1;
                }
            }
        }
        return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s){
        s = s.replace(" ","");
        s = s.replace("\n","");
        s = s.replace("\t","");
        return s;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats){
        if (maxRepeats > 180 || maxRepeats < 10)    return "not human";
        if (maxRepeats <=35  && maxRepeats >= 10)   return "normal";
        if (maxRepeats > 35 && maxRepeats < 40)     return "high risk";
        return "Huntington's";
    }

    // Sample client (see below).
    public static void main(String[] args){

        String filename = args[0];
        In in = new In(filename);
        String seq = in.readAll();

        int max = maxRepeats(removeWhitespace(seq));
        StdOut.println( "max repeats = " + max );
        StdOut.println( diagnose(max) );

    }

}
