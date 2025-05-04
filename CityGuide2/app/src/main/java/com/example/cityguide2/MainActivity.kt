package com.example.cityguide2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cityguide2.ui.theme.CityGuide2Theme
import com.example.cityguide2.viewmodel.CityViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CityGuide2Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val cityViewModel: CityViewModel = viewModel()
                    CityNavGraph(cityViewModel)
                }
            }
        }
    }
}