package com.edarkea.main;

import com.edarkea.example.EdarkReport;
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
            EdarkReport report = new EdarkReport("C:/Users/ASUS/JaspersoftWorkspace/MyReports/ex_report.jasper", "ex_report.pdf");
            report.save();
        } catch (JRException ex) {
            Logger.getLogger(EJasperReportFramework.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EJasperReportFramework.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
