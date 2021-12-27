package view;

import model.Histogram;
import java.awt.Container;
import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Admin
 */
public class HistogramDisplay extends ApplicationFrame {
    private final  Histogram<String> histogram;
    

    public HistogramDisplay(Histogram<String> histogram) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
        
    }
    
    public void execute(){
        this.setVisible(true);
    }
    
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (String key : this.histogram.keySet()) {
            dataSet.addValue(this.histogram.get(key),"",key);
        }
        return dataSet;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        return ChartFactory.createBarChart("Histograma JFreeChart", "Dominios email",
                                    "Nº de emails", dataSet, PlotOrientation.VERTICAL,
                                    false, false, rootPaneCheckingEnabled);
    }
   
}