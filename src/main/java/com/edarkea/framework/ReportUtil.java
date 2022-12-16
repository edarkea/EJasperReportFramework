package com.edarkea.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Edinson Ayui
 * @version 1.0.0
 */
public abstract class ReportUtil {

    protected final String outputPathFile;
    protected JasperReport jasperReport;
    protected JasperPrint jasperPrint;

    public ReportUtil(final String pathFileReport, final String outputPathFile) throws IOException, JRException {
        this.outputPathFile = outputPathFile;
        File file = new File(pathFileReport);
        InputStream is = new FileInputStream(new File(pathFileReport));
        this.jasperReport = JasperCompileManager.compileReport(is);
        makeReport();
    }

    public abstract void makeReport() throws JRException;
    
    public void fillReport(Map<String, Object> parameters, Collection<?> dataSource) throws JRException {
        this.jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                new JRBeanCollectionDataSource(dataSource));
    }

    public void save() throws JRException {
        JasperExportManager.exportReportToPdfFile(jasperPrint, outputPathFile);
    }

    public void save(String outputPathFile) throws JRException {
        JasperExportManager.exportReportToPdfFile(jasperPrint, outputPathFile);
    }

    public byte[] convertToBytes() throws JRException {
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

}
