import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.general.DefaultPieDataset;

class PieChart {

    void en() {
        try {

            double num0;
            double num1;
            double num2;
            double num3;

            String str;
            String str1;

            num0 = 32.3;
            num1 = 20.2;
            num2 = 4.6;
            num3 = 42.3;

            str = "スマートフォンのシェア（2010年）";
            str1 = "円グラフ";

            ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());

            DefaultPieDataset data = new DefaultPieDataset();
            data.setValue("iPhone", num0);
            data.setValue("Android", num1);
            data.setValue("BlackBerry", num2);
            data.setValue("Windows Mobile", num3);

            // 2D
            //JFreeChart chart = ChartFactory.createPieChart(str, data, true, false, false);

            // 3D
            JFreeChart chart = ChartFactory.createPieChart3D(str, data, true, false, false);

            BufferedImage image = chart.createBufferedImage(399, 200);
            ImageIO.write(image, "PNG", new File("piechart.png"));

            JFrame frame = new JFrame(str1);
            frame.add(new ChartPanel(chart));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

        } catch (Exception e) {

            System.err.println("Exception error");
            e.printStackTrace(System.out);
        }
    }
}

public class Kaede {
    public static void main(String[] args) {

        final PieChart obj = new PieChart();
        obj.en();
    }
}