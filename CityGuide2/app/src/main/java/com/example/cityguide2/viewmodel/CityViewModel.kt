package com.example.cityguide2.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.cityguide2.data.RecommendationRepository
import com.example.cityguide2.model.Recommendation

class CityViewModel : ViewModel() {
    val categories = RecommendationRepository.categories
    var selectedCategory by mutableStateOf<String?>(null)
        private set
    var selectedRecommendations by mutableStateOf<List<Recommendation>>(emptyList())
        private set
    var selectedRecommendation by mutableStateOf<Recommendation?>(null)
        private set

    fun selectCategory(category: String) {
        selectedCategory = category
        selectedRecommendations = RecommendationRepository.recommendations[category] ?: emptyList()
    }

    fun selectRecommendation(recommendation: Recommendation) {
        selectedRecommendation = recommendation
    }
} 