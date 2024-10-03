package org.example.thimodule3.Model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MatBang {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private String maMb;
    private double dienTich;
    private int trThai;
    private int tang;
    private int loaiVp;
    private double giaThue;
    private Date startDate;
    private Date endDate;

    public MatBang(String maMb, double dienTich, int trThai, int tang, int loaiVp, double giaThue, Date startDate, Date endDate) {
        this.maMb = maMb;
        this.dienTich = dienTich;
        this.trThai = trThai;
        this.tang = tang;
        this.loaiVp = loaiVp;
        this.giaThue = giaThue;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getMaMb() {
        return maMb;
    }

    public void setMaMb(String maMb) {
        this.maMb = maMb;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public int getTrThai() {
        return trThai;
    }

    public void setTrThai(int trThai) {
        this.trThai = trThai;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }


    public int getLoaiVp() {
        return loaiVp;
    }

    public void setLoaiVp(int loaiVp) {
        this.loaiVp = loaiVp;
    }

    public double getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(double giaThue) {
        this.giaThue = giaThue;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}