package com.example.myapplication.Model.Serverce;

import com.example.myapplication.Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {

        Gson gson = new GsonBuilder().setLenient()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

        APIService apiService = new Retrofit.Builder()
                .baseUrl("http://192.168.1.131:8081/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(APIService.class);
        @GET("khachhang/listar")
        Call<List<User>> khachhang();
        @GET("khachhang/listarId/{taiKhoan}")
        Call<List<User>> idkhachhang( @Path("taiKhoan") String taiKhoan);
        @POST("khachhang/add")
        Call<User> createUser(@Body User khachHang);
        @POST("khachhang/update/{taiKhoan}")
        Call<String> updateKhachhang(@Body User khachhang,
                                     @Path("taiKhoan") String taiKhoan);
}
