package com.nerisal.openswimlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.nerisal.openswimlab.ui.flow.FlowBackground
import com.nerisal.openswimlab.ui.flow.FlowNavigationBar
import com.nerisal.openswimlab.ui.theme.OpenSwimLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            OpenSwimLabTheme(
                dynamicColor = false,
            ) {
                var clicked by remember { mutableStateOf(false) }
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    FlowBackground(
                        modifier = Modifier.fillMaxSize()
                    )

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        FlowNavigationBar(
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }

        }
    }
}