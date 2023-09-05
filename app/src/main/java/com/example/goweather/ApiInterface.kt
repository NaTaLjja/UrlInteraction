package com.example.goweather

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/weather/Podgorica")
    fun getWeather():Call<WeatherResponse>

    @GET("/weather/Podgorica")
    fun getWeatherRx(): Single<WeatherResponse>
}