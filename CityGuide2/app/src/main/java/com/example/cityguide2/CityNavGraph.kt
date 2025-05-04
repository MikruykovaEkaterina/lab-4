package com.example.cityguide2

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cityguide2.navigation.NavigationRoutes
import com.example.cityguide2.ui.CategoryListScreen
import com.example.cityguide2.ui.RecommendationListScreen
import com.example.cityguide2.ui.RecommendationDetailScreen
import com.example.cityguide2.viewmodel.CityViewModel

@Composable
fun CityNavGraph(
    cityViewModel: CityViewModel,
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.CATEGORIES.name,
        modifier = modifier
    ) {
        composable(NavigationRoutes.CATEGORIES.name) {
            CategoryListScreen(
                categories = cityViewModel.categories,
                onCategoryClick = { category ->
                    cityViewModel.selectCategory(category)
                    navController.navigate(NavigationRoutes.RECOMMENDATIONS.name)
                }
            )
        }
        composable(NavigationRoutes.RECOMMENDATIONS.name) {
            RecommendationListScreen(
                recommendations = cityViewModel.selectedRecommendations,
                onRecommendationClick = { recommendation ->
                    cityViewModel.selectRecommendation(recommendation)
                    navController.navigate(NavigationRoutes.DETAIL.name)
                },
                onBack = { navController.popBackStack() }
            )
        }
        composable(NavigationRoutes.DETAIL.name) {
            RecommendationDetailScreen(
                recommendation = cityViewModel.selectedRecommendation,
                onBack = { navController.popBackStack() }
            )
        }
    }
} 