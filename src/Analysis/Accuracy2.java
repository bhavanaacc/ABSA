package Analysis;

import static Analysis.chk2.*;
import master.DbconnSemeval;
import static Semeval.SentimentProcess.ProcessComments.methodname;
import static Semeval.SentimentProcess.publicparams.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class Accuracy2 extends ApplicationFrame {

    public Accuracy2(final String title) throws IOException, Exception {
        super(title);
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 470));

        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() throws IOException, Exception {
        final String series1 = "Accuracy";
        final String series2 = "Recall";
        final String series3 = "Precision";
        final String series4 = "Fscore";

        final String mtd1 = "AmbAccuracy";
        final String mtd2 = "AmbRecall";
        final String mtd3 = "AmbPrecision";
        final String mtd4 = "AmbFscore";
        final String mtd5 = "FoodAccuracy";
        final String mtd6 = "FoodRecall";
        final String mtd7 = "FoodPrecision";
        final String mtd8 = "FoodFscore";
        final String mtd9 = "RestAccuracy";
        final String mtd10 = "RestRecall";
        final String mtd11 = "RestPrecision";
        final String mtd12 = "RestFscore";
        final String mtd13 = "PriceAccuracy";
        final String mtd14 = "PriceRecall";
        final String mtd15 = "PricePrecision";
        final String mtd16 = "PriceFscore";
        final String mtd17 = "ServiceAccuracy";
        final String mtd18 = "ServiceRecall";
        final String mtd19 = "ServicePrecision";
        final String mtd20 = "ServiceFscore";
        final String mtd21 = "worthiAccuracy";
        final String mtd22 = "worthiRecall";
        final String mtd23 = "worthiPrecision";
        final String mtd24 = "worthiFscore";

        chk2 c=new chk2();
        c.br();
        double totalA = TotalA;
        double totalB = TotalB;
        double totalC = TotalC;
        double totalD = TotalD;
        double totalE = TotalE;
 double totalF = TotalF;
        double tot = totalA + totalB + totalC + totalD + totalE;

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        double AmbinaceAccuarcy = (AmbTP + AmbTN) / (tot);
        double Ambinaceprecision = AmbTP / (AmbTP + AmbFP);
        double AmbinaceRecall = AmbTP / (AmbTP + AmbFN);
        double AmbinaceFscore = 2 * (Ambinaceprecision * AmbinaceRecall) / (Ambinaceprecision + AmbinaceRecall);
        //***************************************
        double FoodAccuracy = (FoodTP + FoodTN) / (tot);
        double Foodprecision = FoodTP / (FoodTP + FoodFP);
        double FoodRecall = FoodTP / (FoodTP + FoodFN);
        double FoodFscore = 2 * (Foodprecision * FoodRecall) / (Foodprecision + FoodRecall);
        //***************************************
        double RestAccuracy = (RestTP + RestTN) / (tot);
        double Restprecision = RestTP / (RestTP + RestFP);
        double RestRecall = RestTP / (RestTP + RestFN);
        double RestFscore = 2 * (Restprecision * RestRecall) / (Restprecision + RestRecall);
        //************************************************************  
        double PriceAccuracy = (PriceTP + PriceTN) / (tot);
        double Priceprecision = PriceTP / (PriceTP + PriceFP);
        double PriceRecall = PriceTP / (PriceTP + PriceFN);
        double PriceFscore = 2 * (Priceprecision * PriceRecall) / (Priceprecision + PriceRecall);
        //************************************************************
        double ServiceAccuracy = (ServiceTP + ServiceTN) / (tot);
        double Serviceprecision = ServiceTP / (ServiceTP + ServiceFP);
        double ServiceRecall = ServiceTP / (ServiceTP + ServiceFN);
        double ServiceFscore = 2 * (Serviceprecision * ServiceRecall) / (Serviceprecision + ServiceRecall);
        //************************************************************
        double wortAccuracy = (wortTP + wortTN) / (tot);
        double wortprecision = wortTP / (wortTP + wortFP);
        double wortRecall = wortTP / (wortTP + wortFN);
        double wortFscore = 2 * (Serviceprecision * ServiceRecall) / (Serviceprecision + ServiceRecall);
        //************************************************************

        dataset.addValue(AmbinaceAccuarcy, series1, mtd1);
        dataset.addValue(Ambinaceprecision, series2, mtd2);
        dataset.addValue(AmbinaceRecall, series3, mtd3);
        dataset.addValue(AmbinaceFscore, series4, mtd4);

        dataset.addValue(FoodAccuracy, series1, mtd5);
        dataset.addValue(Foodprecision, series2, mtd6);
        dataset.addValue(FoodRecall, series3, mtd7);
        dataset.addValue(FoodFscore, series4, mtd8);

        dataset.addValue(PriceAccuracy, series1, mtd9);
        dataset.addValue(Priceprecision, series2, mtd10);
        dataset.addValue(PriceRecall, series3, mtd11);
        dataset.addValue(PriceFscore, series4, mtd12);

        dataset.addValue(RestAccuracy, series1, mtd13);
        dataset.addValue(Restprecision, series2, mtd14);
        dataset.addValue(RestRecall, series3, mtd15);
        dataset.addValue(RestFscore, series4, mtd16);

        dataset.addValue(ServiceAccuracy, series1, mtd17);
        dataset.addValue(Serviceprecision, series2, mtd18);
        dataset.addValue(ServiceRecall, series3, mtd19);
        dataset.addValue(ServiceFscore, series4, mtd20);

        dataset.addValue(ServiceAccuracy, series1, mtd21);
        dataset.addValue(Serviceprecision, series2, mtd22);
        dataset.addValue(ServiceRecall, series3, mtd23);
        dataset.addValue(ServiceFscore, series4, mtd24);

        DbconnSemeval db = new DbconnSemeval();
        Connection con = db.conn();
        Statement st = con.createStatement();
        if (methodname == "") {
            methodname = "weighted-CC";
        }

        st.executeUpdate("update analysis set accuracy='" + AmbinaceAccuarcy + "',Sprecision ='" + Ambinaceprecision + "', recall ='" + AmbinaceRecall + "', fscore='" + AmbinaceFscore + "' where method='" + methodname + "' and aspect ='ambiance'");
        st.executeUpdate("update analysis set accuracy='" + FoodAccuracy + "',Sprecision ='" + Foodprecision + "', recall ='" + FoodRecall + "', fscore='" + FoodFscore + "' where method='" + methodname + "' and aspect ='food'");
        st.executeUpdate("update analysis set accuracy='" + ServiceAccuracy + "',Sprecision ='" + Serviceprecision + "', recall ='" + ServiceRecall + "', fscore='" + ServiceFscore + "' where method='" + methodname + "' and aspect ='service'");
        st.executeUpdate("update analysis set accuracy='" + RestAccuracy + "',Sprecision ='" + Restprecision + "', recall ='" + RestRecall + "', fscore='" + RestFscore + "' where method='" + methodname + "' and aspect ='Restaurant'");
        st.executeUpdate("update analysis set accuracy='" + PriceAccuracy + "',Sprecision ='" + Priceprecision + "', recall ='" + PriceRecall + "', fscore='" + PriceFscore + "' where method='" + methodname + "' and aspect ='price'");
        st.executeUpdate("update analysis set accuracy='" + wortAccuracy + "',Sprecision ='" + wortprecision + "', recall ='" + wortRecall + "', fscore='" + wortFscore + "' where method='" + methodname + "' and aspect ='worthiness'");

        return dataset;

    }

    private JFreeChart createChart(final CategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createBarChart(
                "Classification Accuracy",
                "Methods",
                "Probability",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        chart.setBackgroundPaint(Color.white);

        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        //final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        //rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);

        final GradientPaint gp0 = new GradientPaint(
                0.0f, 0.0f, Color.green,
                0.0f, 0.0f, Color.green
        );
        final GradientPaint gp1 = new GradientPaint(
                0.0f, 0.0f, Color.cyan,
                0.0f, 0.0f, Color.cyan
        );
        final GradientPaint gp2 = new GradientPaint(
                0.0f, 0.0f, Color.cyan,
                0.0f, 0.0f, Color.cyan
        );

        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        return chart;
    }

}
