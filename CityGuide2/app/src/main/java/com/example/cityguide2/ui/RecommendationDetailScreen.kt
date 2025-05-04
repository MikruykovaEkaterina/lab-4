package com.example.cityguide2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cityguide2.model.Recommendation

@Composable
fun RecommendationDetailScreen(
    recommendation: Recommendation?,
    onBack: () -> Unit
) {
    if (recommendation == null) return
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        item {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
            }
            Image(
                painter = painterResource(id = recommendation.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
            Spacer(Modifier.height(16.dp))
            Text(recommendation.title, style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(8.dp))
            Text(recommendation.description, style = MaterialTheme.typography.bodyLarge)
        }
    }
} 