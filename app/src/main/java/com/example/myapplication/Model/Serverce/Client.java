package com.example.myapplication.Model.Serverce;

public class Client {
    public static final String URL_001="http://192.168.1.131:8081/";
    public static APIService getAPIService(){
        return GetClient.GetClient(URL_001).create(APIService.class);
    }

}
