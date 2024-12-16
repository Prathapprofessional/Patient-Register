package com.example.patreg.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PatientApi {
    @POST("/register")
    Call<String> registerPatient(@Body Patient patient);
}
