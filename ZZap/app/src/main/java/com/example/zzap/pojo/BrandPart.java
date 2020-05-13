package com.example.zzap.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BrandPart {

    @SerializedName("class_man")
    @Expose
    private String classMan;
    @SerializedName("logopath")
    @Expose
    private String logopath;
    @SerializedName("partnumber")
    @Expose
    private String partnumber;
    @SerializedName("class_cat")
    @Expose
    private String classCat;
    @SerializedName("code_cat")
    @Expose
    private int codeCat;
    @SerializedName("imagepath")
    @Expose
    private String imagepath;
    @SerializedName("imagepathV2")
    @Expose
    private List<String> imagepathV2 = null;

    public String getClassMan() {
        return classMan;
    }

    public void setClassMan(String classMan) {
        this.classMan = classMan;
    }

    public String getLogopath() {
        return logopath;
    }

    public void setLogopath(String logopath) {
        this.logopath = logopath;
    }

    public String getPartnumber() {
        return partnumber;
    }

    public void setPartnumber(String partnumber) {
        this.partnumber = partnumber;
    }

    public String getClassCat() {
        return classCat;
    }

    public void setClassCat(String classCat) {
        this.classCat = classCat;
    }

    public int getCodeCat() {
        return codeCat;
    }

    public void setCodeCat(int codeCat) {
        this.codeCat = codeCat;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public List<String> getImagepathV2() {
        return imagepathV2;
    }

    public void setImagepathV2(List<String> imagepathV2) {
        this.imagepathV2 = imagepathV2;
    }
}
