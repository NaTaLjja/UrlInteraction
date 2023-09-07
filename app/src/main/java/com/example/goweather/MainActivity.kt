package com.example.goweather

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Response

class MainActivity: Activity() {
    private lateinit var textTemperature:TextView
    private lateinit var textWind:TextView
    private lateinit var textDescription:TextView
    private lateinit var requestButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        textTemperature = findViewById(R.id.temperature)
        textWind = findViewById(R.id.wind)
        textDescription = findViewById(R.id.description)
        requestButton = findViewById(R.id.button)
        requestButton.setOnClickListener {
            textTemperature.text = "Temperature: "
            textWind.text = "Wind: "
            textDescription.text = "Description: "

            val client =ApiClient.client.create(ApiInterface::class.java)
            client.getWeatherRx()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    textTemperature.append("${result?.temperature}")
                    textWind.append("${result?.wind}")
                    textDescription.append("${result?.description}")
                }, { error ->
                    Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                })

        }
    }
}
