package com.example.zzap.api;

import com.example.zzap.pojo.BrandPartResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {


    @GET("GetSearchSuggestV3?login=garajv@yandex.ru&password=4d645c5730&search_text=?&row_count=3&type_request=0&api_key=MBmE7rdJlQjqwrEpyY78ho2YSeaGsND9tFzzPCrjfBtX5ico5YkBlGkMZDR")
    Observable<BrandPartResponse> getBrandParts(@Query("search_text") String search);
}
