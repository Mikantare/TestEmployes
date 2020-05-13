package com.example.testemployes.API;

import com.example.testemployes.pojo.EmployeeResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServis {
    @GET("testTask.json")
    Observable <EmployeeResponse> getEmployees();
}
