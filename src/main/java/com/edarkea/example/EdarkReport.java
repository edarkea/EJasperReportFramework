package com.edarkea.example;

import com.edarkea.framework.EReport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Edinson Ayui
 * @version 1.0.0
 */
public class EdarkReport extends EReport {

    public EdarkReport(final String pathFileReport, final String outputPathFile) throws IOException, JRException, Exception {
        super(pathFileReport, outputPathFile);
    }

    @Override
    public void makeReport() throws JRException {
        addParameter("par_full_name", "Edinson Ayui");
        
        List<FrameworkModel> downloads = new ArrayList<>();
        downloads.add(new FrameworkModel("ESqlFramework", "2.2.1", 32));
        downloads.add(new FrameworkModel("ESqlFramework", "2.2.0", 31));
        downloads.add(new FrameworkModel("ESqlFramework", "2.1.1", 52));
        downloads.add(new FrameworkModel("ESqlFramework", "2.1.0", 51));
        downloads.add(new FrameworkModel("ESqlFramework", "2.0.0", 62));
        downloads.add(new FrameworkModel("ESqlFramework", "1.2.1", 34));
        downloads.add(new FrameworkModel("ESqlFramework", "1.2.0", 33));
        downloads.add(new FrameworkModel("ESqlFramework", "1.1.0", 52));
        downloads.add(new FrameworkModel("ESqlFramework", "1.0.0", 60));
        
        this.fillReport(downloads);
    }

}
