package com.edarkea.example;

/**
 *
 * @author Edinson Ayui
 * @version 1.0.0
 */
public class FrameworkModel {

    private String frm_framework_name;
    private String frm_framework_version;
    private int frm_framework_download;

    public FrameworkModel() {
    }

    public FrameworkModel(String frm_framework_name, String frm_framework_version, Integer frm_framework_download) {
        this.frm_framework_name = frm_framework_name;
        this.frm_framework_version = frm_framework_version;
        this.frm_framework_download = frm_framework_download;
    }

    public String getFrm_framework_name() {
        return frm_framework_name;
    }

    public void setFrm_framework_name(String frm_framework_name) {
        this.frm_framework_name = frm_framework_name;
    }

    public String getFrm_framework_version() {
        return frm_framework_version;
    }

    public void setFrm_framework_version(String frm_framework_version) {
        this.frm_framework_version = frm_framework_version;
    }

    public int getFrm_framework_download() {
        return frm_framework_download;
    }

    public void setFrm_framework_download(int frm_framework_download) {
        this.frm_framework_download = frm_framework_download;
    }

}
