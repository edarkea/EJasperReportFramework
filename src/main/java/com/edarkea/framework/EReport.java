package com.edarkea.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Edinson Ayui
 * @version 1.0.0
 */
public abstract class EReport {

    protected final String outputPathFile;
    protected JasperReport jasperReport;
    protected JasperPrint jasperPrint;
    private final Map<String, Object> parameters;

    public EReport(final String pathFileReport, final String outputPathFile) throws IOException, JRException {
        this.outputPathFile = outputPathFile;
        this.jasperReport = (JasperReport) JRLoader.loadObject(new FileInputStream(new File(pathFileReport)));
        this.parameters = new HashMap<>();

        makeReport();
    }

    public abstract void makeReport() throws JRException;

    public void fillReport(Collection<?> dataSource) throws JRException {
        this.jasperPrint = JasperFillManager.fillReport(this.jasperReport, this.parameters,
                new JRBeanCollectionDataSource(dataSource));
    }

    public void fillReport() throws JRException {
        this.jasperPrint = JasperFillManager.fillReport(this.jasperReport, this.parameters);
    }

    public void addParameter(String key, Object value) {
        this.parameters.put(key, value);
    }

    public void removeParameter(String key) {
        this.parameters.remove(key);
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
