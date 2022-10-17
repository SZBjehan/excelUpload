package com.example.excelmsid.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExcelUpload {

    @Id
    private long ID;

    private long MSISDN;

    private String PROD_ID;

    private String PRODUCT_NAME;

    private String STATUS;

    public ExcelUpload(long ID, long MSISDN, String PROD_ID, String PRODUCT_NAME, String STATUS) {
        this.ID = ID;
        this.MSISDN = MSISDN;
        this.PROD_ID = PROD_ID;
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.STATUS = STATUS;
    }

    public ExcelUpload() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getMSISDN() {
        return MSISDN;
    }

    public void setMSISDN(long MSISDN) {
        this.MSISDN = MSISDN;
    }

    public String getPROD_ID() {
        return PROD_ID;
    }

    public void setPROD_ID(String PROD_ID) {
        this.PROD_ID = PROD_ID;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    @Override
    public String toString() {
        return "ExcelUpload{" +
                "ID=" + ID +
                ", MSISDN=" + MSISDN +
                ", PROD_ID=" + PROD_ID +
                ", PRODUCT_NAME='" + PRODUCT_NAME + '\'' +
                ", STATUS='" + STATUS + '\'' +
                '}';
    }
}
