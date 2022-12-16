package com.edarkea.main;

import com.edarkea.example.ExampleReport;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Edinson Ayui
 */
public class EJasperReportFramework {

    public static void main(String[] args) {
        System.out.println("Hi EdarkEA!");
        try {
            ExampleReport report = new ExampleReport("system/reports/ex_report.jrxml", "ex_report.pdf");
            report.save();
        } catch (JRException ex) {
            Logger.getLogger(EJasperReportFramework.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EJasperReportFramework.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
