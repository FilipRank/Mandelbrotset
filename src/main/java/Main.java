import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        ComplexNumber c = new ComplexNumber(-1, 0.2);
//        System.out.println(isInMandelbrotSet(c, 80));

        //making plot array from -2 to 2
        int res = 10000;
        double lowBoundx = -2;
        double lowBoundy = -2;
        ArrayList<Double> trueValuesX = new ArrayList<Double>();
        ArrayList<Double> trueValuesY = new ArrayList<Double>();

        double x = lowBoundx;
        double y;
        for (int i = 0; i < res; i++) {
            y = lowBoundy;
            for (int j = 0; j < res; j++) {
                if (isInMandelbrotSet(new ComplexNumber(x, y), 800)) {
                    trueValuesX.add(x);
                    trueValuesY.add(y);
                }
                y += 4D * Math.abs(lowBoundy) / res;
            }
            x += 4D * Math.abs(lowBoundx) / res;
        }


        Plot.Data data = Plot.data().xy(trueValuesX, trueValuesY);
        Plot plot = Plot.plot(null).
                // setting data
                        series(null,
                        data,
                        Plot.seriesOpts()
                                .line(Plot.Line.NONE)
                                .marker(Plot.Marker.CIRCLE)
                                .markerColor(Color.BLACK).markerSize(1));
        for (int i = -100; i < 101; i++) {

        }

// saving sample_minimal.png
        try {
            plot.save("sample_minimal", "png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean isInMandelbrotSet(ComplexNumber c, final int MAX_ITERATIONS) {
        ComplexNumber z = new ComplexNumber(0, 0);
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            z = new ComplexNumber(
                    Math.pow(z.realFactor, 2) - Math.pow(z.imaginaryFactor, 2) + c.realFactor,
                    2 * z.realFactor * z.imaginaryFactor + c.imaginaryFactor);
            if (z.modulus() > 2) {
                return false;
            }
        }
        return true;
    }
}
