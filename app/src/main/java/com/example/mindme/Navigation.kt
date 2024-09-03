package com.example.mindme

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.PratikFagadiya.smoothanimationbottombar.model.SmoothAnimationBottomBarScreens
import com.PratikFagadiya.smoothanimationbottombar.properties.BottomBarProperties
import com.PratikFagadiya.smoothanimationbottombar.ui.SmoothAnimationBottomBar
import com.example.mindme.presentation.ProfileScreen
import com.example.mindme.util.Routes

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val currentIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    val bottomNavigationItems = listOf(
        SmoothAnimationBottomBarScreens(
            Routes.profileScreen,
            "Chat",
            Icons.Filled.Send,
        ),
        SmoothAnimationBottomBarScreens(
            Routes.profileScreen,
            "Profile",
            Icons.Filled.AccountCircle,
        )
    )

    Scaffold(bottomBar = {
        SmoothAnimationBottomBar(
            navController,
            bottomNavigationItems,
            initialIndex = currentIndex,
            bottomBarProperties = BottomBarProperties(),
            onSelectItem = {
                Log.i("SELECTED_ITEM", "onCreate: Selected Item ${it.name}")
            }
        )
    }) { innerPadding ->
        Modifier.padding(innerPadding)
        ScreenNavigationConfiguration(navController, currentIndex)
    }
}

@Composable
fun ScreenNavigationConfiguration(
    navController: NavHostController,
    currentIndex: MutableIntState
) {
    NavHost(navController = navController, startDestination = Routes.chat) {
        composable(Routes.chat) {
            ProfileScreen(

            )
        }
        composable(Routes.profileScreen) {
            ProfileScreen(

            )
        }
    }
}

