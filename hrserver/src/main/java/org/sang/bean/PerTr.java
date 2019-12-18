package org.sang.bean;

public class PerTr {
    private Integer id;
    private String tr_contents;
    private String tr_category;
    private String tr_lead_department;
    private String tr_assistance_department;
    private String tr_object;
    private String tr_form;
    private String tr_lecturer;
    private String tr_material;
    private String tr_place;
    private String tr_duration;
    private String tr_method;
    private String tr_remarks;
    private String tr_budget_mode;

    public PerTr() {
    }

    public static PerEc build() {
        return new PerEc();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTr_contents(String tr_contents) {
        this.tr_contents = tr_contents;
    }

    public void setTr_category(String tr_category) {
        this.tr_category = tr_category;
    }

    public void setTr_lead_department(String tr_lead_department) {
        this.tr_lead_department = tr_lead_department;
    }

    public void setTr_assistance_department(String tr_assistance_department) {
        this.tr_assistance_department = tr_assistance_department;
    }

    public void setTr_object(String tr_object) {
        this.tr_object = tr_object;
    }

    public void setTr_form(String tr_form) {
        this.tr_form = tr_form;
    }

    public void setTr_lecturer(String tr_lecturer) {
        this.tr_lecturer = tr_lecturer;
    }

    public void setTr_material(String tr_material) {
        this.tr_material = tr_material;
    }

    public void setTr_place(String tr_place) {
        this.tr_place = tr_place;
    }

    public void setTr_duration(String tr_duration) {
        this.tr_duration = tr_duration;
    }

    public void setTr_method(String tr_method) {
        this.tr_method = tr_method;
    }

    public void setTr_remarks(String tr_remarks) {
        this.tr_remarks = tr_remarks;
    }

    public void setTr_budget_mode(String tr_budget_mode) {
        this.tr_budget_mode = tr_budget_mode;
    }

    public Integer getId() {
        return id;
    }

    public String getTr_contents() {
        return tr_contents;
    }

    public String getTr_category() {
        return tr_category;
    }

    public String getTr_lead_department() {
        return tr_lead_department;
    }

    public String getTr_assistance_department() {
        return tr_assistance_department;
    }

    public String getTr_object() {
        return tr_object;
    }

    public String getTr_form() {
        return tr_form;
    }

    public String getTr_lecturer() {
        return tr_lecturer;
    }

    public String getTr_material() {
        return tr_material;
    }

    public String getTr_place() {
        return tr_place;
    }

    public String getTr_duration() {
        return tr_duration;
    }

    public String getTr_method() {
        return tr_method;
    }

    public String getTr_remarks() {
        return tr_remarks;
    }

    public String getTr_budget_mode() {
        return tr_budget_mode;
    }
}
