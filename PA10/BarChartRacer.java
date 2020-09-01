import java.util.Arrays;
import java.util.Comparator;

public class BarChartRacer {
    public static void main(String[] args) {

        String filename = args[0];
        int num = Integer.parseInt(args[1]);
        In in = new In(filename);

        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();

        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        in.readLine();

        while (!in.isEmpty()) {
            int n = in.readInt();
            in.readLine();
            Bar[] arr = new Bar[n];
            String cap="";
            for (int i = 0; i < n; i++){
                String s = in.readLine();
                String [] a = s.split(",");
                arr[i] = new Bar(a[1],Integer.parseInt(a[3]),a[4]);
                cap = a[0];
            }
            Arrays.sort(arr, Comparator.reverseOrder());
            BarChart chart = new BarChart(title, xAxis, source);

            chart.setCaption(cap);
            for (int j = 0; j < num; j++) {
                chart.add(arr[j].getName(), arr[j].getValue(), arr[j].getCategory());
            }

            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            in.readLine();
        }

    }
}
