package com.example.jetpackcomposebasics

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import com.example.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicsTheme {
                window.statusBarColor = MaterialTheme.colorScheme.primary.toArgb() // Cambiar el color de la barra de estado
                Scaffold {
                    RangeSliderExample()
                }
            }
        }
    }
}




