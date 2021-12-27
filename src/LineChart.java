import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart extends ApplicationFrame {

    DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

    public LineChart(String applicationTitle , String chartTitle ) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Страны","Показатель щедрости",
                dataset,
                PlotOrientation.VERTICAL,
                true,true,true);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 1080 , 720 ) );
        setContentPane( chartPanel );
    }
}