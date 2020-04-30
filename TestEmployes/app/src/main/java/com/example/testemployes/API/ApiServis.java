package com.example.testemployes.API;

import com.example.testemployes.pojo.EmployeeResponse;

import retrofit2.http.GET;
import rx.Observable;

public interface ApiServis {
    @GET("testTask.json")
    Observable<EmployeeResponse> getEmployees();
}
