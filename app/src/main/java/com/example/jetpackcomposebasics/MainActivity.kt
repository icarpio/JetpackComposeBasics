package com.example.jetpackcomposebasics

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicsTheme {
                //window.statusBarColor = Color.Magenta.toArgb()
                window.statusBarColor = MaterialTheme.colorScheme.primary.toArgb() // Cambiar el color de la barra de estado
                Scaffold(modifier = Modifier.fillMaxSize(),
                ) {
                    //myRow()
                }
            }
        }
    }
}
@Composable
fun MyBox(name: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Color.Green)
                .verticalScroll(
                    rememberScrollState()
                ), contentAlignment = Alignment.BottomCenter) {
            Text(text = name) // Add some content to the inner Box
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun myColumn(){
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween) {
        Text("Ejemplo1",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo2",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo3",
            Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo3",
            Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .height(100.dp))
        Text("Ejemplo1",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo2",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo3",
            Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo3",
            Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .height(100.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun myRow(){
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())) {
        Text("Ejemplo1",
            Modifier
                .background(Color.Red)
                .width(100.dp))
        Text(text = "Ejemplo2",
            Modifier
                .background(Color.Blue)
                .width(100.dp))
        Text(text = "Ejemplo3",
            Modifier
                .background(Color.Cyan)
                .width(100.dp))
        Text(text = "Ejemplo4",
            Modifier
                .background(Color.Cyan)
                .width(100.dp))
        Text(text = "Ejemplo4",
        Modifier
            .background(Color.Magenta)
            .width(100.dp))
    }
}