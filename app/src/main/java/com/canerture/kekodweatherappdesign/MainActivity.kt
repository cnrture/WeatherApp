package com.canerture.kekodweatherappdesign

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.canerture.kekodweatherappdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var imageViewList : ArrayList<ImageView>
    private lateinit var textViewCelciusList : ArrayList<TextView>
    private lateinit var textViewDayList : ArrayList<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageViewList = arrayListOf(binding.miniCardTodayImage, binding.miniCardTomorrowImage, binding.miniCardTwoDaysLaterImage, binding.miniCardThreeDaysLaterImage)
        textViewCelciusList = arrayListOf(binding.todayCelciusText, binding.tomorrowCelciusText, binding.twoDaysLaterCelciusText, binding.threeDaysLaterCelciusText)
        textViewDayList = arrayListOf(binding.todayMiniText, binding.tomorrowMiniText, binding.twoDaysLaterMiniText, binding.threeDaysLaterMiniText)

        binding.todayWeatherMiniCard.updateTodayDayCardWeather(imageViewList[0], textViewCelciusList[0], textViewDayList[0], "Monday, 23 August", "Partly Cloudy", "28°", R.drawable.partlycloudy, "6 km/h", "18 %", "1,8 km")
        binding.tomorrowWeatherMiniCard.updateTodayDayCardWeather(imageViewList[1], textViewCelciusList[1], textViewDayList[1],"Tuesday, 24 August", "Rainy", "26°", R.drawable.rainy, "9 km/h", "23 %", "1,2 km")
        binding.twoDaysLaterMiniCard.updateTodayDayCardWeather(imageViewList[2], textViewCelciusList[2], textViewDayList[2],"Wednesday, 25 August", "Cloudy", "25°", R.drawable.cloudy, "8 km/h", "15 %", "1,6 km")
        binding.threeDaysLaterMiniCard.updateTodayDayCardWeather(imageViewList[3], textViewCelciusList[3], textViewDayList[3],"Thursday, 26 August", "Sunny", "30°", R.drawable.sunny, "4 km/h", "20 %", "2,1 km")
    }

    private fun CardView.updateTodayDayCardWeather(imageView: ImageView, celciusText: TextView, miniDayText: TextView, today: String, condition: String, celcius: String, conditionImage: Int, windValue: String, humidityValue: String, visibilityValue: String) {
        setOnClickListener {

            clearMiniCardBackground()
            miniCardTextsColorReset()

            binding.todayText.text = today
            binding.conditionText.text = condition
            binding.celciusText.text = celcius
            binding.conditionImage.setImageResource(conditionImage)

            binding.windValueText.text = windValue
            binding.humidityText.text = humidityValue
            binding.visibilityText.text = visibilityValue

            imageView.setImageResource(R.drawable.today_weather_gradient)
            celciusText.setTextColor(Color.parseColor("#FFFFFF"))
            miniDayText.setTextColor(Color.parseColor("#DDDDDD"))

        }
    }

    private fun clearMiniCardBackground() {

        for (imageView in imageViewList) {
            imageView.setImageResource(R.drawable.today_weather_white_background)
        }

    }

    private fun miniCardTextsColorReset() {

        for (i in 0 until textViewCelciusList.size) {
            textViewCelciusList[i].setTextColor(Color.parseColor("#000000"))
            textViewDayList[i].setTextColor(Color.parseColor("#979797"))
        }
    }
}