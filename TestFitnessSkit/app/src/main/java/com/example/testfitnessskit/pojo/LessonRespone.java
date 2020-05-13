package com.example.testfitnessskit.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LessonRespone {

    @SerializedName("response")
    @Expose
    private List<Lesson> response = null;

    public List<Lesson> getResponse() {
        return response;
    }

    public void setResponse(List<Lesson> response) {
        this.response = response;
    }
}

