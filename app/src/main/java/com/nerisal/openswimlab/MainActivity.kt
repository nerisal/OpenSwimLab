package com.nerisal.openswimlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.nerisal.openswimlab.navigation.AppNavHost
import com.nerisal.openswimlab.ui.theme.OpenSwimLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            OpenSwimLabTheme(
                dynamicColor = false,
            ) {
                AppNavHost()
            }
        }

    }
}
