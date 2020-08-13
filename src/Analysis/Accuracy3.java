package Analysis;

import static Analysis.chk3.*;
import static Drug.SentimentProcess.ProcessComments.methodname;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import master.DbconnDrug;
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

public class Accuracy3 extends ApplicationFrame {

    public Accuracy3(final String title) throws IOException, Exception {
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

        final String mtd1 = "BCAccuracy";
        final String mtd2 = "BCRecall";
        final String mtd3 = "BCPrecision";
        final String mtd4 = "BCFscore";
        final String mtd5 = "DepAccuracy";
        final String mtd6 = "DepRecall";
        final String mtd7 = "DepPrecision";
        final String mtd8 = "DepFscore";
        final String mtd9 = "BODAccuracy";
        final String mtd10 = "BODRecall";
        final String mtd11 = "BODPrecision";
        final String mtd12 = "BODFscore";
        final String mtd13 = "PainAccuracy";
        final String mtd14 = "PainRecall";
        final String mtd15 = "PainPrecision";
        final String mtd16 = "PainFscore";
        final String mtd17 = "WLAccuracy";
        final String mtd18 = "WLRecall";
        final String mtd19 = "WLPrecision";
        final String mtd20 = "WLFscore";

        chk3 c=new chk3();
        c.br();
        double totalA = TotalA;
        double totalB = TotalB;
        double totalC = TotalC;
        double totalD = TotalD;
        double totalE = TotalE;

        double tot = totalA + totalB + totalC + totalD + totalE;

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        double BCAccuarcy = (BCTP + BCTN) / (tot);
        double BCprecision = BCTP / (BCTP + BCFP);
        double BCRecall = BCTP / (BCTP + BCFN);
        double BCFscore = 2 * (BCprecision * BCRecall) / (BCprecision + BCRecall);
        //***************************************
        double DepAccuracy = (DepTP + DepTN) / (tot);
        double Depprecision = DepTP / (DepTP + DepFP);
        double DepRecall = DepTP / (DepTP + DepFN);
        double DepFscore = 2 * (Depprecision * DepRecall) / (Depprecision + DepRecall);
        //***************************************
        double BODAccuracy = (BODTP + BODTN) / (tot);
        double BODprecision = BODTP / (BODTP + BODFP);
        double BODRecall = BODTP / (BODTP + BODFN);
        double BODFscore = 2 * (BODprecision * BODRecall) / (BODprecision + BODRecall);
        //************************************************************  
        double PainAccuracy = (PainTP + PainTN) / (tot);
        double Painprecision = PainTP / (PainTP + PainFP);
        double PainRecall = PainTP / (PainTP + PainFN);
        double PainFscore = 2 * (Painprecision * PainRecall) / (Painprecision + PainRecall);
        //************************************************************
        double WLAccuracy = (WLTP + WLTN) / (tot);
        double WLprecision = WLTP / (WLTP + WLFP);
        double WLRecall = WLTP / (WLTP + WLFN);
        double WLFscore = 2 * (WLprecision * WLRecall) / (WLprecision + WLRecall);
        //************************************************************
        dataset.addValue(BCAccuarcy, series1, mtd1);
        dataset.addValue(WLprecision, series2, mtd2);
        dataset.addValue(WLRecall, series3, mtd3);
        dataset.addValue(WLFscore, series4, mtd4);

        dataset.addValue(DepAccuracy, series1, mtd5);
        dataset.addValue(Depprecision, series2, mtd6);
        dataset.addValue(DepRecall, series3, mtd7);
        dataset.addValue(DepFscore, series4, mtd8);

        dataset.addValue(PainAccuracy, series1, mtd9);
        dataset.addValue(Painprecision, series2, mtd10);
        dataset.addValue(PainRecall, series3, mtd11);
        dataset.addValue(PainFscore, series4, mtd12);

        dataset.addValue(BODAccuracy, series1, mtd13);
        dataset.addValue(BODprecision, series2, mtd14);
        dataset.addValue(BODRecall, series3, mtd15);
        dataset.addValue(BODFscore, series4, mtd16);

        dataset.addValue(WLAccuracy, series1, mtd17);
        dataset.addValue(WLprecision, series2, mtd18);
        dataset.addValue(WLRecall, series3, mtd19);
        dataset.addValue(WLFscore, series4, mtd20);

        DbconnDrug db = new DbconnDrug();
        Connection con = db.conn();
        Statement st = con.createStatement();
        if (methodname == "") {
            methodname = "weighted-CC";
        }

        st.executeUpdate("update analysis set accuracy='" + BCAccuarcy + "',Sprecision ='" + BCprecision + "', recall ='" + BCRecall + "', fscore='" + BCFscore + "' where method='" + methodname + "' and aspect ='Birth Control'");
        st.executeUpdate("update analysis set accuracy='" + DepAccuracy + "',Sprecision ='" + Depprecision + "', recall ='" + DepRecall + "', fscore='" + DepFscore + "' where method='" + methodname + "' and aspect ='Depression'");
        st.executeUpdate("update analysis set accuracy='" + BODAccuracy + "',Sprecision ='" + BODprecision + "', recall ='" + BODRecall + "', fscore='" + BODFscore + "' where method='" + methodname + "' and aspect ='Birth Control'");
        st.executeUpdate("update analysis set accuracy='" + PainAccuracy + "',Sprecision ='" + Painprecision + "', recall ='" + PainRecall + "', fscore='" + PainFscore + "' where method='" + methodname + "' and aspect ='Pain'");
        st.executeUpdate("update analysis set accuracy='" + WLAccuracy + "',Sprecision ='" + WLprecision + "', recall ='" + WLRecall + "', fscore='" + WLFscore + "' where method='" + methodname + "' and aspect ='Weight Loss'");

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
