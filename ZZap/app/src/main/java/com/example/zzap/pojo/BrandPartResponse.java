package com.example.zzap.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BrandPartResponse {


    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("row_count")
    @Expose
    private int rowCount;
    @SerializedName("terms")
    @Expose
    private String terms;
    @SerializedName("table")
    @Expose
    private List<BrandPart> brandParts = null;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public List<BrandPart> getBrandParts() {
        return brandParts;
    }

    public void setBrandParts(List<BrandPart> brandParts) {
        this.brandParts = brandParts;
    }
}
