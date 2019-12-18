package org.sang.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PerSalary {
    private int id;
    private int eid;
    private int sid;
    private String name;
    private String ten_throughput;
    private String ten_score;
    private String eleven_throughput;
    private String eleven_score;
    private String twelve_throughput;
    private String twelve_score;
    private String one_throughput;
    private String one_number;
    private String one_score;
    private String two_throughput;
    private String two_number;
    private String remarks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @JsonIgnore
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @JsonIgnore
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTen_throughput() {
        return ten_throughput;
    }

    public void setTen_throughput(String ten_throughput) {
        this.ten_throughput = ten_throughput;
    }

    public String getTen_score() {
        return ten_score;
    }

    public void setTen_score(String ten_score) {
        this.ten_score = ten_score;
    }

    public String getEleven_throughput() {
        return eleven_throughput;
    }

    public void setEleven_throughput(String eleven_throughput) {
        this.eleven_throughput = eleven_throughput;
    }

    public String getEleven_score() {
        return eleven_score;
    }

    public void setEleven_score(String eleven_score) {
        this.eleven_score = eleven_score;
    }

    public String getTwelve_throughput() {
        return twelve_throughput;
    }

    public void setTwelve_throughput(String twelve_throughput) {
        this.twelve_throughput = twelve_throughput;
    }

    public String getTwelve_score() {
        return twelve_score;
    }

    public void setTwelve_score(String twelve_score) {
        this.twelve_score = twelve_score;
    }

    public String getOne_throughput() {
        return one_throughput;
    }

    public void setOne_throughput(String one_throughput) {
        this.one_throughput = one_throughput;
    }

    public String getOne_number() {
        return one_number;
    }

    public void setOne_number(String one_number) {
        this.one_number = one_number;
    }

    public String getOne_score() {
        return one_score;
    }

    public void setOne_score(String one_score) {
        this.one_score = one_score;
    }

    public String getTwo_throughput() {
        return two_throughput;
    }

    public void setTwo_throughput(String two_throughput) {
        this.two_throughput = two_throughput;
    }

    public String getTwo_number() {
        return two_number;
    }

    public void setTwo_number(String two_number) {
        this.two_number = two_number;
    }


    public PerSalary() {
    }
}
