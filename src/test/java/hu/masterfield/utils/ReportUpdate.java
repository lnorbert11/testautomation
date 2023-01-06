package hu.masterfield.utils;

import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;

import java.util.LinkedList;
import java.util.List;

public class ReportUpdate {
    static LayoutReport layoutReport;
    public static void reportUpdate() {
        try {
            List<GalenTestInfo> tests = new LinkedList<>();
            GalenTestInfo test = GalenTestInfo.fromString("Tesco results page check");
            test.getReport().layout(layoutReport, "Verify products layout");
            tests.add(test);
            new HtmlReportBuilder().build(tests, "target/galen-html-reports");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
