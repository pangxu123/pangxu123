package org.sang.bean;

public class PerEc {
    private Integer id;
    private String name;
    private String workid;
    private String ecproject;
    private String ecdata;
    private String ecattribute;
    private String ecmoney;
    private String ecadmin;
    private String ecmarks;

    public PerEc(){

    }
    public static PerEc build() {
        return new PerEc();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
    }

    public String getEcproject() {
        return ecproject;
    }

    public void setEcproject(String ecproject) {
        this.ecproject = ecproject;
    }

    public String getEcdata() {
        return ecdata;
    }

    public void setEcdata(String ecdata) {
        this.ecdata = ecdata;
    }

    public String getEcattribute() {
        return ecattribute;
    }

    public void setEcattribute(String ecattribute) {
        this.ecattribute = ecattribute;
    }

    public String getEcmoney() {
        return ecmoney;
    }

    public void setEcmoney(String ecmoney) {
        this.ecmoney = ecmoney;
    }

    public String getEcmarks() {

        return ecmarks;
    }

    public void setEcmarks(String ecmarks) {
        this.ecmarks = ecmarks;
    }

    public String getEcadmin() {
        return ecadmin;
    }

    public void setEcadmin(String ecadmin) {
        this.ecadmin = ecadmin;
    }
}
