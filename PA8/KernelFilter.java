import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture){
        int w = picture.width() ;
        int h = picture.height();

        int[][] filter = {{0,0,0},{0,1,0},{0,0,0}};
        Picture mod = new Picture(w,h);
        for (int i = 0; i < picture.width(); i++){
            for (int j = 0; j < picture.height(); j++){

                int sumr = 0, sumg = 0, sumb = 0;
                for (int m = 0; m < 3; m++){
                    for (int n = 0; n < 3; n++){
                        int x = (i-1+m) % w;
                        if (x < 0) x+=w;
                        int y = (j-1+n) % h;
                        if (y < 0) y+=h;
                        Color c = picture.get(x,y);
                        int r = c.getRed();
                        int g = c.getGreen();
                        int b = c.getBlue();
                        sumr += r * filter[m][n];
                        sumg += g * filter[m][n];
                        sumb += b * filter[m][n];
                    }
                }
                Color result = new Color(sumr,sumg,sumb);
                mod.set(i,j,result);
            }
        }
        return mod;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture){
        int w = picture.width() ;
        int h = picture.height();

        double[][] filter = {{1/16.0,2/16.0,1/16.0},{2/16.0,4/16.0,2/16.0},{1/16.0,2/16.0,1/16.0}};
        Picture mod = new Picture(w,h);
        for (int i = 0; i < picture.width(); i++){
            for (int j = 0; j < picture.height(); j++){

                double sumr = 0, sumg = 0, sumb = 0;
                for (int m = 0; m < 3; m++){
                    for (int n = 0; n < 3; n++){
                        int x = (i-1+m) % w;
                        if (x < 0) x+=w;
                        int y = (j-1+n) % h;
                        if (y < 0) y+=h;
                        Color c = picture.get(x,y);
                        int r = c.getRed();
                        int g = c.getGreen();
                        int b = c.getBlue();
                        sumr += r * filter[m][n];
                        sumg += g * filter[m][n];
                        sumb += b * filter[m][n];
                    }
                }

                Color result = new Color((int)Math.round(sumr),(int)Math.round(sumg),(int)Math.round(sumb));
                mod.set(i,j,result);
            }
        }

        return mod;
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture){
        int w = picture.width() ;
        int h = picture.height();

        int[][] filter = {{0,-1,0},{-1,5,-1},{0,-1,0}};
        Picture mod = new Picture(w,h);
        for (int i = 0; i < picture.width(); i++){
            for (int j = 0; j < picture.height(); j++){

                double sumr = 0, sumg = 0, sumb = 0;
                for (int m = 0; m < 3; m++){
                    for (int n = 0; n < 3; n++){
                        int x = (i-1+m) % w;
                        if (x < 0) x+=w;
                        int y = (j-1+n) % h;
                        if (y < 0) y+=h;
                        Color c = picture.get(x,y);
                        int r = c.getRed();
                        int g = c.getGreen();
                        int b = c.getBlue();
                        sumr += r * filter[m][n];
                        sumg += g * filter[m][n];
                        sumb += b * filter[m][n];
                    }
                }
                if (sumr>255) sumr=255;
                if (sumg>255) sumg=255;
                if (sumb>255) sumb=255;
                if (sumr<0) sumr=0;
                if (sumg<0) sumg=0;
                if (sumb<0) sumb=0;

                Color result = new Color((int)Math.round(sumr),(int)Math.round(sumg),(int)Math.round(sumb));
                mod.set(i,j,result);
            }
        }

        return mod;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture){
        int w = picture.width() ;
        int h = picture.height();

        int[][] filter = {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};
        Picture mod = new Picture(w,h);
        for (int i = 0; i < picture.width(); i++){
            for (int j = 0; j < picture.height(); j++){

                double sumr = 0, sumg = 0, sumb = 0;
                for (int m = 0; m < 3; m++){
                    for (int n = 0; n < 3; n++){
                        int x = (i-1+m) % w;
                        if (x < 0) x+=w;
                        int y = (j-1+n) % h;
                        if (y < 0) y+=h;
                        Color c = picture.get(x,y);
                        int r = c.getRed();
                        int g = c.getGreen();
                        int b = c.getBlue();
                        sumr += r * filter[m][n];
                        sumg += g * filter[m][n];
                        sumb += b * filter[m][n];
                    }
                }
                if (sumr>255) sumr=255;
                if (sumg>255) sumg=255;
                if (sumb>255) sumb=255;
                if (sumr<0) sumr=0;
                if (sumg<0) sumg=0;
                if (sumb<0) sumb=0;

                Color result = new Color((int)Math.round(sumr),(int)Math.round(sumg),(int)Math.round(sumb));
                mod.set(i,j,result);
            }
        }

        return mod;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture){
        int w = picture.width() ;
        int h = picture.height();

        int[][] filter = {{-2,-1,0},{-1,1,1},{0,1,2}};
        Picture mod = new Picture(w,h);
        for (int i = 0; i < picture.width(); i++){
            for (int j = 0; j < picture.height(); j++){

                double sumr = 0, sumg = 0, sumb = 0;
                for (int m = 0; m < 3; m++){
                    for (int n = 0; n < 3; n++){
                        int x = (i-1+m) % w;
                        if (x < 0) x+=w;
                        int y = (j-1+n) % h;
                        if (y < 0) y+=h;
                        Color c = picture.get(x,y);
                        int r = c.getRed();
                        int g = c.getGreen();
                        int b = c.getBlue();
                        sumr += r * filter[m][n];
                        sumg += g * filter[m][n];
                        sumb += b * filter[m][n];
                    }
                }
                if (sumr>255) sumr=255;
                if (sumg>255) sumg=255;
                if (sumb>255) sumb=255;
                if (sumr<0) sumr=0;
                if (sumg<0) sumg=0;
                if (sumb<0) sumb=0;

                Color result = new Color((int)Math.round(sumr),(int)Math.round(sumg),(int)Math.round(sumb));
                mod.set(i,j,result);
            }
        }

        return mod;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture){
        int w = picture.width() ;
        int h = picture.height();

        int[][] filter = {  {1,0,0,0,0,0,0,0,0},
                            {0,1,0,0,0,0,0,0,0},
                            {0,0,1,0,0,0,0,0,0},
                            {0,0,0,1,0,0,0,0,0},
                            {0,0,0,0,1,0,0,0,0},
                            {0,0,0,0,0,1,0,0,0},
                            {0,0,0,0,0,0,1,0,0},
                            {0,0,0,0,0,0,0,1,0},
                            {0,0,0,0,0,0,0,0,1}};
        Picture mod = new Picture(w,h);
        for (int i = 0; i < picture.width(); i++){
            for (int j = 0; j < picture.height(); j++){

                double sumr = 0, sumg = 0, sumb = 0;
                for (int m = 0; m < 9; m++){
                    for (int n = 0; n < 9; n++){
                        int x = (i-4+m) % w;
                        if (x < 0) x+=w;
                        int y = (j-4+n) % h;
                        if (y < 0) y+=h;
                        Color c = picture.get(x,y);
                        int r = c.getRed();
                        int g = c.getGreen();
                        int b = c.getBlue();
                        sumr += r * filter[m][n]/9.0;
                        sumg += g * filter[m][n]/9.0;
                        sumb += b * filter[m][n]/9.0;
                    }
                }

                if (sumr>255) sumr=255;
                if (sumg>255) sumg=255;
                if (sumb>255) sumb=255;
                if (sumr<0) sumr=0;
                if (sumg<0) sumg=0;
                if (sumb<0) sumb=0;

                Color result = new Color((int)Math.round(sumr),(int)Math.round(sumg),(int)Math.round(sumb));
                mod.set(i,j,result);
            }
        }

        return mod;
    }

    // Test client (ungraded).
    public static void main(String[] args){
        Picture picColor = new Picture(args[0]);
        Picture modi = identity(picColor);
        modi.show();
        Picture modg = gaussian(picColor);
        modg.show();
        Picture mods = sharpen(picColor);
        mods.show();
        Picture modl = laplacian(picColor);
        modl.show();
        Picture mode = emboss(picColor);
        mode.show();
        Picture modm = motionBlur(picColor);
        modm.show();
    }

}
