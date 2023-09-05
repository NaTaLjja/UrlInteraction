package com.example.goweather

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/weather/Podgorica")
    fun getWeather():Call<WeatherResponse>
}